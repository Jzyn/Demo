package controllers;
        import play.mvc.*;

        import views.html.*;
        import play.db.ebean.Transactional;

// Import models
        import models.users.*;
        import models.*;
        import models.shopping.*;

// Import security controllers
        import controllers.security.*;

// Authenticate user
@Security.Authenticated(Secured.class)
// Authorise user (check if user is a customer)
@With(AuthAdmin.class)
public class OrderController extends Controller {

    private User getUserFromSession(){
        return User.getUserById(session().get("email"));
    }

    public Result addToBasket(Long id) {

        // Find the product
        Room r = Room.find.ref(id);


        // Get basket for logged in customer
        User user = User.getUserById(session().get("email"));


        // Check if item in basket
        if (user.getBasket() == null) {
            // If no basket, create one
            user.setBasket(new Basket());
            user.getBasket().setUser(user);
            user.update();
        }

        if(r.getState() == "Booked"){
            return redirect(routes.HomeController.rooms(r.getHotel().getId()));
        }
        // Add product to the basket and save
        user.getBasket().addRoom(r);
        user.update();

        // Show the basket contents
        return ok(basket.render(user));
    }

    @Transactional
    public Result emptyBasket() {

        User u = getUserFromSession();
        u.getBasket().removeAllItems();
        u.getBasket().update();

        return ok(views.html.basket.render(u));
    }


    @Transactional
    public Result placeOrder() {
        User u = getUserFromSession();

        // Create an order instance
        ShopOrder order = new ShopOrder();

        // Associate order with customer
        order.setUser(u);

        // Copy basket to order
        order.setItems(u.getBasket().getBasketItems());

        // Save the order now to generate a new id for this order
        order.save();

        // Move items from basket to order
        for (OrderItem i: order.getItems()) {
            // Associate with order
            i.setOrder(order);
            // Remove from basket
            i.setBasket(null);
            // update item
            i.getRoom().setState("Booked");
            i.getRoom().update();
            i.delete();

        }

        // Update the order
        // causes error when another person tries to book
        // order.update();

        // Clear and update the shopping basket
        u.getBasket().setBasketItems(null);
        u.getBasket().update();

        // Show order confirmed view
        return ok(orderConfirmed.render(u, order));


    }


    public Result showBasket() {

        return ok(basket.render(getUserFromSession()));
    }

    @Transactional
    public Result viewOrder(long id) {
        ShopOrder order = ShopOrder.find.byId(id);
        return ok(orderConfirmed.render(getUserFromSession(), order));
    }


}

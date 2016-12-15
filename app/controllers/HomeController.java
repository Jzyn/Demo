package controllers;

import controllers.*;
import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;
import models.users.*;
import models.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

// Import models


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    // Declare a private FormFactory instance
    private FormFactory formFactory;

    //  Inject an instance of FormFactory it into the controller via its constructor
    @Inject
    public HomeController(FormFactory f) {
        this.formFactory = f;
    }

    private User getUserFromSession(){
        return User.getUserById(session().get("email"));
    }


        public Result index() {
        return ok(index.render(getUserFromSession()));
    }

public Result whatson() {
        return ok(whatson.render(getUserFromSession()));
    }

public Result booking() {
        return ok(booking.render(getUserFromSession()));
    }

public Result contact() {
        return ok(contact.render(getUserFromSession()));
    }

public Result signup() { return ok(signup.render(addUserForm, getUserFromSession()));}

public Result inferno() {
	return ok(inferno.render(getUserFromSession()));
    }

public Result arrival() {
        return ok(arrival.render(getUserFromSession()));
    }

public Result jackreacher() {
        return ok(jackreacher.render(getUserFromSession()));
    }

public Result trolls() {
        return ok(trolls.render(getUserFromSession()));
    }

public Result gott() {
        return ok(gott.render(getUserFromSession()));
    }

public Result joneses() {
        return ok(joneses.render(getUserFromSession()));
    }

public Result kubo() {
        return ok(kubo.render(getUserFromSession()));
    }

public Result fantasticbeasts() {
        return ok(fantasticbeasts.render(getUserFromSession()));
    }


    public Result users(String email){
        List<User> userList = new ArrayList<User>();


            userList = User.findAll();

        return ok(users.render(userList));

    }

    public Result addUser(){
        Form<User> addUserForm = formFactory.form(User.class);

        return ok(addUser.render(addUserForm, getUserFromSession()));
    }
    @Transactional
    public Result addUserSubmit(){
        Form<User> newUserForm = formFactory.form(User.class).bindFromRequest();
        if(newUserForm.hasErrors()){
            return badRequest(addUser.render(newUserForm, getUserFromSession()));
        }
        User u = newUserForm.get();

        if(u.getEmail() == null){
            u.save();
        }
        else if(u.getEmail() != null){
            u.update();
        }
        flash("success", "User " + u.getEmail() + " has been registered.");
        return redirect(controllers.routes.HomeController.users(null));
    }

}

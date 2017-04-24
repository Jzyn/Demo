package controllers;

import play.api.Environment;
import views.html.*;
import controllers.security.*;
import play.data.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
// Import models
import models.shopping.*;
import models.*;
import models.users.User;



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

    // Inject an instance of FormFactory it into the controller via its constructor
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

public Result browse() {
    List<Room> roomsList = new ArrayList<Room>();

    roomsList = Room.findAll();
    return ok(browse.render(roomsList, getUserFromSession()));
}
    // Button helps to filter Hotels
    public Result filtersearchff() {
        List<Room> roomsList = new ArrayList<Room>();

        roomsList = Room.findAll();
        return ok(filtersearchff.render(roomsList, getUserFromSession()));
    }
    // Button helps to filter Hotels
    public Result filtersearchmls() {
        List<Room> roomsList = new ArrayList<Room>();

        roomsList = Room.findAll();
        return ok(filtersearchmls.render(roomsList, getUserFromSession()));
    }
    // Button helps to filter Hotels
    public Result filtersearchwifi() {
        List<Room> roomsList = new ArrayList<Room>();

        roomsList = Room.findAll();
        return ok(filtersearchwifi.render(roomsList, getUserFromSession()));
    }
    // Button helps to filter Hotels
    public Result filtersearchnosmoke() {
        List<Room> roomsList = new ArrayList<Room>();

        roomsList = Room.findAll();
        return ok(filtersearchnosmoke.render(roomsList, getUserFromSession()));
    }

public Result contact() {
    Form<Feedback> feedbackForm = formFactory.form(Feedback.class);

    return ok(contact.render(feedbackForm,getUserFromSession()));
    }


public Result clayton() {
        return ok(clayton.render(getUserFromSession()));
    }
    public Result hilton() {
        return ok(hilton.render(getUserFromSession()));}

public Result ripley() {
        return ok(ripley.render(getUserFromSession()));}

public Result temple() {
        return ok(temple.render(getUserFromSession()));}

public Result jurys() {
        return ok(jurys.render(getUserFromSession()));}


    public Result rooms(Long hot) {
	List<Hotel> hotelsList = Hotel.findAll();
	List<Room> roomsList = new ArrayList<Room>();

	if (hot == 0) {
	roomsList = Room.findAll();
	}
	else {
	    roomsList = Hotel.find.ref(hot).getRooms();
	}
	
	return ok(rooms.render(roomsList, hotelsList, getUserFromSession()));
    }


    @Transactional
    public Result feedbackSubmit() {

        // Create a feedback form object (to hold submitted data)
        // 'Bind' the object to the submitted form (this copies the filled form)
        Form<Feedback> newFeedbackForm = formFactory.form(Feedback.class).bindFromRequest();

        // Check for errors
        if(newFeedbackForm.hasErrors()) {
            // Display the form again
            return badRequest(contact.render(newFeedbackForm, getUserFromSession()));
        }

        // Extract the feedback from the form object
        Feedback f = newFeedbackForm.get();

        if (f.getEmail() == null) {
            // Save to the database via Ebean
            f.save();
        }
        else if (f.getEmail() != null) {
            f.save();
            f.update();
        }


  
         
        

        // Set a success message in temporary flash
        // for display in return view
        flash("success, Feedback has been sent");

        // Redirect to home
        return redirect(routes.HomeController.index());
    }



    public Result signUp() {
        Form<User> signUpForm = formFactory.form(User.class);

        return ok(signup.render(signUpForm, User.getUserById(session().get("email"))));
    }

    public Result signUpSubmit() {

        Form<User> signUpForm = formFactory.form(User.class).bindFromRequest();

        // Check for errors
        if(signUpForm.hasErrors()) {
            // Display the form again
            return badRequest(signup.render(signUpForm, getUserFromSession()));
        }

        User u = signUpForm.get();

        if(u.getEmail().equals(User.find.ref(u.getEmail()))){
            flash("Email already exists");
            return redirect(routes.HomeController.signUp());

        }

            u.setRole("customer");
            u.save();

        // Set a success message in temporary flash
        // for display in return view
        flash("success, Account Created");

        // Redirect to home
        return redirect(routes.HomeController.index());
    }



}


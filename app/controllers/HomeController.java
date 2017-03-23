package controllers;

import controllers.security.Secured;
import controllers.security.AuthAdmin;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

// Import models
import models.*;
import models.users.*;


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

public Result contact() {
        return ok(contact.render(getUserFromSession()));
    }

//public Result signup() { return ok(signup.render(addUserForm, getUserFromSession()));}

public Result clayton() {
	return ok(clayton.render(getUserFromSession()));
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

}

package controllers;

import controllers.security.checkIfAdmin;
import controllers.security.Secured;
import play.data.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import views.html.admin.*;
import models.*;
import models.users.User;

// Require Login
@Security.Authenticated(Secured.class)

// Authorise user (check if admin)
@With(checkIfAdmin.class)

public class AdminController extends Controller {
    public Result index() {
        return ok(index.render(getUserFromSession()));
    }

    // Declare a private FormFactory instance
    private FormFactory formFactory;

    //  Inject an instance of FormFactory it into the controller via its constructor
    @Inject
    public AdminController(FormFactory f) {
        this.formFactory = f;
    }

    // Method returns the logged in user (or null)
    private User getUserFromSession() {
        return User.getUserById(session().get("email"));
    }


    public Result rooms(Long hot) {


        List<Hotel> hotelsList = Hotel.findAll();
        List<Room> roomsList = new ArrayList<Room>();

        if (hot == 0) {
            roomsList = Room.findAll();
        }
        else {
            // Get Rooms for select hotels
            roomsList = Hotel.find.ref(hot).getRooms();
        }

        return ok(adminRooms.render(roomsList, hotelsList, getUserFromSession()));
    }

    public Result addRoom() {

        // Create a form by wrapping the Room class
        Form<Room> addRoomForm = formFactory.form(Room.class);

        // Render the Add Room View, passing the form object
        return ok(addRoom.render(addRoomForm, getUserFromSession()));
    }

    @Transactional
    public Result addRoomSubmit() {

        // Create a Room form object (to hold submitted data)
        // 'Bind' the object to the submitted form (this copies the filled form)
        Form<Room> newRoomForm = formFactory.form(Room.class).bindFromRequest();

        // Check for errors (based on class annotations)
        if(newRoomForm.hasErrors()) {
            // Display the form again
            return badRequest(addRoom.render(newRoomForm, getUserFromSession()));
        }

        // Extract the Room from the form object
        Room r = newRoomForm.get();

        if (r.getId() == null) {
            // Save to the database via Ebean
            r.setState("Available");
            r.save();
        }

        // already exists so update
        else if (r.getId() != null) {
            r.setState("Available");
            r.update();
        }

        // Set a success message in temporary flash
        // for display in return view
        flash("success", "Room ID: " + r.getId() + " has been created/ updated");

        // Redirect back to the Admin rooms view
        return redirect(routes.AdminController.rooms(0));
    }

    // called when edit button is pressed
    @Transactional
    public Result updateRoom(Long id) {

        Room r;
        Form<Room> roomForm;

        try {
            r = Room.find.byId(id);
            r.update();
            // Create a form based on the Room class and fill using r
            roomForm = formFactory.form(Room.class).fill(r);
          
            } catch (Exception ex) {
                // Display an error message or page
                return badRequest("error");
        }

        return ok(addRoom.render(roomForm, getUserFromSession()));
    }

    public Result feedback(){
        List<Feedback> feedbackList = Feedback.findAll();

        return ok(feedback.render(feedbackList,getUserFromSession()));
    }

    // Delete Room by id
    @Transactional
    public Result deleteRoom(Long id) {

        Room.find.ref(id).delete();
        // Add message to flash session
        flash("success", "Room has been deleted");

        return redirect(routes.AdminController.rooms(0));
    }



    public Result deleteMessage(String email) {
       
         Feedback.find.ref(email).delete();

        return redirect(routes.AdminController.feedback());
    }

  public Result deleteAllMessages() {
        List<Feedback> allFeedback = Feedback.findAll();
         for(Feedback f : allFeedback){
		Feedback.find.ref(f.getEmail()).delete();

	}
      flash("success", "All Feedback Cleared Out");
         

        return redirect(routes.AdminController.feedback());
    }
}
  



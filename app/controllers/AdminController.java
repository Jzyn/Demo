package controllers;

import controllers.security.AuthAdmin;
import controllers.security.Secured;
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
@With(AuthAdmin.class)
public class AdminController extends Controller {

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


    public Result movies(Long gen) {

        // Get list of all genres in ascending order
        List<Genre> genresList = Genre.findAll();
        List<Movie> moviesList = new ArrayList<Movie>();

        if (gen == 0) {
            // Get list of all genres in ascending order
            moviesList = Movie.findAll();
        }
        else {
            // Get movies for selected genre
            // Find genre first then extract movies for that cat.
            moviesList = Genre.find.ref(gen).getMovies();
        }

        return ok(movies.render(moviesList, genresList, getUserFromSession()));
    }

    // Render and return  the add new movie page
    // The page will load and display an empty add movie form

    public Result addMovie() {

        // Create a form by wrapping the Movie class
        // in a FormFactory form instance
        Form<Movie> addMovieForm = formFactory.form(Movie.class);

        // Render the Add Movie View, passing the form object
        return ok(addMovie.render(addMovieForm, getUserFromSession()));
    }

    @Transactional
    public Result addMovieSubmit() {

        // Create a movie form object (to hold submitted data)
        // 'Bind' the object to the submitted form (this copies the filled form)
        Form<Movie> newMovieForm = formFactory.form(Movie.class).bindFromRequest();

        // Check for errors (based on Movie class annotations)
        if(newMovieForm.hasErrors()) {
            // Display the form again
            return badRequest(addMovie.render(newMovieForm, getUserFromSession()));
        }

        // Extract the movie from the form object
        Movie m = newMovieForm.get();

        if (m.getId() == null) {
            // Save to the database via Ebean (remember Movie extends Model)
            m.save();
        }
        // Movie already exists so update
        else if (m.getId() != null) {
            m.update();
        }

        // Set a success message in temporary flash
        // for display in return view
        flash("success", "Movie " + m.getName() + " has been created/ updated");

        // Redirect to the admin home
        return redirect(routes.AdminController.movies(0));
    }

    // Update a pmovie by ID
    // called when edit button is pressed
    @Transactional
    public Result updateMovie(Long id) {

        Movie m;
        Form<Movie> movieForm;

        try {
            // Find the movie by id
            m = Movie.find.byId(id);

            // Create a form based on the Movie class and fill using m
            movieForm = formFactory.form(Movie.class).fill(m);

            } catch (Exception ex) {
                // Display an error message or page
                return badRequest("error");
        }
        // Render the updateMovie view - pass form as parameter
        return ok(addMovie.render(movieForm, getUserFromSession()));
    }

    // Delete Movie by id
    @Transactional
    public Result deleteMovie(Long id) {

        // find movie by id and call delete method
        Movie.find.ref(id).delete();
        // Add message to flash session
        flash("success", "Movie has been deleted");

        // Redirect to movies page
        return redirect(routes.AdminController.movies(0));
    }

}

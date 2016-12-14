package controllers;

import play.mvc.*;

import views.html.*;

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
    public Result index() {
        return ok(index.render());
    }

public Result whatson() {
        return ok(whatson.render());
    }

public Result booking() {
        return ok(booking.render());
    }

public Result contact() {
        return ok(contact.render());
    }

public Result signup() {
        return ok(signup.render());
    }

public Result login() {
        return ok(login.render());
    }

public Result inferno() {
	return ok(inferno.render());
    }

public Result arrival() {
        return ok(arrival.render());
    }

public Result jackreacher() {
        return ok(jackreacher.render());
    }

public Result trolls() {
        return ok(trolls.render());
    }

public Result gott() {
        return ok(gott.render());
    }

public Result joneses() {
        return ok(joneses.render());
    }

public Result kubo() {
        return ok(kubo.render());
    }

public Result fantasticbeasts() {
        return ok(fantasticbeasts.render());
    }


}

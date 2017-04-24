package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Feedback extends Model {
    // Properties

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String email;


    private String subject;

    @Constraints.Required
    private String message;

    // Default constructor
    public  Feedback() {
    }

    // Constructor to initialise object
    public Feedback(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;

    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Feedback> find = new Finder<Long,Feedback>(Feedback.class);

    public static List<Feedback> findAll() {
        return Feedback.find.all();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


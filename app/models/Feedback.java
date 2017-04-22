package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;


public class Feedback extends Model {
    // Properties

    private Long id;

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
    public Feedback(Long id, String name, String email, String subject, String message) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.message = message;

    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Feedback> find = new Finder<Long,Feedback>(Feedback.class);

    // Find all Movies in the database
    public static List<Feedback> findAll() {
        return Feedback.find.all();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
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


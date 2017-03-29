package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

// Product Entity managed by the ORM
@Entity
public class Room extends Model {

    // Properties
    // Annotate id as the primary key
    @Id
    private Long id;

    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String description;

    @ManyToOne
    private Hotel hotel;

    @Constraints.Required
    private double price;

    public String state;

    // Default constructor
    public  Room() {
    }

    // Constructor to initialise object
    public Room(Long id, String description, Hotel hotel, double price, String state) {
        this.id = id;
        this.description = description;
        this.hotel = hotel;
        this.price = price;
        this.state = state;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Room> find = new Finder<Long,Room>(Room.class);

    // Find all Movies in the database
    public static List<Room> findAll() {
        return Room.find.all();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

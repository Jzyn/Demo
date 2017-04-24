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

    @Constraints.Required
    private int number;

    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String description;


    @ManyToOne
    private Hotel hotel;

    @Constraints.Required
    private double price;

    private int people;

    private String state;





    // Default constructor
    public  Room() {
    }

    // Constructor to initialise object
    public Room(Long id, int number, String description, Hotel hotel, double price, String state, int people) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.hotel = hotel;
        this.price = price;
        this.state = state;
        this.people = people;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Room> find = new Finder<Long,Room>(Room.class);


    public static List<Room> findAll() {
        return Room.find.all();
}

// Generate options for an HTML select control
public static Map<String,String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap<>();

    // Get all genres from the DB and add to the options Hash map
    for(Hotel h: Hotel.findAll()) {
        options.put(h.getRooms().toString(), h.getName());
    }
    return options;
}

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
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

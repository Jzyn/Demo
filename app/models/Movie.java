package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

// Product Entity managed by the ORM
@Entity
public class Movie extends Model {

    // Properties
    // Annotate id as the primary key
    @Id
    private Long id;

    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String name;

    @ManyToOne
    private Genre genre;

    @Constraints.Required
    private String lead;

    @Constraints.Required
    private int	stock;

    @Constraints.Required
    private double price;

    // Default constructor
    public  Movie() {
    }

    // Constructor to initialise object
    public  Movie(Long id, String name, Genre genre, String lead, int stock, double price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.lead = lead;
        this.stock = stock;
        this.price = price;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Movie> find = new Finder<Long,Movie>(Movie.class);

    // Find all Movies in the database
    public static List<Movie> findAll() {
        return Movie.find.all();
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

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;

// Product Entity managed by the ORM
@Entity
public class Genre extends Model {

    // Properties
    // Annotate id as the primary key
    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<Movie> movies;

    // Default constructor
    public Genre() {

    }

    public Genre(Long id, String name, List<Movie> movies) {
        this.setId(id);
        this.setName(name);
        this.setMovies(movies);
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long,Genre> find = new Finder<Long,Genre>(Genre.class);

    //Find all Movies in the database in ascending order by name
    public static List<Genre> findAll() {
        return Genre.find.where().orderBy("name asc").findList();
    }

    // Generate options for an HTML select control
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();

        // Get all genres from the DB and add to the options Hash map
        for(Genre g: Genre.findAll()) {
            options.put(g.getId().toString(), g.getName());
        }
        return options;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

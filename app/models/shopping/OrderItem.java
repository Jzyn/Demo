package models.shopping;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

import models.Room;
import models.users.*;

    // OrderItem entity managed by Ebean
    @Entity
    public class OrderItem extends Model {

        @Id
        private Long id;

        @ManyToOne
        private ShopOrder order;

        @ManyToOne
        private Basket basket;

        @ManyToOne(cascade = CascadeType.ALL)
        private Room room;

        private double price;

        // Default constructor
        public  OrderItem() {
        }

        public OrderItem(Room r) {
            room = r;
            price = r.getPrice();
        }


        // Calculate and return total price for this order item
        public double getItemTotal() {
            return this.price;
        }

        //Generic query helper
        public static Finder<Long,OrderItem> find = new Finder<Long,OrderItem>(OrderItem.class);

        //Find all Products in the database
        public static List<OrderItem> findAll() {
            return OrderItem.find.all();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ShopOrder getOrder() {
            return order;
        }

        public void setOrder(ShopOrder order) {
            this.order = order;
        }

        public Basket getBasket() {
            return basket;
        }

        public void setBasket(Basket basket) {
            this.basket = basket;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {this.room = room;}

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }




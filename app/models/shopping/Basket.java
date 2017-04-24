package models.shopping;

import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.*;

import models.*;
import models.users.*;


    // Product entity managed by Ebean
    @Entity
    public class Basket extends Model {

        @Id
        private Long id;

        @OneToMany(mappedBy = "basket", cascade = CascadeType.PERSIST)
        private List<OrderItem> basketItems;

        @OneToOne
        private User user;


        // Default constructor
        public  Basket() {
        }

        // Add product to basket
        // Either update existing order item or ad a new one.
        public void addRoom(Room r) {

            boolean itemFound = false;
            // Check if product already in this basket
            // Check if item in basket
            // Find orderitem with this product
            // if found increment quantity
            for (OrderItem i : basketItems) {
                if (i.getRoom().getId() == r.getId()) {
                    itemFound = true;
                    break;
                }
            }
            if (itemFound == false) {
                // Add orderItem to list
                OrderItem newRoom = new OrderItem(r);
                // Add to items
                basketItems.add(newRoom);
            }
        }

        public void removeItem(OrderItem item) {

            // Using an iterator ensures 'safe' removal of list objects
            // Removal of list items is unreliable as index can change if an item is added or removed elsewhere
            // iterator works with an object reference which does not change
            for (Iterator<OrderItem> iter = basketItems.iterator(); iter.hasNext();) {
                OrderItem i = iter.next();
                if (i.getId().equals(item.getId()))
                {
                    // If more than one of these items in the basket then decrement

                    // If only one left, remove this item from the basket (via the iterator)
                        // delete object from db
                        i.delete();
                        // remove object from list
                        iter.remove();
                        break;
                    }
                }
            }


        public void removeAllItems() {
            for(OrderItem i: this.basketItems) {
                i.delete();
            }
            this.basketItems = null;
        }

        public double getBasketTotal() {

             double total = 0;

            for (OrderItem i: basketItems) {
                total += i.getRoom().getPrice() * i.getRoom().getPeople();
            }
            return total;
        }

        public double getUpdatedTotalTEN(){
             double total = getBasketTotal();
            for (OrderItem i: basketItems) {
                total = (i.getRoom().getPrice()) - (i.getRoom().getPrice() /100 * 10);
            }
            return total;

        }
        public double getUpdatedTotalTWENTY(){
             double total = getBasketTotal();
            for (OrderItem i: basketItems) {
                total = (i.getRoom().getPrice()) - (i.getRoom().getPrice() * i.getRoom().getPeople()/100 * 20);
            }
            return total;

        }
        public double getUpdatedTotalTHIRTY(){
            double total = getBasketTotal();
            for (OrderItem i: basketItems) {
                total = (i.getRoom().getPrice() * i.getRoom().getPeople()) - (i.getRoom().getPrice() * i.getRoom().getPeople()/100 * 30);
            }
            return total;

        }

        //Generic query helper
        public static Finder<Long,Basket> find = new Finder<Long,Basket>(Basket.class);

        //Find all Products in the database
        public static List<Basket> findAll() {
            return Basket.find.all();
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<OrderItem> getBasketItems() {
            return basketItems;
        }

        public void setBasketItems(List<OrderItem> basketItems) {
            this.basketItems = basketItems;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }




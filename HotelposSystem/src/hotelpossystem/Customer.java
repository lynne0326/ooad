/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelpossystem;

import java.util.ArrayList;

/**
 *
 * @author lingyanjiang
 */
public class Customer {

    private String name;
    private int id;
    private String gender;
    private ArrayList<Order> order;
    private Payment payment;

    Customer(String name, int id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;

    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Order> getOrder() {
        return this.order;
    }

}

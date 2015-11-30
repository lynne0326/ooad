package hotelpossystem;

import java.util.ArrayList;

/**
 * @author lingyanjiang
 */
public class Customer {

    private String name;
    private int id;
    private String gender;
    private Order currentOrder;
    private ArrayList<Order> order;
    private Payment payment;
    private boolean logedin;
    private static Customer customer;
    
    private Customer() {
        Order order = new Order();
        order.setTotal();
        this.currentOrder = order;
    }
    
    private Customer(String name, int id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public static Customer getCustomerInstance() {
        if(customer==null){
            customer = new Customer();
            return customer;
        }else{
            return customer;
        }
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

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * @return the login
     */
    public boolean isLogedin() {
        return logedin;
    }

    /**
     * @param login the login to set
     */
    public void setLogedin(boolean login) {
        this.logedin = login;
    }

    /**
     * @return the currentOrder
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * @param currentOrder the currentOrder to set
     */
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

}

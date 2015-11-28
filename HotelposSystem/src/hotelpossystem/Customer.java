package hotelpossystem;

import java.util.ArrayList;

/**
 * @author lingyanjiang
 */
public class Customer {

    private String name;
    private int id;
    private String gender;
    private ArrayList<Order> order;
    private Payment payment;
    private boolean login;

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
    public boolean isLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(boolean login) {
        this.login = login;
    }

}

package hotelpossystem;

import java.util.ArrayList;

/**
 * @author Shuang
 */
public class Order {
    private ArrayList <Room> rooms = new ArrayList<>();
    private ArrayList <Service> services;
    private Customer customer;
    private double serviceFee;
    private double roomFee;
    private double discount = 1;

    
    
    public void addService(Service service) {
        services.add(service);
        serviceFee += service.getPrice();
    }
    
    public void addService(ArrayList services) {
        this.services = services;
        for (int i=0; i < services.size(); i++) {
            serviceFee += this.services.get(i).getPrice();
        }
    }
    
    public void subtractService(Service service) {
        services.remove(service);
        serviceFee -= service.getPrice();
    }
    
    public void addRoom(Room room) {System.out.println("ji");
        rooms.add(room);
        roomFee += room.getPrice();       
    }
    
    public void subtractRoom(Room room) {
        rooms.remove(room);
        roomFee -= room.getPrice();       
    }
    
    
    public void getDiscount(double discount) {
        this.discount = discount;
    }
    
    public double getTotalFee() {
        double totalFee = 0;
        if(services.size()!=0){
            for (Service s : services) {
                serviceFee += s.getPrice();
            }
        }
        totalFee = serviceFee+roomFee;
        return totalFee;
    }
    
    
    public ArrayList getService() {
        return services;
    }
    
    public ArrayList getRoom() {
        return rooms;
    }
    

    public double getPoints() {
        return getTotalFee() * 0.1;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setTotal(){
        this.roomFee = 100;
        this.serviceFee = 100;
    }
    
    
}

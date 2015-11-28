package hotelpossystem;

import java.util.ArrayList;

/**
 * @author Shuang
 */
public class Order {
    private ArrayList <Room> rooms;
    private ArrayList <Service> services;
    private double serviceFee;
    private double roomFee;
    private double discount = 1;

    
    void addService(Service service) {
        services.add(service);
        serviceFee += service.getPrice();
    }
    
    void subtractService(Service service) {
        services.remove(service);
        serviceFee -= service.getPrice();
    }
    
    void addRoom(Room room) {
        rooms.add(room);
        roomFee += room.getPrice();       
    }
    
    void subtractRoom(Room room) {
        rooms.remove(room);
        roomFee -= room.getPrice();       
    }
    
    
    void getDiscount(double discount) {
        this.discount = discount;
    }
    
    double getTotalFee() {
        return (serviceFee + roomFee) * (1 - discount);
    }
    
    
    ArrayList getService() {
        return services;
    }
    
    ArrayList getRoom() {
        return rooms;
    }
    
    double getPoints() {
        return getTotalFee() * 0.1;
    }
    
    
    
    
}

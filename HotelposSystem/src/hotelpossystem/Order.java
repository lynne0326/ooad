/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelpossystem;

import hotelpossystem.Service;
import java.util.ArrayList;

/**
 *
 * @author Shuang
 */
public class Order {
    private ArrayList <Room> rooms;
    private ArrayList <Service> services;
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
    
    public void addRoom(Room room) {
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
        return (serviceFee + roomFee) * (1 - discount);
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
    
    
    
    
}

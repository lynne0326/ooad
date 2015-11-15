/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelpossystem;

/**
 *
 * @author lingyanjiang
 */
public class Customer {
    String name;
    int id;
    String gender;
    Room room;
    Order order;
    Date checkInTime;
    Date checkOutTime;
    Customer(String name,int id,String gender){
        this.name=name;
        this.id=id;
        this.gender=gender;
    }
    public void selectTime(){
        
    }
    public void selectRoom(){
        
    }
    public void selectService(String name){
        Service service=new Service(name);
    }
    public void selectPaymentMethod(){
        if(){}
    }
    public PayByCard payByCard(){
        
    }
}

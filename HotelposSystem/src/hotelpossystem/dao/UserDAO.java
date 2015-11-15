package hotelpossystem.dao;

import hotelpossystem.Order;
import hotelpossystem.Payment;

/**
 * This interface defines query statements
 * @author lingyanjiang
 */
import hotelpossystem.Customer;
import hotelpossystem.Room;
import hotelpossystem.Service;
import java.util.Date;

public interface UserDAO {
    
    public void insert(Order order) throws Exception;
    public void insert(Payment payment) throws Exception;
    public void insert(Customer customer) throws Exception;
    public void insert(Service service) throws Exception;
    public void update(Order order) throws Exception;
    public void update(Customer customer) throws Exception;
    public void update(Room room) throws Exception;
    public void delete(Order order) throws Exception;
    public boolean queryLogin(String username, String password) throws Exception;
    public void queryOrder(Order order) throws Exception;
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate) throws Exception;
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate, String roomtype) throws Exception;  
    public void queryRoomAvailableFloor(Date checkinDate, Date checkoutDate, String floor) throws Exception;
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate, String floor, String roomtype) throws Exception;
    public void queryRoomAvailableByRoomNumber(String roomnumber);
}

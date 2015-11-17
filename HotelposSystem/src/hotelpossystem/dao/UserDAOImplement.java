package hotelpossystem.dao;

import UI.BookRoom;
import hotelpossystem.Customer;
import hotelpossystem.Order;
import hotelpossystem.Payment;
import hotelpossystem.Room;
import hotelpossystem.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lingyanjiang
 */
public class UserDAOImplement implements UserDAO{

    @Override
    /**
     * This method is to insert new order to database
     */
    public void insert(Order order) throws Exception {
        try(Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement();        
            ){
            state.execute("insert into orders values(1,2,102,2,'Supper')");
        }
    }

    @Override
    public void insert(Payment payment) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Customer customer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Service service) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Order order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Customer customer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Room room) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean queryLogin(String username, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryOrder(Order order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate) throws Exception {      
        
        
    }

    /**
     *
     * @param checkinDate
     * @param checkOutDate
     * @throws SQLException
     */
    @Override
    public void queryRoomAvailable(int checkinDate, int checkOutDate) throws SQLException {
//        BookRoom room=new BookRoom();
//        DefaultTableModel tableModel = (DefaultTableModel) room.jTableR.getModel();
//        String s1="1";
//        String s2="2";
//        String s3="2";
//        String s4="2";
//        String[] s=new String[]{s1,s2,s3,s4};
//        room.getTableModel().addRow(s);
        
    }
    
    @Override
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate, String roomtype) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryRoomAvailableFloor(Date checkinDate, Date checkoutDate, String floor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate, String floor, String roomtype) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void queryRoomAvailableByRoomNumber(String roomnumber) {
        try(Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("select * from room")
            ){
            while(rs.next()) {
            System.out.println(rs.getString("ID"));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void queryTest() throws SQLException {
        try(Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("select * from room")
            ){
            while(rs.next()) {
            System.out.println(rs.getString("ID"));
                    }
        }
    }
    
}

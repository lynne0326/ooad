package hotelpossystem.dao;

import hotelpossystem.Customer;
import hotelpossystem.Order;
import hotelpossystem.Payment;
import hotelpossystem.Room;
import hotelpossystem.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lingyanjiang
 */
public class UserDAOImplement implements UserDAO {

    
    
   
        
    @Override
    /**
     * This method is to insert new order to database
     */
    public void insert(Order order) throws Exception {
        try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();) {
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
        String sql = "select * from customer where username= '" + username + "' and password ='" + password + "'";
        try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();) {
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public void queryCustomer(String username) {
        String sql = "select * from customer where username='" + username+"'";
        ResultSet rs = null;
        Customer customer = Customer.getCustomerInstance();
        try(Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement()){
            rs = state.executeQuery(sql);
            while(rs.next()){
                    customer.setName(rs.getString("name"));
                    customer.setGender(rs.getString("gender"));
                    customer.setUserName(rs.getString("username"));
                    customer.setScore(rs.getInt("score"));
                    customer.setRoomNum(rs.getString("roomstatus"));
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String[] queryRoomAvailableByRoomNumber(String customerName) {
        String[] ss = null;
         try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery("select * from customer where username="+"'"+customerName+"';")) {               
                
                String name = null, room = null,price=null;
                
                Date checkinTime = null, checkoutTime = null;
            while (rs.next()) {
                name = rs.getString("name");
                room = rs.getString("roomstatus");
                checkinTime = rs.getDate("checkintime");
                checkoutTime = rs.getDate("checkouttime");         
            }
            ResultSet rs1= state.executeQuery("select  price from room where ID="+"'"+room+"'");
            while(rs1.next()) {
                price=(rs1.getString("price"));
            }
            ss = new String[]{name, room, price,checkinTime.toString(), checkoutTime.toString()};
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplement.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ss;
    }
    
    @Override
    public void queryOrder(Order order) throws Exception {
        
    }

    @Override
    public void queryRoomAvailable(Date checkinDate, Date checkoutDate) throws Exception {

    }
            
            

    /**
     *
     * @param checkinDate
     * @param checkOutDate
     * @return
     * @throws SQLException
     */
    class Result {

        String id;
        String floor;
    }

    @Override
    public HashSet<String[]> queryRoomAvailable(int checkinDate, int checkOutDate) throws SQLException {
        ResultSet r, r1;
        //ArrayList<Result> rs=new ArrayList();
        String id = null, floor = null, type = null, price = null;
        //String[] s=new String[]{id,floor,type,price};
        HashSet<String[]> as = new HashSet<>();
        HashSet<String> idHash = new HashSet<>();
        String[] s;
        try {
            Connection conn = new DatabaseConnection().getConnection();
            conn.setAutoCommit(false);
            Statement state = conn.createStatement();
            int in = checkinDate;
            int out = checkOutDate;
            int idInt;
            for (in = checkinDate; in < out; in++) {
                String ins = String.valueOf(in);
                r1 = state.executeQuery("select * from room where day" + ins + "=true");
                while (r1.next()) {
                    id = r1.getString("ID");
                    floor = r1.getString("floor");
                    type = r1.getString("type");
                    price = r1.getString("price");
                    //idInt=Integer.parseInt(id);                   
                    if (idHash.add(id)) {
                        s = new String[]{id, floor, type, price};
                        as.add(s);
                    }
                }

            }

        } catch (Exception e) {
        }

        return as;
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

//    @Override
//    public void queryRoomAvailableByRoomNumber(String roomnumber) {
//        try (Connection conn = new DatabaseConnection().getConnection();
//                Statement state = conn.createStatement();
//                ResultSet rs = state.executeQuery("select * from room")) {
//            while (rs.next()) {
//                System.out.println(rs.getString("ID"));
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAOImplement.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void queryTest() throws SQLException, ClassNotFoundException {
        try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery("select * from room")) {
            while (rs.next()) {
                System.out.println(rs.getString("ID"));
            }
        }
    }
    
    public ResultSet queryGetOrder() {
        ResultSet rs = null;
        try (Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement();
            ) { 
            rs = state.executeQuery("select * from order");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }return rs; 
    }
    
    @Override
    public boolean queryRoomAvailableToRenew(String customerName) throws ClassNotFoundException, SQLException {
        boolean flag=true;
        try(Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery("select roomstatus from customer where username="+customerName)){
                ResultSet rs2;
            while(rs.next()) {
                rs2=state.executeQuery("select day2 from room where id="+rs.getString("id"));
                if(rs2.getBoolean("day2")) {
                    flag=true;
                }
                else
                    flag=false;
            }
        }
        if(flag)
            return true;
        else
            return false;
    }

}

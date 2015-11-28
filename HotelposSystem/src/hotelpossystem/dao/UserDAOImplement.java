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
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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
        String sql = "select * from customer where name='" + username + "'and password='" + password + "'";
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
    public void queryOrder(Order order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public
            void queryRoomAvailable(Date checkinDate, Date checkoutDate) throws Exception {

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
                    System.out.println("this is mark");
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

    @Override
    public void queryRoomAvailableByRoomNumber(String roomnumber) {
        try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery("select * from room")) {
            while (rs.next()) {
                System.out.println(rs.getString("ID"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplement.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void queryTest() throws SQLException, ClassNotFoundException {
        try (Connection conn = new DatabaseConnection().getConnection();
                Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery("select * from room")) {
            while (rs.next()) {
                System.out.println(rs.getString("ID"));
            }
        }
    }

}

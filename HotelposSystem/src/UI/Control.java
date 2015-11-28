package UI;

import hotelpossystem.dao.DAOFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lingyanjiang
 */
public class Control {
    public int count = 0;
    
    public void runn(JTable jTableR, int from, int to) throws Exception {
        count=0;
        DefaultTableModel tableModel = (DefaultTableModel) jTableR.getModel();
        int in =from+1;
        int out =to+1;
       
        HashSet<String[]> as = new HashSet<>();
        as=DAOFactory.getUserDAOInstance().queryRoomAvailable(in, out);          
        for(String[] a: as) {
            tableModel.addRow(a);
            count++;
        }
        
    }
    
    public void activeSearch(JComboBox jCBF,JComboBox jCBT,JTable jTableR,int from, int to) {
        DefaultTableModel tableModel = (DefaultTableModel) jTableR.getModel();
        tableModel.setRowCount(0);
        try {
            runn(jTableR, from, to);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(jCBF.getSelectedIndex()==1) {
            if(jCBT.getSelectedIndex()==0) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==1) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")|| !tableModel.getValueAt(index,2).equals("normal1")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==2) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")|| !tableModel.getValueAt(index,2).equals("normal2")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==3) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")|| !tableModel.getValueAt(index,2).equals("big1")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==4) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")|| !tableModel.getValueAt(index,2).equals("big2")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
        }
        if(jCBF.getSelectedIndex()==2) {
            if(jCBT.getSelectedIndex()==0) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level2")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==1) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level2")||!tableModel.getValueAt(index,2).equals("normal1")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==2) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level1")||!tableModel.getValueAt(index,2).equals("normal2")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==3) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level2")||!tableModel.getValueAt(index,2).equals("big1")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }
            if(jCBT.getSelectedIndex()==4) {
                for(int index=0; index < count;index++ ) {
                    if(!tableModel.getValueAt(index,1).equals("level2")|| !tableModel.getValueAt(index,2).equals("big2")) {
                        tableModel.removeRow(index);
                        index--; count--;
                    }
                }
            }

        }
    }
    
    public void intiateDate(JComboBox jCbFrom,JComboBox jCbTo,JLabel jLbWarning,int from, int to) {                                  
        Date dt = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String today = "";
        today = sf.format(dt);
        String[] next = new String[6];
        Calendar cal = Calendar.getInstance();
        jCbFrom.addItem(today);
        
        //jCbTo.addItem(today);
        for (int i = 0; i < 5; i++) {
            try {
                cal.setTime(sf.parse(today));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            cal.add(Calendar.DAY_OF_YEAR, +(i+1));
            next[i] = sf.format(cal.getTime());
            jCbFrom.addItem(next[i]);
            jCbTo.addItem(next[i]);
        }
        
        if (jCbTo.getSelectedIndex() < jCbFrom.getSelectedIndex()) {
            jLbWarning.setText("The check out time should after the check in time");
        } 
        else {
            from = jCbFrom.getSelectedIndex();           
            to = jCbTo.getSelectedIndex();            
                     
        }
    }
    
    
}

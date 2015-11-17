/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelpossystem.dao;

import UI.BookRoom;

/**
 *
 * @author Jingshiqing
 */
public class NewClass {
    public void run(){
    BookRoom room=new BookRoom();
    //room=room.bookRoom;

    String s11="ee";
    String s21="ee";
    String s31="ee";
                String s41="ee";                
                String sss[] = new String[]{s11, s21, s31, s41};
    //room.getTableModel().addRow(sss);
    room.getTableModel().getValueAt(0, 0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelpossystem;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author XiaoSong
 */
public class PaymentFactory {

    public Payment getPayMethod(String payType) {
        if (payType.equalsIgnoreCase("PAYBYCARD")) {
            return new PayByCard();
        }

        if (payType.equalsIgnoreCase("PAYBYCASH")) {
            return new PayByCash();
        }
        return null;
    }
}

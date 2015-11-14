/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static quanlykhachsan.constant_Cls.closeConnect;
import static quanlykhachsan.constant_Cls.openConnect;

/**
 *
 * @author naruto
 */
public class demosql {

    public static void main(String[] args) {
        try {
            Connection con = constant_Cls.openConnect();
            PreparedStatement update = con.prepareStatement("update phong_tbl set p_tinhtrang = ?,P_loai = "
              + "? where p_id=?");
            update.setString(1, "có khách");
            update.setString(2, "A");
            update.setInt(3, 1);
            update.addBatch();
            update.setString(1, "có khách");
            update.setString(2, "A");
            update.setInt(3, 2);
            update.addBatch();
            int count[] = update.executeBatch();
            for(int i=1;i<=count.length;i++){
                System.out.println("Query "+i+" has effected "+count[i-1]+" times");
            }
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

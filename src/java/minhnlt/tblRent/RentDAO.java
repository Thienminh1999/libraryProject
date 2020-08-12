/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblRent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import minhnlt.Utils.DBUtil;

/**
 *
 * @author ADMIN
 */
public class RentDAO {
    public void insertRent(RentDTO dto) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "insert into tblRent(RentID, RentDate, ReturnDate, UserID) values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getRentID());
                stm.setString(2, dto.getRentDate());
                stm.setString(3, dto.getReturnDate());
                stm.setString(4, dto.getUserID());
                stm.executeUpdate();
            }
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
}

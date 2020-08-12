/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblRentDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import minhnlt.Utils.DBUtil;
import minhnlt.tblRent.RentDTO;

/**
 *
 * @author ADMIN
 */
public class RentDetailDAO {
    public void insertRentDetail(RentDetailDTO dto) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "insert into tblRentDetail(RentID, BookID, Quantity) values(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getRentID());
                stm.setString(2, dto.getBookID());
                stm.setInt(3, dto.getQuantity());
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

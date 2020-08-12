/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import minhnlt.Utils.DBUtil;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
    UserDTO dto;

    public UserDTO getDto() {
        return dto;
    }
    
    public boolean checkLogin(String username, String password) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "SELECT UserID, UserName, Password, FullName, PhoneNumber, Address, RoleName "
                        + "FROM tblUser u, tblRole r "
                        + "WHERE u.RoleID = r.RoleID AND UserName = ? and Password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String UserID = rs.getString("UserID");
                    String UserName = rs.getString("UserName");
                    String Password = rs.getString("Password");
                    String FullName = rs.getString("FullName");
                    String PhoneNumber = rs.getString("PhoneNumber");
                    String Address = rs.getString("Address");
                    String Role = rs.getString("RoleName");
                    UserDTO userdto = new UserDTO(UserID, UserName, Password, FullName, PhoneNumber, Address, Role);
                    this.dto = userdto;
                    return true;
                }
            }
        }finally{
            if(rs!=null)rs.close();
            if(stm!=null)stm.close();
            if(con!=null)con.close();
        }
        return false;
    }
}

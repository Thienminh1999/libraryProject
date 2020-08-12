/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblAuthor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import minhnlt.Utils.DBUtil;

/**
 *
 * @author ADMIN
 */
public class AuthorDAO {
    List<AuthorDTO> listAuthor;

    public List<AuthorDTO> getListAuthor() {
        return listAuthor;
    }
    
    List<AuthorDTO> listAllAuthor;

    public List<AuthorDTO> getListAllAuthor() {
        return listAllAuthor;
    }
    
    
    
    public void loadAuthor() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "select top(7) AuthorID, AuthorName, AuthorImage "
                        + "from tblAuthor";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("AuthorID");
                    String name = rs.getString("AuthorName");
                    String image = rs.getString("AuthorImage");
                    AuthorDTO dto = new AuthorDTO(id, name, image);
                    if(listAuthor == null){
                        listAuthor = new ArrayList<>();
                    }
                    listAuthor.add(dto);
                }
            }
        }finally{
            if(rs!=null)rs.close();
            if(stm!=null)stm.close();
            if(con!=null)con.close();
        }
    }
    
    public void loadAllAuthor() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "select AuthorID, AuthorName, AuthorImage "
                        + "from tblAuthor";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("AuthorID");
                    String name = rs.getString("AuthorName");
                    String image = rs.getString("AuthorImage");
                    AuthorDTO dto = new AuthorDTO(id, name, image);
                    if(listAllAuthor == null){
                        listAllAuthor = new ArrayList<>();
                    }
                    listAllAuthor.add(dto);
                }
            }
        }finally{
            if(rs!=null)rs.close();
            if(stm!=null)stm.close();
            if(con!=null)con.close();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblCategory;

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
public class CategoryDAO {
    List<CategoryDTO> listCategory;

    public List<CategoryDTO> getListCategory() {
        return listCategory;
    }
    

    public void loadCategory() throws NamingException, SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select CategoryID, CategoryName "
                        + "from tblCategory";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("CategoryID");
                    String name = rs.getString("CategoryName");
                    CategoryDTO dto = new CategoryDTO(id, name);
                    if (listCategory == null) {
                        listCategory = new ArrayList<>();
                    }
                    listCategory.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}

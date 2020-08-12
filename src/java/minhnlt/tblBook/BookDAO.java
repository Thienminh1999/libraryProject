/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblBook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import minhnlt.Utils.DBUtil;
import minhnlt.statisticObj.StatisticDTO;

/**
 *
 * @author ADMIN
 */
public class BookDAO {

    List<BookDTO> listBook;
    List<BookDTO> listAllBook;
    List<BookDTO> listAllBookAdmin;
    List<BookDTO> listSearchBook;
    List<StatisticDTO> listStatisticDTO;

    public List<BookDTO> getListBook() {
        return listBook;
    }

    public List<BookDTO> getListAllBook() {
        return listAllBook;
    }

    public List<BookDTO> getListSearchBook() {
        return listSearchBook;
    }

    public List<BookDTO> getListAllBookAdmin() {
        return listAllBookAdmin;
    }

    public List<StatisticDTO> getListStatisticDTO() {
        return listStatisticDTO;
    }
    

    public void loadBook() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select top(12) BookID, BookName, BookImage "
                        + "from tblBook";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");

                    String image = rs.getString("BookImage");
                    dto = new BookDTO(id, name, image);
                    if (listBook == null) {
                        listBook = new ArrayList<>();
                    }
                    listBook.add(dto);
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

    public void loadAllBook() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, BookImage "
                        + "from tblBook";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");

                    String image = rs.getString("BookImage");
                    BookDTO dto = new BookDTO(id, name, image);
                    if (listAllBook == null) {
                        listAllBook = new ArrayList<>();
                    }
                    listAllBook.add(dto);
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

    public void loadAllBookAdmin() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, Publisher, PublicDate "
                        + "from tblBook";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");

                    String publisher = rs.getString("Publisher");
                    String publicDate = rs.getString("PublicDate");

                    BookDTO dto = new BookDTO(id, name, publisher, publicDate);
                    if (listAllBookAdmin == null) {
                        listAllBookAdmin = new ArrayList<>();
                    }
                    listAllBookAdmin.add(dto);
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

    public void searchBookAdmin(String searchValue) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, Publisher, PublicDate "
                        + "from tblBook "
                        + "where BookName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");

                    String publisher = rs.getString("Publisher");
                    String publicDate = rs.getString("PublicDate");

                    BookDTO dto = new BookDTO(id, name, publisher, publicDate);
                    if (listAllBookAdmin == null) {
                        listAllBookAdmin = new ArrayList<>();
                    }
                    listAllBookAdmin.add(dto);
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

    public void searchBook(String bookName) throws NamingException, SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, BookImage "
                        + "from tblBook "
                        + "where BookName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + bookName + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");

                    String image = rs.getString("BookImage");
                    BookDTO dto = new BookDTO(id, name, image);
                    if (listSearchBook == null) {
                        listSearchBook = new ArrayList<>();
                    }
                    listSearchBook.add(dto);
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

    public BookDTO loadBookDetail(String bookId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, Publisher, PublicDate, Size, TypeOfCover, PageNumber, Descriptions, BookImage "
                        + "from tblBook "
                        + "where BookID like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + bookId + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");
                    String Publisher = rs.getString("Publisher");
                    String PublicDate = rs.getString("PublicDate");
                    String Size = rs.getString("Size");
                    String TypeOfCover = rs.getString("TypeOfCover");
                    int PageNumber = rs.getInt("PageNumber");
                    String Descriptions = rs.getString("Descriptions");
                    String image = rs.getString("BookImage");
                    //String categoryID = rs.getString("CategoryID");
                    dto = new BookDTO(bookId, name, Publisher, PublicDate, Size, TypeOfCover, PageNumber, Descriptions, image);

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
        return dto;
    }
    
    public BookDTO loadBookInfor(String bookId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select BookID, BookName, Publisher, PublicDate, Size, TypeOfCover, PageNumber, Descriptions, BookImage, CategoryID, Quantity "
                        + "from tblBook "
                        + "where BookID like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + bookId + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("BookID");
                    String name = rs.getString("BookName");
                    String Publisher = rs.getString("Publisher");
                    String PublicDate = rs.getString("PublicDate");
                    String Size = rs.getString("Size");
                    String TypeOfCover = rs.getString("TypeOfCover");
                    int PageNumber = rs.getInt("PageNumber");
                    String Descriptions = rs.getString("Descriptions");
                    String image = rs.getString("BookImage");
                    String categoryID = rs.getString("CategoryID");
                    int quantity = rs.getInt("Quantity");
                    dto = new BookDTO(bookId, name, Publisher, PublicDate, Size, TypeOfCover, PageNumber, Descriptions, image, categoryID, quantity);

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
        return dto;
    }

    public String getAuthor(String bookID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String authorname = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select a.AuthorName "
                        + "from tblBook b, tblCompose c, tblAuthor a "
                        + "where b.BookID = c.BookID and c.AuthorID = a.AuthorID and b.BookID like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + bookID + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    authorname = rs.getString("AuthorName");
                    return authorname;
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
        return authorname;
    }

    public int getQuantityInDB(String bookId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "select Quantity "
                        + "from tblBook "
                        + "where BookID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("Quantity");
                    return quantity;
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
        return quantity;
    }

    public void updateBookQuantity(String BookId, int rentQuantity) throws NamingException, SQLException {
        int befRentQuantity = getQuantityInDB(BookId);
        String aftRentQuantity = befRentQuantity - rentQuantity + "";
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "UPDATE tblBook "
                        + "SET Quantity = ? "
                        + "where BookID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, aftRentQuantity);
                stm.setString(2, BookId);
                stm.executeUpdate();
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

    public boolean insertNewBook(BookDTO book) throws NamingException, SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int row = 0;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "insert into tblBook(BookID, BookName, Publisher, PublicDate, Quantity, Size, TypeOfCover, PageNumber, Descriptions, CategoryID, BookImage) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, book.getBookID());
                stm.setString(2, book.getBookName());
                stm.setString(3, book.getPublisher());
                stm.setString(4, book.getPublicDate());
                stm.setInt(5, book.getQuantity());
                stm.setString(6, book.getSize());
                stm.setString(7, book.getTypeOfCover());
                stm.setInt(8, book.getPageNumber());
                stm.setString(9, book.getDescriptions());
                stm.setString(10, book.getCategoryID());
                stm.setString(11, book.getBookImage());
                row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }

    public boolean deleteBook(String bookID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int row = 0;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "delete from tblBook "
                        + "where BookID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookID);
                row = stm.executeUpdate();
                if(row>0){
                    return true;
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
        return false;
    }
    
    
    public boolean updateBook(BookDTO book) throws SQLException, NamingException{
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "UPDATE tblBook "
                        + "SET BookName = ?,"
                        + " Publisher = ?,"
                        + " PublicDate = ?,"
                        + " Quantity = ?,"
                        + " Size = ?,"
                        + " TypeOfCover = ?,"
                        + " PageNumber = ?,"
                        + " Descriptions = ?,"
                        + " CategoryID = ? "
                        + "where BookID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, book.getBookName());
                stm.setString(2, book.getPublisher());
                stm.setString(3, book.getPublicDate());
                stm.setInt(4, book.getQuantity());
                stm.setString(5, book.getSize());
                stm.setString(6, book.getTypeOfCover());
                stm.setInt(7, book.getPageNumber());
                stm.setString(8, book.getDescriptions());
                stm.setString(9, book.getCategoryID());
                stm.setString(10, book.getBookID());
                int row = stm.executeUpdate();
                if(row>0){
                    return true;
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
        return false;
    }
    
    public void searchAsDate(String fromDate, String toDate) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.makeConnection();
            if(con!=null){
                String sql = "select b.BookName, rd.Quantity, u.FullName, u.UserID, r.RentDate, r.ReturnDate "
                        + "from tblRent r, tblRentDetail rd, tblBook b, tblUser u "
                        + "where r.RentID = rd.RentID and rd.BookID = b.BookID and r.UserID = u.UserID "
                        + "and RentDate between ? and ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, fromDate);
                stm.setString(2, toDate);
                rs = stm.executeQuery();
                while(rs.next()){
                    String BookName = rs.getString("BookName");
                    int Quantity = rs.getInt("Quantity");
                    String FullName = rs.getString("FullName");
                    String UserID = rs.getString("UserID");
                    Date RentDate = rs.getDate("RentDate");
                    Date ReturnDate = rs.getDate("ReturnDate");
                    StatisticDTO dto = new StatisticDTO(BookName, Quantity, FullName, UserID, RentDate.toString(), ReturnDate.toString());
                    if(this.listStatisticDTO == null){
                        listStatisticDTO = new ArrayList<>();
                    }
                    listStatisticDTO.add(dto);
                }
            }
        }finally{
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

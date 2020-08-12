/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblRentDetail;

/**
 *
 * @author ADMIN
 */
public class RentDetailDTO {
    private String rentID;
    private String bookID;
    private int quantity;

    public RentDetailDTO(String rentID, String bookID, int quantity) {
        this.rentID = rentID;
        this.bookID = bookID;
        this.quantity = quantity;
    }
    
    /**
     * @return the rentID
     */
    public String getRentID() {
        return rentID;
    }

    /**
     * @param rentID the rentID to set
     */
    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    /**
     * @return the bookID
     */
    public String getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    
}

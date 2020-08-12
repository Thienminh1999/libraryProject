/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblRent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public class RentDTO {
    private String rentID;
    private String rentDate;
    private String returnDate;
    private String userID;

    public RentDTO() {
    }

    public RentDTO(String userID) {
        UUID uuid = UUID.randomUUID();
        this.rentID = uuid.toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();  
        this.rentDate = dtf.format(now);
        this.returnDate = dtf.format(now.plusMonths(3));
        this.userID = userID;
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
     * @return the rentDate
     */
    public String getRentDate() {
        return rentDate;
    }

    /**
     * @param rentDate the rentDate to set
     */
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblUser;

/**
 *
 * @author ADMIN
 */
public class UserDTO {
    private String userid;
    private String userName;
    private String userPassword;
    private String userFullName;
    private String userPhoneNumber;
    private String userAddress;
    private String roleName;

    public UserDTO(String userid, String userName, String userPassword, String userFullName, String userPhoneNumber, String userAddress, String roleName) {
        this.userid = userid;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userFullName
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     * @param userFullName the userFullName to set
     */
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    /**
     * @return the userPhoneNumber
     */
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    /**
     * @param userPhoneNumber the userPhoneNumber to set
     */
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    /**
     * @return the userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * @param userAddress the userAddress to set
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    
    
}

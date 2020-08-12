/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblAuthor;

/**
 *
 * @author ADMIN
 */
public class AuthorDTO {
    private String authorID;
    private String authorName;
    private String authorImage;

    public AuthorDTO(String authorID, String authorName, String authorImage) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorImage = authorImage;
    }
    
    /**
     * @return the authorID
     */
    public String getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the authorImage
     */
    public String getAuthorImage() {
        return authorImage;
    }

    /**
     * @param authorImage the authorImage to set
     */
    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }
    
    
    
}

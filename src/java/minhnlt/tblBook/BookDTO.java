/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.tblBook;

/**
 *
 * @author ADMIN
 */
public class BookDTO {
    private String bookID;
    private String bookName;
    private String publisher;
    private String publicDate;
    private int quantity;
    private String size;
    private String typeOfCover;
    private int pageNumber;
    private String descriptions;
    private String bookImage;
    private String CategoryID;

    public BookDTO(String bookID, String bookName, String publisher, String publicDate, int quantity, String size, String typeOfCover, int pageNumber, String descriptions, String CategoryID) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publicDate = publicDate;
        this.quantity = quantity;
        this.size = size;
        this.typeOfCover = typeOfCover;
        this.pageNumber = pageNumber;
        this.descriptions = descriptions;
        this.CategoryID = CategoryID;
        this.bookImage = "resource/img/book/default-book-picture.png";
    }
    
    

    public BookDTO(String bookID, String bookName, String publisher, String publicDate, String size, String typeOfCover, int pageNumber, String descriptions, String bookImage) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publicDate = publicDate;
        
        this.size = size;
        this.typeOfCover = typeOfCover;
        this.pageNumber = pageNumber;
        this.descriptions = descriptions;
        this.bookImage = bookImage;
    }
    
    public BookDTO(String bookID, String bookName, String publisher, String publicDate, String size, String typeOfCover, int pageNumber, String descriptions, String bookImage, String categoryID, int quantity ) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publicDate = publicDate;
        
        this.size = size;
        this.typeOfCover = typeOfCover;
        this.pageNumber = pageNumber;
        this.descriptions = descriptions;
        this.bookImage = bookImage;
        this.CategoryID = categoryID;
        this.quantity = quantity;
    }

    public BookDTO(String bookID, String bookName, String bookImage) {
        this.bookID = bookID;
        this.bookName = bookName;
        
        this.bookImage = bookImage;
    }

    public BookDTO(String bookID, String bookName, String publisher, String publicDate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publisher = publisher;
        this.publicDate = publicDate;
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
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
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the publicDate
     */
    public String getPublicDate() {
        return publicDate;
    }

    /**
     * @param publicDate the publicDate to set
     */
    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * @return the price
     */
    

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the typeOfCover
     */
    public String getTypeOfCover() {
        return typeOfCover;
    }

    /**
     * @param typeOfCover the typeOfCover to set
     */
    public void setTypeOfCover(String typeOfCover) {
        this.typeOfCover = typeOfCover;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the descriptions
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * @return the bookImage
     */
    public String getBookImage() {
        return bookImage;
    }

    /**
     * @param bookImage the bookImage to set
     */
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    
    
     
}

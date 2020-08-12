/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import minhnlt.tblBook.BookDTO;

/**
 *
 * @author ADMIN
 */
public class CartObj {

//    private ArrayList<BookDTO> listBookCart = new ArrayList<>();
//   
    private Map<String, BookDTO> cart;
    //private int size;
    public CartObj(Map<String, BookDTO> cart) {
        this.cart = cart;
       
    }
    /**
     * @return the cart
     */
    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public CartObj() {
        
    }
//
//    public int getSize() {
//        return size;
//    }

//    public void setSize(int size) {
//        this.size = size;
//    }
    
    public boolean checkQuantityBook(BookDTO book ,int quantityInDB){
        if(this.cart == null) return true;
        if(!this.cart.containsKey(book.getBookID())) return true;
        int quantity = this.cart.get(book.getBookID()).getQuantity();
        if(quantity >= quantityInDB) return false;
        return true;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public boolean addToCart(BookDTO dto, int quantityAdd) {
        if(quantityAdd <=0 ){
            return false;
        }
        if (this.cart == null) {
            cart = new HashMap<>();
        }
        
        if (this.cart.containsKey(dto.getBookID())) {
            int quantity = this.cart.get(dto.getBookID()).getQuantity();
            dto.setQuantity(quantity + quantityAdd);
        }else{
            dto.setQuantity(quantityAdd);
        }
        //đè vô
        cart.put(dto.getBookID(), dto);
        return true;
        
    }
    public void deleteBook(String BookId){
        if (cart == null) {
            return;
        }
        if (this.cart.containsKey(BookId)) {
            this.cart.remove(BookId);
        }
    }
    
    public void decreaseQuantity(String bookId){
        if (this.cart.containsKey(bookId)) {
            int quantity = this.cart.get(bookId).getQuantity();
            if(quantity == 1) return; 
            this.cart.get(bookId).setQuantity(quantity - 1);
        }
    }
    
    public void increaseQuantity(String bookId){
        if (this.cart.containsKey(bookId)) {
            int quantity = this.cart.get(bookId).getQuantity();
            if(quantity == 5) return;
            this.cart.get(bookId).setQuantity(quantity + 1);
        }
    }

   
}

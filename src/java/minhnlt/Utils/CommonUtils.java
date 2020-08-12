/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.Utils;

import java.util.ArrayList;
import java.util.List;
import minhnlt.tblBook.BookDTO;

/**
 *
 * @author ADMIN
 */
public class CommonUtils {
    public static List<BookDTO> getPagination(List<BookDTO> listAllBook, int start, int rowsOfPage){
        List<BookDTO> subList = new ArrayList<>();
        for(int i = 0; i<listAllBook.size(); i++){
            if((i>=start) && (i < start + rowsOfPage)){
                subList.add(listAllBook.get(i));
            }
        }
        return subList;
    }
    
    public static boolean checkInteger(String number){
        int num;
        try{
           num = Integer.parseInt(number);
           return true;
        }catch(Exception e){
            return false;
        }
    }
}

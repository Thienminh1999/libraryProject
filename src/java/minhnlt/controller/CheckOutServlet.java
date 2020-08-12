/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnlt.cart.CartObj;
import minhnlt.tblBook.BookDAO;
import minhnlt.tblBook.BookDTO;
import minhnlt.tblRent.RentDAO;
import minhnlt.tblRent.RentDTO;
import minhnlt.tblRentDetail.RentDetailDAO;
import minhnlt.tblRentDetail.RentDetailDTO;
import minhnlt.tblUser.UserDTO;

/**
 *
 * @author ADMIN
 */
public class CheckOutServlet extends HttpServlet {
    private final String ERROR_PAGE = "error.html";
    private final String THANK_YOU_PAGE = "thankyou.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            UserDTO userdto = (UserDTO) session.getAttribute("USER");
            //add vào tblRent
            RentDTO rentdto = new RentDTO(userdto.getUserid());
            RentDAO rentdao = new RentDAO();
            rentdao.insertRent(rentdto);
            //add vào tblRentDetail
            for(String key : cart.getCart().keySet()){
                BookDTO book = cart.getCart().get(key);
                RentDetailDTO rentdetaildto = new RentDetailDTO(rentdto.getRentID(), book.getBookID(), book.getQuantity());
                RentDetailDAO rentdetaildao = new RentDetailDAO();
                rentdetaildao.insertRentDetail(rentdetaildto);
                //trừ số lượng sách trong tblBook
                BookDAO bookdao = new BookDAO();
                bookdao.updateBookQuantity(book.getBookID(), book.getQuantity());
            }
            session.setAttribute("CART", null);
            url = THANK_YOU_PAGE;
        } catch (NamingException ex) {
            log("CheckoutServlet_NamingException" + ex.getMessage());
        } catch (SQLException ex) {
            log("CheckoutServlet_SQLException" + ex.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

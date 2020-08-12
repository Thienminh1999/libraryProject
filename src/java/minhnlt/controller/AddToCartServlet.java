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

/**
 *
 * @author ADMIN
 */
public class AddToCartServlet extends HttpServlet {

    private final String DETAIL_BOOK_SERVLET = "showDetailBookServlet";

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
        String bookId = request.getParameter("txtBookId");
        int quantity =Integer.parseInt(request.getParameter("txtQuantity"));
        boolean checkAdd = false;
        String url;
        try {
            HttpSession session = request.getSession(true);
            if(quantity <= 0){
                checkAdd = false;
                url = "showDetailBookServlet?txtBookID=" + bookId;
                session.setAttribute("checkAddComplete", checkAdd);
                request.getRequestDispatcher(url).forward(request, response);
            }
            BookDAO dao = new BookDAO();
            BookDTO book = dao.loadBookDetail(bookId);
            
            CartObj cart = (CartObj) session.getAttribute("CART");
            
            if (cart == null) {
                cart = new CartObj();
            }
            int quantityInDB = dao.getQuantityInDB(bookId);
            
            if(quantity < quantityInDB){
                checkAdd = cart.addToCart(book, quantity);
            } else {
                checkAdd = false;
            }
            
           
            session.setAttribute("checkAddComplete", checkAdd);
            session.setAttribute("CART", cart);
        } catch (NamingException e) {
            log("AddToCartServlet_NamingException" + e.getMessage());
        } catch (SQLException e) {
            log("AddToCartServlet_SQLException" + e.getMessage());
        } finally {
            url = "showDetailBookServlet?txtBookID=" + bookId;
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

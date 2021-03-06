/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minhnlt.tblBook.BookDAO;
import minhnlt.tblBook.BookDTO;


/**
 *
 * @author ADMIN
 */
public class loadBookPageServlet extends HttpServlet {
    private final String BOOK_PAGE = "showbook.jsp";
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
        String url = BOOK_PAGE;
        HttpSession session = request.getSession();
        session.setAttribute("checkAddComplete", null);
        try {
//            //load category to filter
//            CategoryDAO categorydao = new CategoryDAO();
//            categorydao.loadCategory();
//            List<CategoryDTO> listCategory = categorydao.getListCategory();
//            request.setAttribute("listCategory", listCategory);
//            
//            //load author to filter
//            AuthorDAO authordao = new AuthorDAO();
//            authordao.loadAllAuthor();
//            List<AuthorDTO> listAllAuthor = authordao.getListAllAuthor();
//            request.setAttribute("listAllAuthor", listAllAuthor);
            
             //load book list
            BookDAO bookdao = new BookDAO();
            bookdao.loadAllBook();
            List<BookDTO> listAllBook = bookdao.getListAllBook();
            if(listAllBook!=null){
                request.setAttribute("listAllBook", listAllBook);
            }
                
            
        } catch (NamingException ex) {
           log("loadBookPageServlet_NamingException" + ex.getMessage());
        } catch (SQLException ex) {
            log("loadBookPageServlet_SQLException" + ex.getMessage());
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

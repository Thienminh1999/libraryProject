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

import minhnlt.Utils.CommonUtils;
import minhnlt.formAddBookError.FormAddBookErrorDTO;
import minhnlt.tblBook.BookDAO;
import minhnlt.tblBook.BookDTO;

/**
 *
 * @author ADMIN
 */
public class ValidationFormAddBookServlet extends HttpServlet {

    private final String CREATE_NEW_BOOK_PAGE = "LoadCreatePageServlet";
    private final String ADMIN_PAGE = "LoadAdminPageServlet";
    private final String ERROR_PAGE = "error.html";

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
        boolean checkError = true;
        String url = ERROR_PAGE;
        FormAddBookErrorDTO error = new FormAddBookErrorDTO();
        int pageNumber = 0;
        try {
            String txtBookID = request.getParameter("txtBookID");
            String txtBookName = request.getParameter("txtBookName");
            String txtPublicDate = request.getParameter("txtPublicDate");
            String txtPublisher = request.getParameter("txtPublisher");
            String txtQuantity = request.getParameter("txtQuantity");
            String txtSize = request.getParameter("txtSize");
            String txtTypeOfCover = request.getParameter("txtTypeOfCover");
            String txtPageNumber = request.getParameter("txtPageNumber");
            String txtDescription = request.getParameter("txtDescription");
            String txtCategory = request.getParameter("txtCategory");
            if(txtPageNumber.equals("")){
                pageNumber = 0;
            }else{
                pageNumber = Integer.parseInt(txtPageNumber);
            }

            if (txtBookID.equals("")) {
                error.setBookIDError("BookID must not be empty");
                checkError = false;
            }
            if (txtBookName.equals("")) {
                error.setBookNameError("Book name must not be empty");
                checkError = false;
            }
            if (txtPublicDate.equals("")) {
                error.setPublicDateError("Public date must not be empty");
                checkError = false;
            }
            if (txtPublisher.equals("")) {
                error.setPublisherError("Publisher must not be empty");
                checkError = false;
            }
            if(txtCategory.equals("")){
                error.setCategoryIDError("Please choose a category for this book");
                checkError = false;
            }
            if(txtQuantity.equals("")){
                error.setQuantityError("The quantity must not be empty");
                checkError = false;
            }
            if (!txtQuantity.equals("")) {
                if (CommonUtils.checkInteger(txtQuantity) == false) {
                    error.setQuantityError("The quantity must be numeric");
                    checkError = false;
                }
            }
            if (checkError == true) {
                BookDTO book = new BookDTO(txtBookID, txtBookName, txtPublisher, txtPublicDate, Integer.parseInt(txtQuantity), txtSize, txtTypeOfCover, pageNumber, txtDescription, txtCategory);
                BookDAO bookdao = new BookDAO();
                boolean check = bookdao.insertNewBook(book);
                HttpSession session = request.getSession();
                session.setAttribute("CheckInsert", check);
                url = ADMIN_PAGE;
            } else {
                int quantity = 0;
                BookDTO book = new BookDTO(txtBookID, txtBookName, txtPublisher, txtPublicDate, quantity, txtSize, txtTypeOfCover, pageNumber, txtDescription, txtCategory);
                url = CREATE_NEW_BOOK_PAGE;
                request.setAttribute("ERROR", error);
                request.setAttribute("BOOK", book);
            }
        } catch (NamingException ex) {
            log("ValidationFormAddBookServlet_NamingException" + ex.getMessage());
        } catch (SQLException ex) {
            log("ValidationFormAddBookServlet_SQLException" + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                error.setBookIDError("BookID has existed");
                request.setAttribute("ERROR", error);
                url = CREATE_NEW_BOOK_PAGE;
            }
        } finally {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {

    private final String ERROR_PAGE = "error.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String SEARCH_BOOK_SERVLET = "SearchBookServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String DELETE_BOOK_SERVLET = "DeleteBookServlet";
    private final String LOAD_ADMIN_PAGE_SERVLET = "LoadAdminPageServlet";
    private final String LOAD_CREATE_PAGE_SERVLET = "LoadCreatePageServlet";
    private final String VALIDATION_FORM_ADD_BOOK_SERVLET = "ValidationFormAddBookServlet";
    private final String EDIT_BOOK_SERVLET = "EditBookServlet";
    private final String UPDATE_BOOK_SERVLET = "UpdateBookServlet";
    private final String DELETE_SERVLET = "DeleteBookAdminServlet";
    private final String LOAD_INFO_PAGE_SERVLET = "LoadInfoServlet";
    private final String STATISTICS_PAGE = "statisticsPage.jsp";
    private final String LOAD_STATISTICS_PAGE = "LoadStatisticPageServlet";
    private final String EXPORT_TO_EXCEL_SERVLET = "ExportToExcelServlet";
    

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
            String btn = request.getParameter("btnAction");
            if (btn.equals("Login")) {
                url = LOGIN_SERVLET;
            } else if (btn.equals("SearchBook")) {
                url = SEARCH_BOOK_SERVLET;
            } else if (btn.equals("AddToCart")) {
                url = ADD_TO_CART_SERVLET;
            } else if (btn.equals("DeleteBook")) {
                url = DELETE_BOOK_SERVLET;
            } else if (btn.equals("SearchBookAdmin")) {
                url = LOAD_ADMIN_PAGE_SERVLET;
            } else if (btn.equals("ToCreatePage")) {
                url = LOAD_CREATE_PAGE_SERVLET;
            } else if (btn.equals("CreateNewBook")) {
                url = VALIDATION_FORM_ADD_BOOK_SERVLET;
            } else if (btn.equals("EditBook")) {
                url = EDIT_BOOK_SERVLET;
            } else if (btn.equals("UpdateBook")) {
                url = UPDATE_BOOK_SERVLET;
            } else if(btn.equals("delete")){
                url = DELETE_SERVLET;
            }else if(btn.equals("infor")){
                url = LOAD_INFO_PAGE_SERVLET;
            }else if(btn.equals("ToStatisticsPage")){
                url = STATISTICS_PAGE;
            }else if(btn.equals("SearchAsDate")){
                url = LOAD_STATISTICS_PAGE;
            }else if(btn.equals("ExportToExcel")){
                url = EXPORT_TO_EXCEL_SERVLET;
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

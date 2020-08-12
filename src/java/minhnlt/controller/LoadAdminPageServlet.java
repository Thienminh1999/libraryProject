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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import minhnlt.Utils.CommonUtils;
import minhnlt.tblBook.BookDAO;
import minhnlt.tblBook.BookDTO;

/**
 *
 * @author ADMIN
 */
public class LoadAdminPageServlet extends HttpServlet {

    private final String ADMIN_PAGE = "adminpage.jsp";

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
        try {
//          
            int startNum = 0;
            String start =(String)request.getParameter("PageNo");
            if(start == null){
                startNum = 0;
            }else{
                startNum = Integer.parseInt(start);
            }
            BookDAO dao = new BookDAO();
            String searchValue = request.getParameter("txtSearchValue");
            if(searchValue != null){
                if(searchValue.equals("")){
                    dao.loadAllBookAdmin();
                }else{
                    dao.searchBookAdmin(searchValue);
                }
            }else{
                dao.loadAllBookAdmin();
            }
            
            List<BookDTO> listBook = dao.getListAllBookAdmin();
            List<BookDTO> listSub = null;
            
            double sizeList = listBook.size();
            int NumberOfPage = (int) Math.ceil(sizeList / 10);
            
            if(NumberOfPage>1){
                listSub = CommonUtils.getPagination(listBook, startNum, 10);
            }else{
                listSub = listBook;
            }
            request.setAttribute("NumberOfPage", NumberOfPage);
            request.setAttribute("listBook", listSub);
        } catch (NamingException ex) {
            log("loadAdminPage_NamingException" + ex.getMessage());
        } catch (SQLException ex) {
            log("loadAdminPage_SQLException" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
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

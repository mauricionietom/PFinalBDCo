/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.DaoRegistro;
import Modelo.registro;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConsultas extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ArrayList<registro> lista = null;
        DaoRegistro de;
        try {
            de = new DaoRegistro();
            
             lista = de.getRegistro();
            
            request.setAttribute("registros", lista);
            
          //  response.sendRedirect("TablaExp.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("TablaExp.jsp");
            rd.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletConsultas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletConsultas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServletConsultas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServletConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
                  
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


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

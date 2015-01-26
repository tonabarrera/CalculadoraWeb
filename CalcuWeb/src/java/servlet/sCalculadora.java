/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import clases.Numero;
import db.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lordtony
 */
@WebServlet(name = "sCalculadora", urlPatterns = {"/sCalculadora"})
public class sCalculadora extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Numero aux = new Numero();
            HttpSession sesion = request.getSession();
            int id = (Integer)sesion.getAttribute("id");
            Conexion con = new Conexion();
            con.conectar();
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String tipo = request.getParameter("combo");
            System.out.print(""+num1+""+ num2 +""+tipo);
            Float val1 = Float.parseFloat(num1);
            Float val2 = Float.parseFloat(num2);
            aux.setNum(val1, val2);
            String total="";
            String operacion = "";
            if(tipo.equals("1")){
                total = Float.toString(aux.suma());
                operacion = num1 + " + " + num2 + " = " + total;
            }else{
                if(tipo.equals("2")){
                    total = Float.toString(aux.resta());
                    operacion = num1 + " - " + num2 + " = " + total;       
                }else{
                    if(tipo.equals("3")){
                        total = Float.toString(aux.mul());
                        operacion = num1 + " * " + num2 + " = " + total;
                    }else{
                        if(tipo.equals("4")){
                           total = Float.toString(aux.div());
                        operacion = num1 + " / " + num2 + " = " + total; 
                        }
                    }
                }
            }
            System.out.print(operacion);
            con.altaOp(id, operacion);
            response.sendRedirect("sCalcu");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sCalculadora.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sCalculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
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

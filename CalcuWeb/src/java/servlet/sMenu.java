/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "sMenu", urlPatterns = {"/sMenu"})
public class sMenu extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession sesion = request.getSession();
            int id = (Integer)sesion.getAttribute("id");
            String username = (String) sesion.getAttribute("userName");
            System.out.print(id);
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"	<head>\n" +
"		<meta charset=\"UTF-8\">\n" +
"		<meta charset=\"utf-8\">\n" +
"	    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
"	    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>	\n" +
"		<link rel=\"stylesheet\" href=\"css/menu.css\">\n" +
"		<link rel=\"shortcut icon\" href=\"img/cara.png\">\n" +
"		<title>Menu</title>\n" +
"	</head>\n" +
"	<body>\n" +
"		<section class=\"Section\">\n" +
"                    <h1 class=\"Section-title\">"+username+", Seleciona algo que hacer</h1>\n" +
"	            <a class=\"Section-calcu\" href=\"sCalcu\">Calculadora</a>\n" +
"	            <a class=\"Section-xml\" href=\"sVerXML\">Ver XML</a>\n" +
"	    </section>\n" +
"	</body>\n" +
"</html>");
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

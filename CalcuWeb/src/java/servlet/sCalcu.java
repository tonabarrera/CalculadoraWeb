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

/**
 *
 * @author lordtony
 */
@WebServlet(name = "sCalcu", urlPatterns = {"/sCalcu"})
public class sCalcu extends HttpServlet {

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
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"	<head>\n" +
"		<meta charset=\"UTF-8\">\n" +
"		<meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
"        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>\n" +
"        <link rel=\"stylesheet\" href=\"css/login.css\">\n" +
"        <link rel=\"shortcut icon\" href=\"img/cara.png\">\n" +
"		<title>Calculadora</title>\n" +
"	</head>\n" +
"	<body>\n" +
"		<section class=\"Section\">\n" +
"            <h1 class=\"Section-title\">Calculadora</h1>\n" +
"            <form action=\"sCalculadora\" method=\"post\">\n" +
"            	<input type=\"text\" class=\"Section-txt\" placeholder=\"Numero 1\" name=\"num1\" id=\"num1\" required>\n" +
"            	<select class=\"Section-txt\" style=\"background: white\" id=\"combo\" name=\"combo\" required>\n" +
"            		<option value=\"\" >Selecciona la operacion</option>\n" +
"					<option value=\"1\">Suma</option>\n" +
"					<option value=\"2\">Resta</option>\n" +
"					<option value=\"3\">Multiplicacion</option>\n" +
"					<option value=\"4\">Division</option>\n" +
"				</select>\n" +
"            	<input type=\"text\" class=\"Section-txt\" placeholder=\"Numero 2\" name=\"num2\" id=\"num2\" required>\n" +
"            	<input type=\"submit\" class=\"Section-submit\" id=\"calcula\" value=\"Calcular\">\n" +
"            </form>\n" +
"        </section>\n" +
"        <script type=\"text/javascript\" src=\"js/calcu.js\"></script>\n" +
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

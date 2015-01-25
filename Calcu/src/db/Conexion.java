/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lordtony
 */
public class Conexion {
    private Connection con = null;
    private Statement stm;
    
    public Connection conectar(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String base, usr, pass;
            base = "jdbc:mysql://127.0.0.1/calculadora";
            usr = "root";
            pass = "n0m3l0";
            con = DriverManager.getConnection(base, usr, pass);
            System.out.println("Conexión exitosa");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public Connection conectar(String driver, String puerto, String usuario, String pasword)
    {
        try
        {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(puerto, usuario, pasword);
            System.out.println("Conexion exitosa");
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public String Login(String email, String password) throws SQLException {
        this.stm = con.createStatement();       
        ResultSet rs;
        rs = stm.executeQuery("call spLogin('"+email+"', '"+password+"');");
        String resultado = "";
        while(rs.next()){
           resultado = rs.getString("msj");
        }
        System.out.println("El resultado: " + resultado);
        return resultado;
    }
    public ResultSet getDatos(String email) throws SQLException {
        ResultSet rs;
        this.stm = con.createStatement();
        rs = stm.executeQuery("call spCarga('"+email+"');");
        return rs;
    }
    public void altaOp(int id, String operacion) throws SQLException {
        ResultSet rs;
        this.stm = con.createStatement();
        rs = stm.executeQuery("call spAltaOperacion("+id+", '"+operacion+"');");
    }
    public String getXML(int id) throws SQLException{
        this.stm = con.createStatement();       
        ResultSet rs;
        int i=0;
        rs = stm.executeQuery("call spGetXML('"+id+"')");
        String tipo = "<operaciones>";
        tipo += "<operacion>\n";
        tipo += "<id>ID</id>\n";
        tipo += "<laOperacion>Operacion</laOperacion>\n";
        tipo += "</operacion>\n";
        while(rs.next()){
           tipo += "<operacion>\n";
           tipo += "<id>" + rs.getString("idoperaciones") + "</id>\n";
           tipo += "<laOperacion>" + rs.getString("operacion") + "<laOperacion>\n";
           tipo += "</operacion>\n";
        }
        tipo += "</operaciones>";
        System.out.print(tipo);
        return tipo;
     }
    
}

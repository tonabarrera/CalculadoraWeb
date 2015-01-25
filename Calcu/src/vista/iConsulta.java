/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import db.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lordtony
 */
class iConsulta extends JFrame implements ActionListener{
    JButton btnReturn;
    JLabel lbTitle;
    JLabel lbXML;
    Conexion con;
    Font fuente = new Font("Arial", Font.PLAIN, 24);
    Font fuente2 = new Font("Arial", Font.PLAIN, 16);
    Color azul = new Color(0,153,255);
    int id_user;
    String user_name;
    public iConsulta(int id, String username) throws SQLException{
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(249, 249, 249));
        
        con = new Conexion();
        con.conectar();
        
        this.id_user = id;
        this.user_name = username;
        
        lbTitle = new JLabel();
        lbTitle.setText("Mis operaciones");
        lbTitle.setFont(fuente);
        lbTitle.setBounds(170, 10, 200, 30);
        add(lbTitle);
        
        showXML();
                
        btnReturn=new JButton("Regresar");
        btnReturn.setBounds(155, 250, 180, 35);
        btnReturn.setBackground(azul);
        btnReturn.setFont(fuente); 
        btnReturn.setForeground(new Color(255, 255, 255));
        btnReturn.addActionListener(this);
        add(btnReturn);
       
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnReturn){
            this.dispose();
            iMenu menu = new iMenu(id_user, user_name);
        }
    }
    public void showXML() throws SQLException{
        String xml = "";
        xml= con.getXML(id_user);
        System.out.println(xml);
    }
}

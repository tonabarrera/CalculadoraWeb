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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author lordtony
 */
public class iLogin extends JFrame implements ActionListener {
    JButton btnEnter;
    JTextField txtEmail;
    JPasswordField txtPsw;
    JLabel lbTitle;
    JLabel lbUsr;
    JLabel lbPsw;
    Conexion con;
    Font fuente = new Font("Arial", Font.PLAIN, 24);
    Font fuente2 = new Font("Arial", Font.PLAIN, 20);
    Color azul = new Color(0,153,255);
    public iLogin(){
        con = new Conexion();
        con.conectar();
        
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(249, 249, 249));
             
        lbTitle = new JLabel();
        lbTitle.setText("Calculadora");
        lbTitle.setFont(fuente);
        lbTitle.setBounds(170, 10, 150, 30);
        add(lbTitle);
        
        lbUsr=new JLabel();
        lbUsr.setText("Email:");
        lbUsr.setFont(fuente2); 
        lbUsr.setBounds(170, 60, 150, 30);
        lbUsr.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbUsr);
        
        lbPsw=new JLabel();
        lbPsw.setText("Password:");
        lbPsw.setFont(fuente2);   
        lbPsw.setBounds(170, 160, 150, 30);
        lbPsw.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbPsw);
        
        txtEmail=new JTextField(10);
        txtEmail.setFont(fuente2);
        txtEmail.setBounds(70, 100, 350, 35);
        add(txtEmail);

        txtPsw=new JPasswordField(10);
        txtPsw.setBounds(70, 200, 350, 35);
        txtPsw.setFont(fuente2);
        add(txtPsw);
        
        btnEnter=new JButton("Entrar");
        btnEnter.setBounds(155, 250, 180, 35);
        btnEnter.setBackground(azul);
        btnEnter.setFont(fuente); 
        btnEnter.setForeground(new Color(255, 255, 255));
        btnEnter.addActionListener(this);
        add(btnEnter);
        
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnEnter){
            String email = txtEmail.getText();
            char password[] = txtPsw.getPassword();
            String pass = "";
            String resultado = "";
            ResultSet resultado2 = null;
            for(int i=0; i<password.length; i++){
                pass += password[i];
            }
            
            try {
                resultado = con.Login(email, pass);
            } catch (SQLException ex) {
                Logger.getLogger(iLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(resultado.equals("Bien")){
                int id = 0;
                String userName="";
                try {
                    resultado2 = con.getDatos(email);
                } catch (SQLException ex) {
                    Logger.getLogger(iLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    this.dispose();
                    while(resultado2.next()){
                        id = resultado2.getInt("idUser");
                        System.out.print(id);
                        userName = resultado2.getString("userName");
                    }
                    iMenu memu = new iMenu(id, userName);
                } catch (SQLException ex) {
                    Logger.getLogger(iLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Mal");
            }
        }
    }

}

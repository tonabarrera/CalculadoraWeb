/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import db.Conexion;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public iLogin()
    {
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
        lbUsr.setText("Usuario:");
        lbUsr.setFont(new Font("Arial", Font.PLAIN, 20));
        lbUsr.setForeground(Color.white);   
        lbUsr.setBounds(0, 60, 100, 30);
        lbUsr.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbUsr);
        
        lbPsw=new JLabel();
        lbPsw.setText("Password:");
        lbPsw.setFont(new Font("Arial", Font.PLAIN, 20));
        lbPsw.setForeground(Color.white);   
        lbPsw.setBounds(5, 160, 130, 30);
        lbPsw.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbPsw);
        
        txtEmail=new JTextField(10);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        txtEmail.setBounds(0,90,300,45);
        add(txtEmail);

        txtPsw=new JPasswordField(10);
        txtPsw.setBounds(0,190,300,45);
        txtPsw.setFont(new Font("Arial", Font.PLAIN, 20));
        add(txtPsw);
        
        btnEnter=new JButton("Entrar");
        btnEnter.setBounds(0,250,300,45);
        btnEnter.setBackground(new Color(0,153,255));
        btnEnter.setFont(fuente); 
        btnEnter.setForeground(new Color(255, 255, 255));
        btnEnter.addActionListener(this);
        add(btnEnter);
        
        this.setSize(500,320);
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
            
            for(int i=0; i<password.length; i++){
                pass += password[i];
            }
            
            try {
                resultado = con.Login(email, pass);
            } catch (SQLException ex) {
                Logger.getLogger(iLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(resultado.equals("Bien")){
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Mal");
            }
        }
    }

}

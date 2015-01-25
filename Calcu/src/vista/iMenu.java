/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author lordtony
 */
public class iMenu extends JFrame implements ActionListener{
    JButton btnCalcu, btnXML, btnConsu;
    JLabel lbTitle;
    Font fuente = new Font("Arial", Font.PLAIN, 24);
    Font fuente2 = new Font("Arial", Font.PLAIN, 20);
    Color azul = new Color(0,153,255);
    Color morado = new Color(172,124,255);
    Color verde = new Color(0,222,118);
    int id_user;
    String user_name = "";
    public iMenu(int id, String userName){
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(249, 249, 249));
        this.id_user = id;
        this.user_name = userName;
        lbTitle = new JLabel();
        lbTitle.setText("¿Qué quieres hacer?, " +userName);
        lbTitle.setFont(fuente);
        lbTitle.setBounds(120, 10, 300, 30);
        add(lbTitle);
        
        /*
        btnXML=new JButton("Ver XML");
        btnXML.setBounds(155, 60, 180, 35);
        btnXML.setBackground(azul);
        btnXML.setFont(fuente); 
        btnXML.setForeground(new Color(255, 255, 255));
        btnXML.addActionListener(this);
        add(btnXML);
        */
        btnConsu=new JButton("Mis operaciones");
        btnConsu.setBounds(120, 160, 250, 35);
        btnConsu.setBackground(verde);
        btnConsu.setFont(fuente); 
        btnConsu.setForeground(new Color(255, 255, 255));
        btnConsu.addActionListener(this);
        add(btnConsu);
        
        
        btnCalcu=new JButton("Calculadora");
        btnCalcu.setBounds(155, 250, 180, 35);
        btnCalcu.setBackground(morado);
        btnCalcu.setFont(fuente); 
        btnCalcu.setForeground(new Color(255, 255, 255));
        btnCalcu.addActionListener(this);
        add(btnCalcu);
        
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnCalcu){
                this.dispose();
                iCalcu cal = new iCalcu(id_user, user_name);
        }else{
            if(e.getSource() == btnConsu){
                this.dispose();
                try {
                    iConsulta con = new iConsulta(id_user, user_name);
                } catch (SQLException ex) {
                    Logger.getLogger(iMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

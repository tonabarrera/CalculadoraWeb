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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
    public iMenu(){
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(249, 249, 249));
             
        lbTitle = new JLabel();
        lbTitle.setText("¿Qué quieres hacer?");
        lbTitle.setFont(fuente);
        lbTitle.setBounds(120, 10, 300, 30);
        add(lbTitle);
        
        btnXML=new JButton("Ver XML");
        btnXML.setBounds(155, 60, 180, 35);
        btnXML.setBackground(azul);
        btnXML.setFont(fuente); 
        btnXML.setForeground(new Color(255, 255, 255));
        btnXML.addActionListener(this);
        add(btnXML);
        
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
                iCalcu cal = new iCalcu();
        }
        else{
            if(e.getSource()== btnXML){
                this.dispose();
                iVerXML verXML = new iVerXML();
            }
            else{
                if(e.getSource() == btnConsu){
                    this.dispose();
                    iConsulta consu = new iConsulta();
                }
                else{
                    System.out.println("Otra cosa");
                }
            }
        }
    }
}

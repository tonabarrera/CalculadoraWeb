/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.Numero;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author lordtony
 */
class iCalcu extends JFrame implements ActionListener{
    JLabel jlNum1, jlNum2, jlTotal;
    JTextField txtNum1, txtNum2;
    JButton btnCalcula;
    JButton btnAtras;
    ButtonGroup gpoBotones;
    JRadioButton rbSuma, rbResta, rbDivision, rbProducto;
    Font jlFuente = new Font("Arial", Font.BOLD, 24);
    Font txtFuente = new Font("Arial", Font.BOLD, 20);
    Font rbFuente = new Font("Arial", Font.BOLD, 18);
    public iCalcu(){
        setTitle("Calculadora");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setResizable(false);
        jlNum1=new JLabel();
        jlNum1.setText("Numero 1:");
        jlNum1.setFont(jlFuente);
        jlNum1.setForeground(Color.white);   
        jlNum1.setBounds(10, 10, 150, 30);
        jlNum1.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlNum1);
        
        txtNum1=new JTextField(10);
        txtNum1.setFont(txtFuente);
        txtNum1.setBounds(0,50,300,45);
        add(txtNum1);
        
        jlNum2=new JLabel();
        jlNum2.setText("Numero 2:");
        jlNum2.setFont(jlFuente);
        jlNum2.setForeground(Color.white);   
        jlNum2.setBounds(10, 115, 150, 30);
        jlNum2.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlNum2);
        
        txtNum2=new JTextField(10);
        txtNum2.setFont(txtFuente);
        txtNum2.setBounds(0,150,300,45);
        add(txtNum2);
        
        jlTotal=new JLabel();
        jlTotal.setFont(jlFuente);
        jlTotal.setForeground(Color.white);   
        jlTotal.setBounds(0, 214, 300, 55);
        jlTotal.setHorizontalAlignment(SwingConstants.CENTER);
        jlTotal.setBorder(BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255)));
        add(jlTotal);
        
        btnCalcula=new JButton("Calcular");
        btnCalcula.setBounds(300,220,300,48);
        btnCalcula.setBackground(new Color(255,245,4));
        btnCalcula.setFont(jlFuente); // NOI18N
        btnCalcula.setForeground(Color.BLACK);
        btnCalcula.addActionListener(this);
        add(btnCalcula);
        
        gpoBotones = new ButtonGroup();
        
        rbSuma=new JRadioButton();
        rbSuma.setBounds(320, 40, 100, 20);
        rbSuma.setFont(rbFuente);
        rbSuma.setForeground(Color.WHITE);
        rbSuma.setBackground(Color.BLACK);
        rbSuma.setText("Sumar");
        rbSuma.setSelected(true);
        rbSuma.setFocusable(false);
        gpoBotones.add(rbSuma);
        add(rbSuma);
        
        rbResta=new JRadioButton();
        rbResta.setBounds(440, 40, 100, 20);
        rbResta.setFont(rbFuente);
        rbResta.setForeground(Color.WHITE);
        rbResta.setBackground(Color.BLACK);
        rbResta.setText("Resta");
        rbResta.setSelected(false);
        rbResta.setFocusable(false);
        gpoBotones.add(rbResta);
        add(rbResta);
        
        rbDivision=new JRadioButton();
        rbDivision.setBounds(320, 150, 125, 20);
        rbDivision.setFont(rbFuente);
        rbDivision.setForeground(Color.WHITE);
        rbDivision.setBackground(Color.BLACK);
        rbDivision.setText("División");
        rbDivision.setSelected(false);
        rbDivision.setFocusable(false);
        gpoBotones.add(rbDivision);
        add(rbDivision);
        
        rbProducto=new JRadioButton();
        rbProducto.setBounds(440, 150, 180, 20);
        rbProducto.setFont(rbFuente);
        rbProducto.setForeground(Color.WHITE);
        rbProducto.setBackground(Color.BLACK);
        rbProducto.setText("Multiplicación");
        rbProducto.setFocusable(false);
        rbProducto.setSelected(false);
        gpoBotones.add(rbProducto);
        add(rbProducto);
        
        btnAtras=new JButton("Regresar");
        btnAtras.setBounds(0,270,605,50);
        btnAtras.setBackground(new Color(0,153,255));
        btnAtras.setFont(jlFuente); 
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.addActionListener(this);
        add(btnAtras);
        
        setSize(605, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        float val1, val2;
        String total="";
        String operacion = "";
        String msn = "no se pudo";
        Numero aux = new Numero();
        if(e.getSource()==btnAtras){
            this.dispose();
            iMenu menu = new iMenu();
        }
        else{
            if(e.getSource() == btnCalcula){
                String numero1=txtNum1.getText();
                String numero2=txtNum2.getText();
                val1 = Float.parseFloat(numero1);
                val2 = Float.parseFloat(numero2);
                aux.setNum(val1, val2);
                
                if(rbSuma.isSelected() == true){
                    total = Float.toString(aux.suma());
                    operacion = numero1 + " + " + numero2 + " = " + total;
                }else{
                    if(rbResta.isSelected() == true){
                        total = Float.toString(aux.resta());
                        operacion = numero1 + " - " + numero2 + " = " + total;
                    }else{
                        if(rbDivision.isSelected() == true){
                            total = Float.toString(aux.div());
                            operacion = numero1 + " ÷ " + numero2 + " = " + total;
                        }else{
                            if(rbProducto.isSelected() == true){
                                total = Float.toString(aux.mul());
                                operacion = numero1 + " * " + numero2 + " = " + total;
                            }else{
                                JOptionPane.showMessageDialog(null, msn, "No mame abuelo", JOptionPane.ERROR_MESSAGE);
                            }
                        }   
                    }
                }
                jlTotal.setText(total);
            }
            else{
                System.out.println("Algo mas");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lordtony
 */
public class Numero {
   float num1, num2;
    public Numero(){
        num1=0;
        num2=0;
    }
    public void setNum(float nume1, float nume2){
    num1=nume1;
    num2=nume2;
    }
    public float suma(){
        float resulta;
        resulta=num1+num2;
        return resulta;
    }
    public float resta(){
        float resulta;
        resulta=num1-num2;
        return resulta;
    }
    public float mul(){
        float resulta;
        resulta=num1*num2;
        return resulta;
    }
    public float div(){
        float resulta;
        resulta=num1/num2;
        return resulta;
    } 
}

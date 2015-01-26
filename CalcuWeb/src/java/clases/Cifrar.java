/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lordtony
 */
public class Cifrar {
    String email, pass;
    MessageDigest md = null;
    public Cifrar(String correo, String contra){
        this.email = correo;
        this.pass = contra;
    }
    public String getCorreo() throws NoSuchAlgorithmException{
        String correo="";
        System.out.println(email);
        this.md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(email.getBytes()));
        correo = hash.toString(16);
        System.out.println(correo);
        return correo;
    }
    public String getPass() throws NoSuchAlgorithmException{
        String contra="";
        System.out.println(pass);
        this.md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(pass.getBytes()));
        contra = hash.toString(16);
        System.out.println(contra);
        return contra;
    }
}

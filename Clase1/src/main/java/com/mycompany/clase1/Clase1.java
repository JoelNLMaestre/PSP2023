/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */
public class Clase1 {

    public static void main(String[] args) {
        try{
            ProcessBuilder pb = new ProcessBuilder("ls", "-ln");
            
            pb.inheritIO();
            
            Process p = pb.start();
            // capturamos la salida del proceso y la transformamos en un streamreader para poder trabajar con ello
            InputStreamReader isr = new InputStreamReader(p.getInputStream()); 
            BufferedReader br = new BufferedReader(isr);
            
            String linea=br.readLine();
            while(linea!= null){
                System.out.println(linea);
                br.readLine();
            }
            
            System.out.println("Programa principal terminado");
        }catch(IOException ioe){
            Logger.getLogger(Clase1.class.getName()).log(Level.SEVERE,null,ioe);
        }
    }
}

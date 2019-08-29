package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

public class Entrada implements Runnable {
   
    private Socket servidor;
    private HashMap<String,String> usuarioCodigo;

  
    Entrada(Socket cliente, HashMap<String, String> usuarioCodigo){
    	this.servidor = cliente;
    	this.usuarioCodigo = usuarioCodigo;
    	}
   
    @Override
    public void run() {
       
    
       BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            try{
            	
                BufferedReader teclado = new BufferedReader(
                        new InputStreamReader(System.in));
                PrintStream saida = null;
                try {
                    saida = new PrintStream(servidor.getOutputStream());
                } catch (IOException ex) {
                	ex.printStackTrace();
                }
                    saida.println("Fernando");
                    
                    String[] in = entrada.readLine().split(";");
                    System.out.println(in[0] + ";" + in[1]);
                    System.out.println(Integer.parseInt(in[1]) + Integer.parseInt(usuarioCodigo.get(in[0].toUpperCase())));
        
            }catch (IOException e){
                System.out.println("..");
            }
    }

}
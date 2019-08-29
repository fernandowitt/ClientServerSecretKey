package Server;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Entrada implements Runnable {
    
    private Socket cliente;
    private HashMap <String, String> usuarioCodigo;
    
    Integer numero;
    
    Entrada(Socket cliente, HashMap<String, String> usuarioCodigo){
    	this.usuarioCodigo = usuarioCodigo;
        this.cliente = cliente;
        numero = 0;
    }

  
    public  int nCorrespondente() {
    	return numero;
    }
   
    @Override
    public void run() {
        
       
       BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
//        while (true) {
            try{
            	//criar função de comparação dos nome passado com o nome da lista
//            	if (entrada.readLine() == null || usuarioCodigo.get(entrada.readLine().toUpperCase()) == null) {
//            			System.out.println("Erro");
//            	}else {
            		String nomeCliente= entrada.readLine().toUpperCase();
            		System.out.println(nomeCliente);
            		if(nomeCliente.isBlank() || nomeCliente.isEmpty() || !usuarioCodigo.containsKey(nomeCliente.toUpperCase())) {
            			numero = -1;
            		}else {
            			System.out.println(usuarioCodigo.get(nomeCliente));
            			numero = Integer.parseInt(usuarioCodigo.get(nomeCliente.toUpperCase()));
            		}
            		BufferedReader teclado = new BufferedReader(
                            new InputStreamReader(System.in));
            		
            		 PrintStream saida = null;
            	        try {
            	            saida = new PrintStream(cliente.getOutputStream());
            	        } catch (IOException ex) {
            	        	ex.printStackTrace();
            	        }
            	        
            	    
//            	        while (true) {
            	            
            	            try{
            	            	//enviar o seu nome
            	            	saida.println("Fernando;" + numero.toString());
            	            	
            	            	
            	            	//enviar o numero dele
            	                
            	               
            						cliente.close();
            						
            	                
            	            }catch (IOException e){
            	                System.out.println("..");
            	            }
//            	        }
                
            }catch (IOException e){
                System.out.println("..");
            }
//        }
    } 
}
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

public class Server {
   public static void main(String[] args) throws IOException {
       
	  
    
    
       System.out.println("Porta aberta!");
 
	      HashMap<String, String> usuarioCodigo = new HashMap<String, String>();
	      Random rand = new Random();
	      int [] index = new int [13];
	      int num;
	      for (int i=0; i<13; i++) {
	    	  if (i==0){
	    		  num=rand.nextInt(101);
	    		  index[i] = num;
	    	  } else {
	    		  boolean done = false;
	    		  num=rand.nextInt(101);
	    		  	while(done!= true) {
	    			   for(int j=0; j<13;j++) {
	    				 if(num == index[j]) {
	    					num=rand.nextInt(101);
	    					break;
	    				 }
	    				 done = true;	 
	    			  }
	    			   
	    			}
	    		  	
	    		  index[i]= num;
	    		  
		   	  }	 
	    	  System.out.println("" + index[i]);
	      }
	      
	      usuarioCodigo.put( "KARINE", ""+index[0] );
	      usuarioCodigo.put( "GUSTAVO", ""+index[1]);
	      usuarioCodigo.put( "EVELIN", ""+index[2]);
	      usuarioCodigo.put( "RAFAEL", ""+index[3]);
	      usuarioCodigo.put( "MATEUS", ""+index[4]);
	      usuarioCodigo.put( "SILVIO", ""+index[5]);
	      usuarioCodigo.put( "JOHN", ""+index[6]);
	      usuarioCodigo.put( "GIOVANNI", ""+index[7]);
	      usuarioCodigo.put( "THIAGO", ""+index[8]);
	      usuarioCodigo.put( "LUCAS", ""+index[9]);
	      usuarioCodigo.put( "LUCIANO", ""+index[10]);
	      usuarioCodigo.put( "THOMAS", ""+index[11]);
	      usuarioCodigo.put( "FERNANDO", ""+index[12]);
	
	      int total=0;
	      ServerSocket servidor = new ServerSocket(6666);
	      Socket cliente;
	      while( total <= 12) {
	  
	    	  cliente = servidor.accept();
	    	  System.out.println("Nova conex�o com o cliente " + cliente.getInetAddress().getHostAddress());
         
	    	  Entrada input = new Entrada(cliente , usuarioCodigo);
	    	  Thread ti = new Thread(input);
	    	  ti.start();
	    	  total++;
	      }
      
   }
 }

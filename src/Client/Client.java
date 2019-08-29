package Client;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Client {
	
	private static ArrayList<String> procuraIp(){
		ArrayList<String> ipsLocalizados = new ArrayList<String>();
		
		
		int contador;
		InetAddress endereco;
		
		
		for(contador = 0; contador < 256; contador++) {
			try {
			endereco = InetAddress.getByName("192.168.1."+contador);
			
			if(endereco.isReachable(10)) {
				ipsLocalizados.add("192.168.1."+contador);
				System.out.println("192.168.1."+contador);
			}
			
			}catch (Exception e) {
				System.out.println("ERRO: "+ e.getMessage());
			}
		}
		
		return ipsLocalizados;
	}
	 
	public static void main(String[] args) throws IOException {
		Socket conexao;
		HashMap<String, String> usuarioCodigo = new HashMap<String, String>();
	    Random rand = new Random();
	    int [] index = new int [13];
	    int d;
	    for (int i=0; i<13; i++) {
	    	if (i==0){
	    		d=rand.nextInt(101);
	    		index[i] = d;
	    	} else {
	    		boolean t = false;
	    		d=rand.nextInt(101);
	    		while(t!= true) {
	    			for(int j=0; j<i;j++) {
	    				if(d == index[j]) {
	    					d=rand.nextInt(101);
	    					break;
	    				}
	    				t = true;	 
	    			}
	    		}
	    		index[i]= d;
	    	}	 
	    }
	     
	      usuarioCodigo.put( "KARINE", ""+index[0] );
	      usuarioCodigo.put( "GUSTAVO", ""+index[1]);
	      usuarioCodigo.put( "EVELIN", ""+index[2]);
	      usuarioCodigo.put( "RAFAEL", ""+index[3]);
	      usuarioCodigo.put( "MATEUS", ""+index[4]);
	      usuarioCodigo.put( "SILVIO", ""+index[5]);
	      usuarioCodigo.put( "JOHN", ""+index[6]);
	      usuarioCodigo.put( "GIOVANNI", ""+index[7]);
	      usuarioCodigo.put( "TIAGO", ""+index[8]);
	      usuarioCodigo.put( "LUCAS", ""+index[9]);
	      usuarioCodigo.put( "LUCIANO", ""+index[10]);
	      usuarioCodigo.put( "THOMAS", ""+index[11]);
	      usuarioCodigo.put( "FERNANDO", ""+index[12]);
	      
	      for(int j = 0; j < 13; j++) {
	    	  System.out.println(index[j]);
	      }
	      
	      ArrayList<String> ipsLocalizados = new ArrayList<String>();
	      ipsLocalizados = procuraIp();
	      
	  	  for(String ipDaVez : ipsLocalizados){
	  		  System.out.println(ipDaVez);
	  		  try {
	  			conexao = new Socket(ipDaVez, 6666);
	  		  
	  		  	System.out.println("T� chegando aqui (joinha)");
	  		  	if( conexao.isConnected()) {
	  			  	System.out.println("O cliente se conectou ao servidor!");

	  			  	Entrada input = new Entrada(conexao, usuarioCodigo);
	  			  	Thread ti = new Thread(input);
	  			  	ti.start();
	  		  	}
	  		  }catch(Exception e) {
	  			  System.out.println("Não foi possível conectar no IP " + ipDaVez + ".");
	  		  }  
	  	}
	}
}

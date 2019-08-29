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
				// TODO: handle exception
				System.out.println("ERRO: "+ e.getMessage());
			}
		}
		
		return ipsLocalizados;
	}
	 
	public static void main(String[] args) throws IOException {
		Socket conexao;
		HashMap<String, String> usuarioCodigo2 = new HashMap<String, String>();
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
	     
	   //criar hashmap dos numeros que foram sorteados para mim 
//	      HashMap<String, String> numerosCriadosPMim = new HashMap<String, String>();
//	      numerosCriadosPMim.put( "KARINE", "" +0  );
//	      numerosCriadosPMim.put( "GUSTAVO", ""+ 0);
//	      numerosCriadosPMim.put( "EVELIN", ""+0);
//	      numerosCriadosPMim.put( "RAFAEL", ""+0);
//	      numerosCriadosPMim.put( "MATEUS", ""+0);
//	      numerosCriadosPMim.put( "SILVIO", ""+0);
//	      numerosCriadosPMim.put( "JOHN", ""+0);
//	      numerosCriadosPMim.put( "GIOVANNI", ""+0);
//	      numerosCriadosPMim.put( "TIAGO", ""+0);
//	      numerosCriadosPMim.put( "LUCAS", ""+0);
//	      numerosCriadosPMim.put( "LUCIANO", ""+0);
//	      numerosCriadosPMim.put( "THOMAS", ""+0);
	     
	      usuarioCodigo2.put( "KARINE", ""+index[0] );
	      usuarioCodigo2.put( "GUSTAVO", ""+index[1]);
	      usuarioCodigo2.put( "EVELIN", ""+index[2]);
	      usuarioCodigo2.put( "RAFAEL", ""+index[3]);
	      usuarioCodigo2.put( "MATEUS", ""+index[4]);
	      usuarioCodigo2.put( "SILVIO", ""+index[5]);
	      usuarioCodigo2.put( "JOHN", ""+index[6]);
	      usuarioCodigo2.put( "GIOVANNI", ""+index[7]);
	      usuarioCodigo2.put( "TIAGO", ""+index[8]);
	      usuarioCodigo2.put( "LUCAS", ""+index[9]);
	      usuarioCodigo2.put( "LUCIANO", ""+index[10]);
	      usuarioCodigo2.put( "THOMAS", ""+index[11]);
	      usuarioCodigo2.put( "FERNANDO", ""+index[12]);
	      
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

	  			  	Entrada input = new Entrada(conexao, usuarioCodigo2);
	  			  	Thread ti = new Thread(input);
	  			  	ti.start();
	  		  	}
	  		  }catch(Exception e) {
	  			  System.out.println("Não foi possível conectar no IP " + ipDaVez + ".");
	  		  }  
	  	}
	}
}

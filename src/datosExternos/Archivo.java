package datosExternos;
import java.io.*;
import java.util.ArrayList;

//clase para manejo de archivos
public  class Archivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	 
	//levanta datos de un archivo y lo guarda en una lista
	   public ArrayList<String> leerListaDeArchivo(String arch) {
	     
	      FileReader fr = null;
	      BufferedReader br = null;
	      ArrayList<String> listaSalida = new ArrayList<String>();
	 
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	    	 File archivo = new File(arch);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	 
	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	            listaSalida.add(linea);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	      return listaSalida;
	   }
	   
	   //
	   public static void escribirArchivo(String[] args, String archivo)
	    {
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(archivo);
	            pw = new PrintWriter(fichero);
	 
	            for (int i = 0; i < 10; i++)
	                pw.println("Linea " + i);
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	    }
	   public static boolean esArchivo(String entrada){
		   
		   File fRuta = new File(entrada);
		   boolean esArchivo = false;
		   if (fRuta.isDirectory())
		     esArchivo = false;
		   else
		     esArchivo = true;
		return esArchivo;
		   
	   }
	   
	   public static void escribirArchivo(ArrayList<String> args, String archivo)
	    {
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(archivo);
	            pw = new PrintWriter(fichero);
	 
	            for (int i = 0; i < args.size(); i++)
	                pw.println(args.get(i));
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	    }

}

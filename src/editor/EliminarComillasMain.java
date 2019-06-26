/**
 * 
 */
package editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ana Massone
 *
 */
public class EliminarComillasMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			eliminarComillas(args[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	static void eliminarComillas(String archivoEntrada)	 throws FileNotFoundException, IOException {
		
		System.out.println(archivoEntrada  );
		
		// Archivo Entrada
		BufferedReader br = new BufferedReader(new FileReader(	archivoEntrada));
		// Archivo Salida
		BufferedWriter bw = new BufferedWriter(new FileWriter(	archivoEntrada + ".salida.txt"));
		bw.flush();
	
		
		String cadenaEntrada;
		
		while ((cadenaEntrada = br.readLine()) != null) {
			
			
			
				bw.append(cadenaEntrada.replaceAll("\"","").replaceAll("\'",""));
				bw.newLine();
			}
		
		bw.close();
		br.close();
	}

}

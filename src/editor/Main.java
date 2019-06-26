/**
 * 
 */
package editor;

import java.io.FileNotFoundException;
import java.io.IOException;
import editor.Editor;


/**
 * @author Interaxa
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String objetoAFiltrar = args[0];
		String tipoFiltro =  args[1];
		String textoFiltro = args[2];
		Editor.procesar(objetoAFiltrar, tipoFiltro, textoFiltro);
	    if (args.length == 4){
	    	String extension = args[3];
	    	Editor.procesar(objetoAFiltrar, tipoFiltro, textoFiltro, extension);
	    }
		
       
	}



}
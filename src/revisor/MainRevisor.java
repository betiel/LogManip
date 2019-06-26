package revisor;

import java.io.File;
import java.util.ArrayList;

import datosExternos.Archivo;

public class MainRevisor {

	public static void main(String[] args) {
		Archivo arch = new Archivo();
		// Temporal guarda lista de ubicaciones a buscar
		ArrayList<String> salida = new ArrayList<String>();
		String directorio = "D:\\Ana\\Patagonia\\HBS.7z\\HBS\\HBS-Patagonia-1.9.39\\";
		directorio = ubicacion()+"\\";
		System.out.println( directorio);
		ArrayList<String> temporal = arch.leerListaDeArchivo(directorio + "entrada.txt");
		// Camino guarda la ruta + dato de nombre de archivo en formato lista
	
		// Ruta guarda la ruta
		String ruta = "";

		for (String t : temporal) {
			boolean resultado = false;
			// System.out.println(t);

			//System.out.println(t.lastIndexOf("\\"));
			String temp = t.substring(t.lastIndexOf("\\") + 1);
			ruta = directorio + t.replace(temp, "");

			//System.out.println("ruta " + ruta);

			File f = new File(ruta);
			if (f.exists()) {
				File[] ficheros = f.listFiles();
				for (int x = 0; x < ficheros.length; x++) {
					//System.out.println("f: " + ficheros[x]);
					//System.out.println("t: " + directorio + t);
					if ((directorio + t).equals(ficheros[x].toString())) {
						resultado = true;
						salida.add(t + " S; ");

					}
				}
				if (resultado == false) {
					salida.add(t + " F; ");
				}

			} else {
				salida.add(t + " F; ");
			}
			
		}
		System.out.println(salida);
		Archivo.escribirArchivo(salida, "D:\\Ana\\Patagonia\\HBS.7z\\HBS\\HBS-Patagonia-1.9.39\\salida.txt");

	}
	
	private static String ubicacion(){

	

	return System.getProperty("java.class.path");
}


}

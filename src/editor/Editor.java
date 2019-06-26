package editor;

import editor.Filtro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import datosExternos.Archivo;



public class Editor {

	
	static void procesar(String entrada, String tipoFiltro, String textoFiltro) throws FileNotFoundException, IOException{
		
		if (Archivo.esArchivo(entrada)){
			procesarUnicoArchivo(entrada,tipoFiltro,textoFiltro);
		}
		else {
			 File fRuta = new File(entrada);
			 String extension= "";
			procesarMultiplesArchivos(extension,entrada,tipoFiltro,textoFiltro, fRuta);
		}
	}
	
	public static void procesar(String entrada, String tipoFiltro, String textoFiltro, String extension) throws FileNotFoundException, IOException {
		File fRuta = new File(entrada);
		procesarMultiplesArchivos( extension,entrada,tipoFiltro,textoFiltro, fRuta);
		
	}
	
	static void procesarMultiplesArchivos(
			String extension, String archivoEntrada,
			String filtro, String texto, File fRuta)
			throws FileNotFoundException, IOException {
		
		ArrayList<String> listaArch = walkin(fRuta,extension);
		for (String archivoEnt : listaArch) {
			System.out.println(archivoEnt + " " + filtro + " "	+ listaArch.get(0)+ texto);
			procesarUnicoArchivo(  archivoEnt, filtro,	texto);
		}
	}
	
	/**
	 * @param args
	 */
	

	
//	static void filtraUnArchivoLog(String archivoEntrada, String filtro,String texto, String separador) throws FileNotFoundException, IOException {
//		System.out.println(archivoEntrada + " " + filtro + " " + texto);
//		
//		// Archivo Entrada
//		BufferedReader br = new BufferedReader(new FileReader(
//				archivoEntrada));
//		// Archivo Salida
//		BufferedWriter bw = new BufferedWriter(new FileWriter(
//				archivoEntrada + ".salida.txt"));
//		bw.flush();
//		
//		
//		String salida ="";
//		Filtro f = new Filtro(filtro);
//		Boolean contieneArroba;
//	    
//		String bloque ="";
//	    
//		
//		String[] parts = br.split(separador);
//		
//		for (String part : parts) {
//		   	   	salida =f.filtrar(part, texto);
//		    	bloque ="";
//		    	bloque = cadenaEntrada;
//		   
//		   
//		
//			if (salida != "") {
//				bw.append(salida);
//				bw.newLine();
//			}
//			;
//		}
//	
//	bw.close();
//	br.close();
//}

	

	// recorre directorios y los guarda en una lista
	public static ArrayList<String> walkin(File dir, String extension) {
		ArrayList<String> lista = new ArrayList<String>();
		File listFile[] = dir.listFiles();
		if (listFile != null) {
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isDirectory()) {
					walkin(listFile[i],extension);
				} else {
					if (extension.isEmpty()){
						lista.add(listFile[i].getPath());
					} else{
					if (listFile[i].getPath().contains(extension)) {
						lista.add(listFile[i].getPath());
					}
					}
				}
			}

		}
		return lista;
	}



	static void procesarUnicoArchivo( 
			String archivoEntrada, String filtro, String texto)
			throws FileNotFoundException, IOException {
		if (archivoEntrada.contains("tserver")){
	 
			filtraUnArchivoLog(archivoEntrada, filtro, texto,"@");}
		else if (archivoEntrada.contains("pad")){
			String separador ="======================================================";
			filtraUnArchivoLog(archivoEntrada, filtro, texto, separador);}
           else{
        	 //Caso simple un solo archivo de entrada un texto simple para filtrar
        	   filtraUnArchivo(archivoEntrada, filtro, texto);
           }
	   
	}
	
	static void filtraUnArchivo(String archivoEntrada, String filtro,
			String texto) throws FileNotFoundException, IOException {
		
		System.out.println(archivoEntrada + " " + filtro + " " + texto);
		
		// Archivo Entrada
		BufferedReader br = new BufferedReader(new FileReader(	archivoEntrada));
		// Archivo Salida
		BufferedWriter bw = new BufferedWriter(new FileWriter(	archivoEntrada + ".salida.txt"));
		bw.flush();
	
		
		String cadenaEntrada;
		Filtro f = new Filtro(filtro);
		String salida;
		while ((cadenaEntrada = br.readLine()) != null) {
			salida = f.filtrar(cadenaEntrada, texto);
			if (salida != "") {
				System.out.println(salida);
				bw.append(salida);
				bw.newLine();
			}
			
		}
		bw.close();
		br.close();
	}

	static void filtraUnArchivoLog(String archivoEntrada, String filtro,
			String texto, String separador) throws FileNotFoundException, IOException {
		
		System.out.println(archivoEntrada + " " + filtro + " " + texto);
		
		// Archivo Entrada
		BufferedReader br = new BufferedReader(new FileReader(	archivoEntrada));
		// Archivo Salida
		BufferedWriter bw = new BufferedWriter(new FileWriter(	archivoEntrada + ".salida.txt"));
		bw.flush();
	
		
		String cadenaEntrada;
		Filtro f = new Filtro(filtro);
		String salida;
		
		String filtrado ="";
		salida = br.readLine();
		
		while ((cadenaEntrada = br.readLine()) != null) {
			if (cadenaEntrada.contains(separador)){
				cadenaEntrada.replace("======================================================" , "===");
				if (!filtrado.equals("")) {
					System.out.println(salida);
					bw.append(salida);
					bw.newLine();
				}
				salida = "";
				filtrado ="";
			}
			
			filtrado = filtrado + f.filtrar(cadenaEntrada, texto);
			
			//Para que aparezca en multiples renglones
			salida = salida + "\n" + cadenaEntrada;
			
			//Para que aparezca cada caso en un solo renglon
			salida = salida + " --- " + cadenaEntrada;
			
			
		}
		bw.close();
		br.close();
	}
	


}

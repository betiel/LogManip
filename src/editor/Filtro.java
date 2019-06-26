package editor;


import java.io.IOException;
import java.util.ArrayList;

public class Filtro {
	
	String filtro = "";
	
public Filtro(){
	}

public Filtro(String f){
    setFiltro(f);		
	}

public String filtrar(String s, String texto) throws IOException{
	String out = "";
	out =((filtro.equalsIgnoreCase("contiene")&& s.toLowerCase().contains(texto.toLowerCase())) ? s:out);
	out =(filtro.equalsIgnoreCase("nocontiene")&& !s.toLowerCase().contains(texto.toLowerCase())) ? s:out;
	out = ((filtro.equalsIgnoreCase("c")&& s.toLowerCase().contains(texto.toLowerCase())) ? s:out);
	out= (filtro.equalsIgnoreCase("nc")&& !s.toLowerCase().contains(texto.toLowerCase())) ? s:out;
	
	return out;
	
};

public String filtrar (String s, ArrayList<String> lista) throws IOException{
	String out = "";
	
	for(String texto: lista){
	out= (filtro.equalsIgnoreCase("contieneAlgun")&& !s.toLowerCase().contains(texto.toLowerCase())) ? s:out;
	out= (filtro.equalsIgnoreCase("ca")&& !s.toLowerCase().contains(texto.toLowerCase())) ? s:out;
	}
	return out;
};
public String getFiltro() {
	return filtro;
}

public void setFiltro(String filtro) {
	this.filtro = filtro;
}



}

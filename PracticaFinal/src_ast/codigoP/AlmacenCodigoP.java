package codigoP;

import java.util.ArrayList;

public class AlmacenCodigoP {
	
	private static ArrayList<String> lista;
	
	public static void inicializaAlmacen(){
		AlmacenCodigoP.lista = new ArrayList<String>();
	}
	
	public static void addInst(String inst){
		AlmacenCodigoP.lista.add(inst);
	}
	
	public static ArrayList<String> getLista(){
		return AlmacenCodigoP.lista;
	}
	

}

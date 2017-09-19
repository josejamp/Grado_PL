package ast;

import java.util.HashMap;
import java.util.Stack;

import ast.declaraciones.Dec;
import ast.declaraciones.DescrT;
import ast.declaraciones.Vinculo;

public class TablaSimbolos {

	private static Stack<HashMap<String,Vinculo>> tabla;
	
	
	public static void iniciaTS(){
		TablaSimbolos.tabla = new Stack<HashMap<String,Vinculo>>();
	}
	
	public static void abreBloque(){
		TablaSimbolos.tabla.push( new HashMap<String, Vinculo>());
	}
	
	public static void cierraBloque(){
		TablaSimbolos.tabla.pop();
	}
	
	public static boolean insertaID(String id, Vinculo dec){
		HashMap<String,Vinculo> aux = TablaSimbolos.tabla.pop();
		if(!aux.containsKey(id)){
			aux.put(id, dec);
			TablaSimbolos.tabla.push(aux);
			return true;
		}
		else{
			TablaSimbolos.tabla.push(aux);
			return false;
		}
	}
	
	public static Vinculo declaracionDe(String id){
	
		for(int i = TablaSimbolos.tabla.size()-1; i >= 0; i--){
			
			if(TablaSimbolos.tabla.get(i).containsKey(id))
				return TablaSimbolos.tabla.get(i).get(id);
			
		}
		return null;
	}
	
	public static String tablaToString(){
		String res = "Tabla de simbolos:" + "\n";
		for(int i = TablaSimbolos.tabla.size()-1; i >= 0; i--){
			
			res += TablaSimbolos.tabla.get(i) + "\n";
			
		}
		return res;
		
	}
	
}

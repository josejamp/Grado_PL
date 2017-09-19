package ase;

import ast.Programa;
import ast.TablaSimbolos;
import java_cup.runtime.Symbol;
import constructorast.AnalizadorSintacticoTiny;

public class AnalizadorSemanticaEstatica {

	private AnalizadorSintacticoTiny constructorAST;
	
	public AnalizadorSemanticaEstatica(AnalizadorSintacticoTiny constr){
		this.constructorAST = constr;
	}
	
	public Programa analiza() throws Exception{
		
		Symbol s = this.constructorAST.parse();
		
		//System.out.println(s.value);
		 
		Programa p = (Programa)s.value;
		p.vincula(true);
		
		//System.out.println(TablaSimbolos.tablaToString());
		p.simplificaDeTipos();
		p.chequea();
		return p;
	}
	
}

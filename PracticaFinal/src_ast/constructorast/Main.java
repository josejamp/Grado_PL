package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import codigoP.GeneradorCodigoP;


import java_cup.runtime.Symbol;
import ase.AnalizadorSemanticaEstatica;
import ast.Prog;
import ast.Programa;

import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;
import ast.TablaSimbolos;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
	     Reader input = new InputStreamReader(new FileInputStream(args[0]));
		 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		 AnalizadorSintacticoTiny constructorast = new AnalizadorSintacticoTiny(alex);	
		 AnalizadorSemanticaEstatica analizador = new AnalizadorSemanticaEstatica(constructorast);
		 GeneradorCodigoP generador = new GeneradorCodigoP(analizador);
		 generador.generaCodigo();
		
	 }

}

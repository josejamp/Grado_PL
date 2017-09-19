package codigoP;

import ase.AnalizadorSemanticaEstatica;
import ast.Programa;
import constructorast.AnalizadorSintacticoTiny;

public class GeneradorCodigoP {

	private AnalizadorSemanticaEstatica ase;
	
	public GeneradorCodigoP(AnalizadorSemanticaEstatica ase){
		this.ase = ase;
	}
	
	public void generaCodigo() throws Exception{
		 Programa p = ase.analiza();
		 AlmacenCodigoP.inicializaAlmacen();
		 p.asignaEspacio(false);
		 p.etiquetas(null);
		 p.codigo(null);
		 EscribeEnFichero.escribe(AlmacenCodigoP.getLista());
	}
	
}

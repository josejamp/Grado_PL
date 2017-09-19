package maquinap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

import parser.ParserCodigoP;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		ParserCodigoP parser = new ParserCodigoP();
		parser.parser(args[0]);
		//parser.parser("codigoP.txt");
		
		MaquinaP maquina = new MaquinaP(500,500,parser.getPrograma());
	    maquina.ejecuta();

	}

}

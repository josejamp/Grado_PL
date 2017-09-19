package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import maquinap.Instruccion;
import maquinap.ValorEntero;
import maquinap.ValorReal;
import maquinap.instrucciones.*;

public class ParserCodigoP {
	
	private ArrayList<Instruccion> programa;
	
	public ParserCodigoP(){
		this.programa = new ArrayList<Instruccion>();
	}
	
	public Instruccion[] getPrograma(){
		Instruccion[] aux = new Instruccion[this.programa.size()];
		int i = 0;
		for(Instruccion inst: this.programa){
			aux[i] = inst;
			i++;
		}
		return aux;
	}
	
	public void parser(String arg){
		
		InputStream file;
		try {
			file = new FileInputStream( new File(arg));
			
			Scanner sc = null;
			sc = new Scanner(file, "UTF-8").useDelimiter("\\A");
			int i = 0;
			while(sc.hasNextLine()){
				
				String line = sc.nextLine();
				line = line.replaceAll("\\(", " ");
				line = line.replaceAll("\\)", "");
				String[] split = line.split("\\s+");
				
				//System.out.println("Line: " + line);
				 
				switch(split[0]){
				case "apila":{
					boolean entero = true;
					try{
						int v = Integer.valueOf(split[1]);
					}
					catch(NumberFormatException e){
						entero = false;
					}
					if(entero) this.programa.add( new Apila(new ValorEntero( Integer.valueOf(split[1]) )) );
					else this.programa.add( new Apila(new ValorReal( Double.valueOf(split[1]) )) );
				} break;
				case "apila_dir":{
					this.programa.add( new ApilaDir(Integer.valueOf(split[1])) );
				} break;
				case "apila_ind":{
					this.programa.add( new ApilaInd() );
				} break;
				case "desapila":{
					this.programa.add( new Desapila() );
				} break;
				case "desapila_dir":{
					this.programa.add( new DesapilaDir(Integer.valueOf(split[1])) );
				} break;
				case "desapila_ind":{
					this.programa.add( new DesapilaInd() );
				} break;
				case "mueve":{
					this.programa.add( new Mueve(Integer.valueOf(split[1])) );
				} break;
				case "alloc":{
					this.programa.add( new Alloc(Integer.valueOf(split[1])) );
				} break;
				case "free":{
					this.programa.add( new Free(Integer.valueOf(split[1])) );
				} break;
				case "and":{
					this.programa.add( new And() );
				} break;
				case "or":{
					this.programa.add( new Or() );
				} break;
				case "not":{
					this.programa.add( new Not() );
				} break;
				case "castInt":{
					this.programa.add( new CastInt() );
				} break;
				case "castReal":{
					this.programa.add( new CastReal() );
				} break;
				case "in":{
					this.programa.add( new Lee() );
				} break;
				case "out":{
					this.programa.add( new Escribe() );
				} break;
				case "ir_a":{
					this.programa.add( new IrA(Integer.valueOf(split[1])) );
				} break;
				case "ir_f":{
					this.programa.add( new IrF(Integer.valueOf(split[1])) );
				} break;
				case "ir_ind":{
					this.programa.add( new IrInd() );
				} break;
				case "mod":{
					this.programa.add( new Mod() );
				} break;
				case "div":{
					this.programa.add( new Div() );
				} break;
				case "igual":{
					this.programa.add( new Igual() );
				} break;
				case "mayor":{
					this.programa.add( new Mayor() );
				} break;
				case "mayorIgual":{
					this.programa.add( new MayorIgual() );
				} break;
				case "menor":{
					this.programa.add( new Menor() );
				} break;
				case "menorIgual":{
					this.programa.add( new MenorIgual() );
				} break;
				case "menos":{
					this.programa.add( new Menos() );
				} break;
				case "distinto":{
					this.programa.add( new NEq() );
				} break;
				case "resta":{
					this.programa.add( new Resta() );
				} break;
				case "suma":{
					this.programa.add( new Suma() );
				} break;
				case "mul":{
					this.programa.add( new Mul() );
				} break;
				default:{
					System.out.println(split[0]);
				} break;
				}
				i++;
			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

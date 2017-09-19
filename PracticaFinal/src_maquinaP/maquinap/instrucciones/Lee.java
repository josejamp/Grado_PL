package maquinap.instrucciones;

import java.util.Scanner;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class Lee implements Instruccion {

	public Lee(){
	}
	@Override
	public void ejecuta(MaquinaP maquina) {
		Valor resul;
		Scanner reader = new Scanner(System.in);
		if(reader.hasNextInt()){
			resul = maquina.nuevoValorEntero(reader.nextInt());
		}
		else if(reader.hasNextDouble()){
			resul = maquina.nuevoValorReal(reader.nextDouble());
		}
		else throw new UnsupportedOperationException("el valor debe ser entero o real");
		System.out.println("Leido: " + resul);
		maquina.apila(resul);
	    maquina.avanza();
	}

	
	
}

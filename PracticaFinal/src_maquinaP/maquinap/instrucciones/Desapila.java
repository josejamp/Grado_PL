package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;

public class Desapila implements Instruccion{

	@Override
	public void ejecuta(MaquinaP maquina) {
	     maquina.desapila();
	     maquina.avanza();   
	}

}

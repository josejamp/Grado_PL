package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class CastReal implements Instruccion{

	public double opera(double v1) {
		return v1;
	}

	public double opera(int v1) {
		return (double)v1;
	}
	
	public void ejecuta(MaquinaP maquina) {
	    Valor opnd1 = maquina.desapila();
	    Valor resul=null;
	    switch(opnd1.tipo()) {
        case VALOR_ENTERO: 
        	resul = maquina.nuevoValorReal(opera(opnd1.valorEntero())); break;
        case VALOR_REAL:
        	resul = maquina.nuevoValorReal(opera(opnd1.valorReal())); break;
	    }
	    maquina.apila(resul);
	    maquina.avanza();
	}
	
}

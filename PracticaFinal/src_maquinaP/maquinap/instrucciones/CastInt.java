package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class CastInt implements Instruccion{

	public int opera(int v1) {
		return v1;
	}

	public int opera(double v1) {
		return (int)v1;
	}
	
	public void ejecuta(MaquinaP maquina) {
	    Valor opnd1 = maquina.desapila();
	    Valor resul=null;
	    switch(opnd1.tipo()) {
        case VALOR_ENTERO: 
        	resul = maquina.nuevoValorEntero(opera(opnd1.valorEntero())); break;
        case VALOR_REAL:
        	resul = maquina.nuevoValorEntero(opera(opnd1.valorReal())); break;
	    }
	    maquina.apila(resul);
	    maquina.avanza();
	}

}

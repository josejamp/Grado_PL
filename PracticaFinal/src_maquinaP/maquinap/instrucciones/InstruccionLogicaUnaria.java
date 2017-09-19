package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public abstract class InstruccionLogicaUnaria implements Instruccion{

	public abstract int opera(int v1); 
	  public void ejecuta(MaquinaP maquina) {
	    Valor opnd1 = maquina.desapila();
	    Valor resul=null;
	    switch(opnd1.tipo()) {
	        case VALOR_ENTERO: 
	        	resul = maquina.nuevoValorEntero(opera(opnd1.valorEntero()));
	        	break;
	        case VALOR_REAL:
	        	throw new UnsupportedOperationException("el valor debe ser entero");
	    };
	    maquina.apila(resul);
	    maquina.avanza();
	  }
	
}

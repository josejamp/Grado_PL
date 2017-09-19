package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public abstract class InstruccionLogicaBinaria implements Instruccion {

	public abstract int opera(int v1, int v2); 
	  public void ejecuta(MaquinaP maquina) {
	    Valor opnd2 = maquina.desapila();
	    Valor opnd1 = maquina.desapila();
	    Valor resul=null;
	    switch(opnd1.tipo()) {
	        case VALOR_ENTERO: 
	             switch(opnd2.tipo()) {
	                 case VALOR_ENTERO: 
	                      resul = maquina.nuevoValorEntero(opera(opnd1.valorEntero(),opnd2.valorEntero()));
	                      break;  
	                 case VALOR_REAL: 
	                	 throw new UnsupportedOperationException("ambos valores deben ser enteros");
	             }
	             break;
	        case VALOR_REAL:
	             switch(opnd2.tipo()) {
	                 case VALOR_ENTERO: 
	                	 throw new UnsupportedOperationException("ambos valores deben ser enteros");
	                 case VALOR_REAL: 
	                	 throw new UnsupportedOperationException("ambos valores deben ser enteros");
	             }
	             break;
	    };
	    maquina.apila(resul);
	    maquina.avanza();
	  }
	
}

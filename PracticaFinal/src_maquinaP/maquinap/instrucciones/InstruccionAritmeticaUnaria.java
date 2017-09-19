package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public abstract class InstruccionAritmeticaUnaria implements Instruccion {
	  public abstract int opera(int v1);  
	  public abstract double opera(double v1);
	  public void ejecuta(MaquinaP maquina) {
	    Valor opnd1 = maquina.desapila();
	    Valor resul=null;
	    switch(opnd1.tipo()) {
	        case VALOR_ENTERO: 
	             switch(opnd1.tipo()) {
	                 case VALOR_ENTERO: 
	                      resul = maquina.nuevoValorEntero(opera(opnd1.valorEntero()));
	                      break;  
	                 case VALOR_REAL: 
	                      resul = maquina.nuevoValorReal(opera(opnd1.valorEntero()));
	                      break;
	             }
	             break;
	        case VALOR_REAL:
	             switch(opnd1.tipo()) {
	                 case VALOR_ENTERO: 
	                      resul = maquina.nuevoValorReal(opera(opnd1.valorReal()));
	                      break;  
	                 case VALOR_REAL: 
	                      resul = maquina.nuevoValorReal(opera(opnd1.valorReal()));
	                      break;
	             }
	             break;
	    };
	    maquina.apila(resul);
	    maquina.avanza();
	  }
}

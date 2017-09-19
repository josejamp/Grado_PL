package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.TIPOVALOR;
import maquinap.Valor;
import maquinap.ValorEntero;
import maquinap.ValorReal;

public class Mueve implements Instruccion {

	private int tam;
	public Mueve(int tam){
		this.tam = tam;
	}
	
	@Override
	public void ejecuta(MaquinaP maquina) {
		  Valor valorDireccionCima = maquina.desapila();
		  Valor valorDireccionSubcima = maquina.desapila();
		  int direccionCima = valorDireccionCima.valorEntero();
		  int direccionSubcima = valorDireccionSubcima.valorEntero();
		  
		  for(int i = 0; i < this.tam; i++){
			  	  
			  Valor v = maquina.consulta(direccionCima);
			  if(v.tipo().equals(TIPOVALOR.VALOR_ENTERO)){
				  //System.out.println("Mueve valor entero " + v.valorEntero() + " de direccion " + direccionCima + " a direccion "+ direccionSubcima);
				  maquina.actualiza(direccionSubcima, new ValorEntero(v.valorEntero()));  
			  }
			  else{
				  //System.out.println("Mueve valor real " + v.valorReal() + " de direccion " + direccionCima + " a direccion "+ direccionSubcima);
				  maquina.actualiza(direccionSubcima, new ValorReal(v.valorReal()));
			  }
			  
			  direccionCima = direccionCima+1;
			  direccionSubcima = direccionSubcima+1;
		  }
		  
		  maquina.avanza();
	}

}

package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class ApilaInd implements Instruccion {
   public void ejecuta(MaquinaP maquina) {
     Valor valorDireccion = maquina.desapila();
     int direccion = valorDireccion.valorEntero();
     Valor valor = maquina.consulta(direccion);
     maquina.apila(valor);
     maquina.avanza();
   } 
}

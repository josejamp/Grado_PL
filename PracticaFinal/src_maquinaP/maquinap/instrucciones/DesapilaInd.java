package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class DesapilaInd implements Instruccion {
   public void ejecuta(MaquinaP maquina) {
     Valor valor = maquina.desapila();
     Valor valorDireccion = maquina.desapila();
     int direccion = valorDireccion.valorEntero();
     maquina.actualiza(direccion,valor);
     maquina.avanza();
   } 
}

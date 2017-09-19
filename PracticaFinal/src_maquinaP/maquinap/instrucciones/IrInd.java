package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class IrInd implements Instruccion{
   public void ejecuta(MaquinaP maquina) {
     Valor valorDireccion = maquina.desapila();
     int direccion = valorDireccion.valorEntero();
     maquina.avanza(direccion);
   } 
}
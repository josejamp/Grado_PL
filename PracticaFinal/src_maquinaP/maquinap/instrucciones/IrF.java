package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class IrF implements Instruccion{
   private int dir;
   public IrF(int dir) {
     this.dir = dir;  
   }
   public void ejecuta(MaquinaP maquina) {
     Valor valor = maquina.desapila();
     int val = valor.valorEntero();
     if (val == 0) maquina.avanza(dir);
     else maquina.avanza();
   } 
}

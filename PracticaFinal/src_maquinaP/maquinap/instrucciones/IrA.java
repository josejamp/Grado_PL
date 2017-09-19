package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;

public class IrA implements Instruccion{
   private int dir;
   public IrA(int dir) {
     this.dir = dir;  
   }
   public void ejecuta(MaquinaP maquina) {
     maquina.avanza(dir);  
   } 
}

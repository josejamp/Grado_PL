package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class Free implements Instruccion {
   private int tamanio;
   public Free(int tamanio) {
    this.tamanio = tamanio;   
   }
   public void ejecuta(MaquinaP maquina) {
     Valor valorDir = maquina.desapila();
     int dir = valorDir.valorEntero();
     maquina.free(dir,tamanio);
     maquina.avanza();
   }    
}

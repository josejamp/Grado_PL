package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class Alloc implements Instruccion {
   private int tamanio;
   public Alloc(int tamanio) {
    this.tamanio = tamanio;   
   }
   public void ejecuta(MaquinaP maquina) {
     int dir = maquina.alloc(tamanio);
     Valor valorDir = maquina.nuevoValorEntero(dir);
     maquina.apila(valorDir);
     maquina.avanza();
   }    
}

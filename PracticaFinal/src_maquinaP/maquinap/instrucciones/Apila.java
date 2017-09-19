package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class Apila implements Instruccion {
   private Valor valor;
   public Apila(Valor valor) {
    this.valor = valor;   
   }
   public void ejecuta(MaquinaP maquina) {
     maquina.apila(valor);
     maquina.avanza();
   } 
}

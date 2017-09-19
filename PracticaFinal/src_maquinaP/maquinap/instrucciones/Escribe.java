package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class Escribe implements Instruccion {
   public Escribe() {
   }
   public void ejecuta(MaquinaP maquina) {
     Valor valor = maquina.desapila();
     System.out.println(valor);
     maquina.avanza();
   } 
}

package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class DesapilaDir implements Instruccion {
   private int dir;
   public DesapilaDir(int dir) {
    this.dir = dir;   
   }
   public void ejecuta(MaquinaP maquina) {
     Valor valor = maquina.desapila();
     maquina.actualiza(dir,valor);
     maquina.avanza();
   } 
}

package maquinap.instrucciones;

import maquinap.Instruccion;
import maquinap.MaquinaP;
import maquinap.Valor;

public class ApilaDir implements Instruccion {
   private int dir;
   public ApilaDir(int dir) {
    this.dir = dir;   
   }
   public void ejecuta(MaquinaP maquina) {
     Valor valor = maquina.consulta(dir);  
     maquina.apila(valor);
     maquina.avanza();
   } 
}

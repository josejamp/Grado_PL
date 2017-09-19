package maquinap.instrucciones;
import maquinap.Instruccion;
import maquinap.MaquinaP;
import static maquinap.TIPOVALOR.VALOR_ENTERO;
import static maquinap.TIPOVALOR.VALOR_REAL;
import maquinap.Valor;

public abstract class InstruccionComparacion implements Instruccion {
  public abstract int compara(int v1, int v2);  
  public abstract int compara(double v1, int v2);  
  public abstract int compara(int v1, double v2);  
  public abstract int compara(double v1, double v2);  
  public void ejecuta(MaquinaP maquina) {
    Valor opnd2 = maquina.desapila();
    Valor opnd1 = maquina.desapila();
    Valor resul=null;
    switch(opnd1.tipo()) {
        case VALOR_ENTERO: 
             switch(opnd2.tipo()) {
                 case VALOR_ENTERO: 
                      resul = maquina.nuevoValorEntero(compara(opnd1.valorEntero(),opnd2.valorEntero()));
                      break;  
                 case VALOR_REAL: 
                      resul = maquina.nuevoValorEntero(compara(opnd1.valorEntero(),opnd2.valorReal()));
                      break;
             }
             break;
        case VALOR_REAL:
             switch(opnd2.tipo()) {
                 case VALOR_ENTERO: 
                      resul = maquina.nuevoValorEntero(compara(opnd1.valorReal(),opnd2.valorEntero()));
                      break;  
                 case VALOR_REAL: 
                      resul = maquina.nuevoValorEntero(compara(opnd1.valorReal(),opnd2.valorReal()));
                      break;
             }
             break;
    };
    maquina.apila(resul);
    maquina.avanza();
  }
}
  

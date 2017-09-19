package maquinap;

public class ValorEntero extends Valor {
   private int valor;
   public ValorEntero(int valor) {
     this.valor = valor;  
   }
   public int valorEntero() {return valor;}
   public TIPOVALOR tipo() {return TIPOVALOR.VALOR_ENTERO;}
   public String toString() {return new Integer(valor).toString();}
}

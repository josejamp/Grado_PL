package maquinap;

public class ValorReal extends Valor {
   private double valor;
   public ValorReal(double valor) {
     this.valor = valor;  
   }
   public double valorReal() {return valor;}
   public TIPOVALOR tipo() {return TIPOVALOR.VALOR_REAL;}
   public String toString() {return new Double(valor).toString();}

}

package maquinap;

public abstract class Valor {
   public abstract TIPOVALOR tipo();
   public int valorEntero() {throw new UnsupportedOperationException("valorEntero");}
   public double valorReal() {throw new UnsupportedOperationException("valorReal");}
}

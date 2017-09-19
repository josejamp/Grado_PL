package maquinap.instrucciones;

public class Mod extends InstruccionAritmeticaBinaria {
	  public int opera(int v1,int v2) {
	     return v1%v2; 
	  }  
	  public double opera(double v1,int v2) {
		  throw new UnsupportedOperationException("ambos valores deben ser enteros"); 
	  }  
	  public double opera(int v1,double v2) {
		  throw new UnsupportedOperationException("ambos valores deben ser enteros"); 
	  }  
	  public double opera(double v1,double v2) {
		  throw new UnsupportedOperationException("ambos valores deben ser enteros"); 
	  }  
	}

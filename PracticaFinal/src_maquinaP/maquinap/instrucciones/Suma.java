package maquinap.instrucciones;

public class Suma extends InstruccionAritmeticaBinaria {
  public int opera(int v1,int v2) {
     return v1+v2; 
  }  
  public double opera(double v1,int v2) {
     return v1+v2; 
  }  
  public double opera(int v1,double v2) {
     return v1+v2; 
  }  
  public double opera(double v1,double v2) {
     return v1+v2; 
  }  
}
  
  
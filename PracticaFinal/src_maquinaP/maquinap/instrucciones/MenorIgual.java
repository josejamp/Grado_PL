package maquinap.instrucciones;

public class MenorIgual extends InstruccionComparacion {
	  public int compara(int v1,int v2) {
	     return (v1<=v2)?1:0; 
	  }  
	  public int compara(double v1,int v2) {
	     return (v1<=v2)?1:0; 
	  }  
	  public int compara(int v1,double v2) {
	     return (v1<=v2)?1:0; 
	  }  
	  public int compara(double v1,double v2) {
	     return (v1<=v2)?1:0; 
	  }  
}

package maquinap;

import java.util.LinkedList;
import java.util.List;

public class MaquinaP {
    private final static boolean DEBUG=false;
    private Valor[] memoriaDatos;
    private List<Valor> pilaEvaluacion;
    private Instruccion[] programa;
    private GestorMemoriaDinamica gestorMemoriaDinamica;
    private int pc;
    public MaquinaP(int memoriaEstatica, int memoriaDinamica, Instruccion[] programa) {
      memoriaDatos = new Valor[memoriaEstatica + memoriaDinamica];
      this.programa = programa;
      pilaEvaluacion = new LinkedList<>();
      pc=0;
      gestorMemoriaDinamica = new GestorMemoriaDinamica(memoriaEstatica,(memoriaEstatica+memoriaDinamica)-1);
    }
    public Valor nuevoValorEntero(int val) {
       return new ValorEntero(val); 
    }
    public Valor nuevoValorReal(double val) {
       return new ValorReal(val); 
    }
    public Valor desapila() {
       return pilaEvaluacion.remove(0);
    }
    public void apila(Valor valor) {
       pilaEvaluacion.add(0,valor);
    }
    public void actualiza(int dir, Valor valor) {
       memoriaDatos[dir] = valor;
    }
    public Valor consulta(int dir) {
       return memoriaDatos[dir]; 
    }
    public void avanza() {
     pc++;   
     if (DEBUG) {
    	 System.out.println("PC: " + pc);
    	 System.out.println("Pila: " + this.pilaEvaluacion);
     }
    }
    public void avanza(int pc) {
     this.pc = pc;   
     if (DEBUG) System.out.println("PC: " + this.pc);
    }
    public void ejecuta() {
     while (pc >= 0 && pc < programa.length) {
       programa[pc].ejecuta(this);
     }   
    }
    public int alloc(int tamanio) {
      return gestorMemoriaDinamica.alloc(tamanio);  
    }
    public void free(int dir, int tamanio) {
      gestorMemoriaDinamica.free(dir,tamanio);  
    }
}    

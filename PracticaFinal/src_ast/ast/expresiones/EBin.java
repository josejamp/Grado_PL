package ast.expresiones;

import ast.Prog;


public abstract class EBin extends E {
	
	protected E opnd1;
	protected E opnd2;
	public EBin(E opnd1, E opnd2, int row) {
		super(row);
	  this.opnd1 = opnd1;
	  this.opnd2 = opnd2;
	}
	public E opnd1() {return opnd1;}
	public E opnd2() {return opnd2;}  

	
	public void vincula(){
		this.opnd1.vincula();
		this.opnd2.vincula();
	}
	
	public void etiquetas(){
		this.opnd1.etiquetas();
		Prog.cinst = Prog.cinst + this.opnd1.numeroInstruccionesAccesoValor();
		this.opnd2.etiquetas();
		Prog.cinst = Prog.cinst + this.opnd2.numeroInstruccionesAccesoValor();
	}
	
	public void codigo(){
		this.opnd1.codigo();
		this.opnd1.generaInstruccionesAccesoValor();
		this.opnd2.codigo();
		this.opnd2.generaInstruccionesAccesoValor();
	}
}

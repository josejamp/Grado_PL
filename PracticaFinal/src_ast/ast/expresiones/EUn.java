package ast.expresiones;

import ast.Prog;

public abstract class EUn extends E {

	protected E opnd1;
	public EUn(E opnd1, int row) {
		super(row);
	  this.opnd1 = opnd1;
	}
	public E opnd1() {return opnd1;}
	
	
	public void vincula(){
		this.opnd1.vincula();
	}
	
	public void etiquetas(){
		this.opnd1.etiquetas();
		Prog.cinst = Prog.cinst + this.opnd1.numeroInstruccionesAccesoValor();
	}
	
	public void codigo(){
		this.opnd1.codigo();
		this.opnd1.generaInstruccionesAccesoValor();
	}
}

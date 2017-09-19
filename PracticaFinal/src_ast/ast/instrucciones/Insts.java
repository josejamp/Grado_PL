package ast.instrucciones;

import ast.declaraciones.DescrT;

public abstract class Insts {

	private int row;
	public Insts(int row){
		this.row = row;
		this.hayReturn = false;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoInsts tipo();
	
	public Insts insts(){throw new UnsupportedOperationException("instrucciones");}	
	public Inst inst(){throw new UnsupportedOperationException("instruccion");}

	public abstract void vincula();

	
	private DescrT tipoDeProcPadre;
	public DescrT getTipoDeProcPadre(){
		return this.tipoDeProcPadre;
	}
	public void setTipoDeProcPadre(DescrT tipoDeProcPadre){
		this.tipoDeProcPadre = tipoDeProcPadre;
	}
	public abstract void chequea();

	
	public abstract void etiquetas();

	public abstract int dirPrimeraInstruccion();

	public abstract void codigo();
	
	private boolean hayReturn;
	public boolean hayReturn(){
		return this.hayReturn;
	}
	public void setReturn(boolean hayReturn){
		this.hayReturn = hayReturn;
	}
	
}

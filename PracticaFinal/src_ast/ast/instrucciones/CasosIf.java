package ast.instrucciones;

import ast.declaraciones.DescrT;

public abstract class CasosIf {
	
	private int row;
	public CasosIf(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	public abstract TipoCasosIf tipo();
	
	public CasosIf casos(){throw new UnsupportedOperationException("casos de if");}
	public Caso caso(){throw new UnsupportedOperationException("caso de if");}

	public abstract void vincula();

	
	protected DescrT tipoDeProcPadre;
	public DescrT getTipoDeProcPadre(){
		return this.tipoDeProcPadre;
	}
	public void setTipoDeProcPadre(DescrT tipoDeProcPadre){
		this.tipoDeProcPadre = tipoDeProcPadre;
	}
	public abstract void chequea();

	
	public abstract void etiquetas();
	public abstract void codigo(int end);
	
	
	private boolean hayReturn;
	public boolean hayReturn(){
		return this.hayReturn;
	}
	public void setReturn(boolean hayReturn){
		this.hayReturn = hayReturn;
	}
}

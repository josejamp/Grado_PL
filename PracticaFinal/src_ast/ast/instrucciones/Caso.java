package ast.instrucciones;

import ast.declaraciones.DescrT;
import ast.expresiones.E;

public abstract class Caso {
	
	private int row;
	public Caso(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoCaso tipo();

	public E e(){throw new UnsupportedOperationException("expresion");}
	public Insts insts(){throw new UnsupportedOperationException("instrucciones");}

	public abstract void vincula();

	protected DescrT tipoDeProcPadre;
	public DescrT getTipoDeProcPadre(){
		return this.tipoDeProcPadre;
	}
	public void setTipoDeProcPadre(DescrT tipoDeProcPadre){
		this.tipoDeProcPadre = tipoDeProcPadre;
	}
	public abstract void chequea();

	protected int comienzo;
	protected int siguiente;
	public int getComienzo() {
		return comienzo;
	}
	public void setComienzo(int comienzo) {
		this.comienzo = comienzo;
	}
	public int getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}
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

package ast.instrucciones;

import ast.declaraciones.DescrT;
import ast.designadores.Designador;
import ast.expresiones.E;
import ast.expresiones.InvF;
import ast.expresiones.InvM;

public abstract class Inst {

	private int row;
	public Inst(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoInst tipo();
	
	public Designador des(){throw new UnsupportedOperationException("designador");}
	public E e(){throw new UnsupportedOperationException("expresion");}
	public Insts insts(){throw new UnsupportedOperationException("instrucciones");}
	public InvF invF(){throw new UnsupportedOperationException("invocacion funcion");}
	public InvM invM(){throw new UnsupportedOperationException("invocacion metodo");}
	public CasosIf casos(){throw new UnsupportedOperationException("casos de if");}

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

	public abstract void codigo();
	
	private boolean hayReturn;
	public boolean hayReturn() {
		return this.hayReturn;
	}
	public void setReturn(boolean hayReturn){
		this.hayReturn = hayReturn;
	}
	
}

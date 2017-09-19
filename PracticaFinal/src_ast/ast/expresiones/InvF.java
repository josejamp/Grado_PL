package ast.expresiones;

import ast.declaraciones.DescrT;
import ast.designadores.Designador;

public abstract class InvF {

	private int row;
	public InvF(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoInvF tipo();
	
	public String id(){throw new UnsupportedOperationException("id");}
	public Exp exp(){throw new UnsupportedOperationException("exp");}

	public abstract void vincula();

	protected DescrT tipo_des;
	 public DescrT getTpoDes(){
		 return this.tipo_des;
	 }
	public abstract void chequea();

	
	protected int comienzo;
	protected int siguiente;
	public abstract void etiquetas();

	public abstract void codigo();
	
}

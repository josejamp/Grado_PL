package ast.declaraciones;

import ast.Prog;

public abstract class DecF {
	
	private int row;
	public DecF(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoDecF tipo();

	public Cabecera cabecera(){throw new UnsupportedOperationException("cabecera de funcion");}
	public Prog prog(){throw new UnsupportedOperationException("programa");}
	public String id(){throw new UnsupportedOperationException("id");}

	public abstract void vincula();
	public abstract void vinculaRefs();

	public abstract void simplificaTipos();

	public abstract void chequea();

	public abstract int numParams();

	public abstract void muestraVinculos();

	public abstract int anidamiento();

	
	
	public abstract void asignaEspacio();
	public abstract void etiquetas();
	public abstract void codigo();
	
}

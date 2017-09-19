package ast.declaraciones;

import ast.Prog;

public abstract class DecM {

	private int row;
	public DecM(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoDecM tipo();
	
	public Cabecera cabecera(){throw new UnsupportedOperationException("cabecera de metodo");}
	public Prog prog(){throw new UnsupportedOperationException("programa");}
	public String id(){throw new UnsupportedOperationException("id");}
	
}

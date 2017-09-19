package ast.expresiones;

import ast.designadores.Designador;

public abstract class InvM {
	
	private int row;
	public InvM(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoInvM tipo();
	
	public Designador des(){throw new UnsupportedOperationException("designador");}
	public String id(){throw new UnsupportedOperationException("id");}
	public Exp exp(){throw new UnsupportedOperationException("exp");}
	
	
}

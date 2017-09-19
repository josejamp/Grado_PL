package ast.declaraciones;

import java.util.HashMap;

public abstract class Campos {

	private int row;
	public Campos(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoCampos tipo();
	
	public Campos campos(){throw new UnsupportedOperationException("campos de registro");}
	public Campo campo(){throw new UnsupportedOperationException("campo de registro");}

	
	public abstract void vincula(HashMap<String, Campo> tablaCampos);

	public abstract void vinculaRefs();

	public abstract Campos tipoSimplificado();

	public abstract void chequea();

	public abstract Campo obtenMiembro(String campo);

	public abstract boolean compatible(Campos campos);

	public abstract int numCampos();
	
	
	protected Integer tam;
	public Integer getTam(){
		return this.tam;
	}
	public abstract void asignaEspacio(int desp);
	public abstract void calculaTam(int desp);
	
	
}

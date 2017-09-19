package ast.declaraciones;

import java.util.HashMap;

public abstract class Campo {
	
	private int row;
	public Campo(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoCampo tipo();

	public DescrT descrT(){throw new UnsupportedOperationException("descripcion de tipo");}
	public String nombre(){throw new UnsupportedOperationException("id");}
	
	public abstract void vincula(HashMap<String, Campo> tablaCampos);

	public abstract void vinculaRefs();

	public abstract Campo tipoSimplificado();

	public abstract void chequea();

	public abstract boolean compatible(Campo campo);

	
	protected int tam;
	public int getTam(){
		return this.tam;
	}
	protected int desp;
	public int getDesp(){
		return this.desp;
	}
	public void setDesp(int desp){
		this.desp = desp;
	}
	public abstract void asignaEspacio();
	public abstract void calculaTam();
	
	
}

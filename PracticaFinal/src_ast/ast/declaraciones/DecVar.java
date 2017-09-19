package ast.declaraciones;

public abstract class DecVar {

	private int row;
	public DecVar(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoDecVar tipo();
	
	public DescrT descrT(){throw new UnsupportedOperationException("descripcion de tipo");}
	public String id(){throw new UnsupportedOperationException("id");}

	
	public abstract void vincula();
	public abstract void vinculaRefs();

	public abstract void simplificaDeTipos();

	public abstract void muestraVincuos();

	public abstract void chequea();

	public abstract void asignaEspacio();

	
}

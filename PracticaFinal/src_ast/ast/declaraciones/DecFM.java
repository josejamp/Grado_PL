package ast.declaraciones;

public abstract class DecFM {

	private int row;
	public DecFM(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoDecFM tipo();
	
	public DecF decF(){throw new UnsupportedOperationException("declaracion de funcion");}
	public DecM decM(){throw new UnsupportedOperationException("declaracion de metodo");}

	
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

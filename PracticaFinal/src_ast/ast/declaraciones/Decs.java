package ast.declaraciones;

public abstract class Decs {
	
	private int row;
	public Decs(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoDecs tipo();
	
	public Decs decs(){throw new UnsupportedOperationException("declaraciones");}
	public Dec dec(){throw new UnsupportedOperationException("declaracion");}

	public abstract void vincula();

	public abstract void vinculaRefs();

	public abstract void simplificaDeTipos();
	public abstract void muestraVinculos();

	public abstract void chequea();

	
	
	
	public abstract int anidamiento();
	public abstract void asignaEspacio();

	public abstract void etiquetas();

	public abstract void codigo();
	
}

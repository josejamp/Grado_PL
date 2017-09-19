package ast.declaraciones;

public abstract class Dec {
	
	private int row;
	public Dec(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoDec tipo();

	public DecVar decV(){throw new UnsupportedOperationException("declaracion de variable");}
	public DescrT descrT(){throw new UnsupportedOperationException("declaracion de tipo");}
	public DecFM decFM(){throw new UnsupportedOperationException("declaracion de funion/metodo");}

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

package ast.declaraciones;

public abstract class Params {

	private int row;
	public Params(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoParams tipo();
	
	public Params params(){throw new UnsupportedOperationException("declaracion de parametros");}
	public Par par(){throw new UnsupportedOperationException("declaracion de un parametro");}

	public abstract void vincula();

	public abstract void vinculaRefs();

	public abstract void simplificaTipos();

	public abstract void chequea();

	public abstract int numParams();

	
	
	public abstract void asignaEspacio();
	
}

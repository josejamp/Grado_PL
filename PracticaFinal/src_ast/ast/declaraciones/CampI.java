package ast.declaraciones;

public abstract class CampI {
	
	private int row;
	public CampI(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoCampI tipo();

	public DecM decM(){throw new UnsupportedOperationException("metodo");}
	public Campo campo(){throw new UnsupportedOperationException("atributo");}
	
}

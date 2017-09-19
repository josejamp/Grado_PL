package ast.declaraciones;

public abstract class CampoObj {

	private int row;
	public CampoObj(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoCampObj tipo();
	
	public CampoObj campoObj(){throw new UnsupportedOperationException("campos de objeto");}
	public CampI campI(){throw new UnsupportedOperationException("campo de objeto");}
	
}

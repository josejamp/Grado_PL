package ast.declaraciones;

public abstract class Par {

	private int row;
	public Par(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoPar tipo();
	
	public DescrT descrT(){throw new UnsupportedOperationException("descripcion de tipo");}
	public String id(){throw new UnsupportedOperationException("id");}

	public abstract void vincula();

	public abstract void vinculaRefs();

	public abstract void simplificaTipos();

	public abstract void chequea();

	
	protected InfoGeneracionCodigo info;
	public InfoGeneracionCodigo getInfo() {
		return info;
	}
	public void setInfo(InfoGeneracionCodigo info) {
		this.info = info;
	}
	public abstract void asignaEspacio();
	
}

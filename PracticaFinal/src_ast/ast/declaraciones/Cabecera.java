package ast.declaraciones;

public abstract class Cabecera {

	private int row;
	public Cabecera(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public abstract TipoCabecera tipo();
	
	public Params params(){throw new UnsupportedOperationException("declaracion de parametros");}
	public String id(){throw new UnsupportedOperationException("id");}
	public DescrT descrT(){throw new UnsupportedOperationException("descripcion de tipo");}

	public abstract void vincula(String id, InfoGeneracionCodigo info);

	public abstract void vinculaRefs();

	public abstract void simplificaTipos();

	public abstract void chequea();

	public abstract int numParams();

	public abstract void muestraVinculos();

	
	protected InfoGeneracionCodigo info;
	
	public abstract void asignaEspacio(InfoGeneracionCodigo info);

	public int getDirProl(){
		return this.info.getDirPrologoFun();
	}
	
}

package ast.declaraciones;

public class DecT extends Dec{

	private DescrT descrT;
	
	public DecT(DescrT descrT, int row){
		super(row);
		this.descrT = descrT;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}

	@Override
	public TipoDec tipo() {
		return TipoDec.DEC_T;
	}
	
	public String toString() {
		return "DecT( " + descrT().toString() + ")";
	}

	@Override
	public void vincula() {
		this.descrT.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.descrT.simplificaDeTipos();
	}

	@Override
	public void muestraVinculos() {
		this.descrT.muestraVinculos();
	}

	@Override
	public void chequea() {
		this.descrT.chequea();
	}

	@Override
	public int anidamiento() {
		return this.descrT.anidamiento();
	}

	@Override
	public void asignaEspacio() {
		this.descrT.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		this.descrT.etiquetas();
	}

	@Override
	public void codigo() {
		this.descrT.codigo();
	}
	
}

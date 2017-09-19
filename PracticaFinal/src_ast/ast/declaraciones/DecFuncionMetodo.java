package ast.declaraciones;

public class DecFuncionMetodo extends Dec{

	private DecFM decFM;
	
	public DecFuncionMetodo(DecFM decFM, int row){
		super(row);
		this.decFM = decFM;
	}
	
	public DecFM decFM(){
		return this.decFM;
	}

	@Override
	public TipoDec tipo() {
		return TipoDec.DEC_FUNCION_METODO;
	}
	
	public String toString() {
		return "DecFuncionMetodo( " + decFM().toString() + ")";
	}

	@Override
	public void vincula() {
		this.decFM.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.decFM.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.decFM.simplificaTipos();
	}

	@Override
	public void muestraVinculos() {
		this.decFM.muestraVinculos();
	}

	@Override
	public void chequea() {
		this.decFM.chequea();
	}

	@Override
	public int anidamiento() {
		return this.decFM.anidamiento();
	}

	@Override
	public void asignaEspacio() {
		this.decFM.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		this.decFM.etiquetas();
	}

	@Override
	public void codigo() {
		this.decFM.codigo();
	}
	
}

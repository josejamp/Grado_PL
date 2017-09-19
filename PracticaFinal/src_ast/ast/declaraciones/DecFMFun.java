package ast.declaraciones;

public class DecFMFun extends DecFM{
	
	private DecF decF;
	
	public DecFMFun(DecF decF, int row){
		super(row);
		this.decF = decF;
	}
	
	public DecF decF(){
		return this.decF;
	}

	@Override
	public TipoDecFM tipo() {
		return TipoDecFM.DEC_FM_FUN;
	}

	public String toString() {
		return "DecFMFun( " + decF().toString() + ")";
	}

	@Override
	public void vincula() {
		this.decF.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.decF.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.decF.simplificaTipos();
	}

	@Override
	public void chequea() {
		this.decF.chequea();
	}

	@Override
	public int numParams() {
		return this.decF.numParams();
	}

	@Override
	public void muestraVinculos() {
		this.decF.muestraVinculos();
	}

	@Override
	public int anidamiento() {
		return this.decF.anidamiento();
	}

	@Override
	public void asignaEspacio() {
		this.decF.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		this.decF.etiquetas();
	}

	@Override
	public void codigo() {
		this.decF.codigo();
	}
	
}

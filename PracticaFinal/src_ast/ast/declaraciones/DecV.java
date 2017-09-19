package ast.declaraciones;

public class DecV extends Dec{

	private DecVar decV;
	
	public DecV(DecVar decV, int row){
		super(row);
		this.decV = decV;
	}
	
	public DecVar decV(){
		return this.decV;
	}

	@Override
	public TipoDec tipo() {
		return TipoDec.DEC_V;
	}

	public String toString() {
		return "DecV( " + decV().toString() + ")";
	}

	@Override
	public void vincula() {
		this.decV.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.decV.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.decV.simplificaDeTipos();
	}

	@Override
	public void muestraVinculos() {
		this.decV.muestraVincuos();
	}

	@Override
	public void chequea() {
		this.decV.chequea();
	}

	@Override
	public int anidamiento() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		this.decV.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		
	}

	@Override
	public void codigo() {
		
	}

}

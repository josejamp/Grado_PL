package ast.declaraciones;

public class DeclaracionesSimple extends Decs{

	private Dec dec;
	
	public DeclaracionesSimple(Dec dec, int row){
		super(row);
		this.dec = dec;
	}
	
	public Dec dec(){
		return this.dec;
	}

	@Override
	public TipoDecs tipo() {
		return TipoDecs.DECLARACIONES_SIMPLE;
	}
	
	public String toString() {
		return "DeclaracionesSimple( " + dec().toString() + ")";
	}

	@Override
	public void vincula() {
		this.dec.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.dec.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.dec.simplificaDeTipos();
	}

	@Override
	public void muestraVinculos() {
		this.dec.muestraVinculos();
	}

	@Override
	public void chequea() {
		this.dec.chequea();
	}

	@Override
	public int anidamiento() {
		return this.dec.anidamiento();
	}

	@Override
	public void asignaEspacio() {
		this.dec.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		this.dec.etiquetas();
	}

	@Override
	public void codigo() {
		this.dec.codigo();
	}
	
}

package ast.instrucciones;

public class CasosIfSimple extends CasosIf{

	private Caso caso;
	
	public CasosIfSimple(Caso caso, int row){
		super(row);
		this.caso = caso;
	}
	
	public Caso caso(){
		return this.caso;
	}

	@Override
	public TipoCasosIf tipo() {
		return TipoCasosIf.CASOS_IF_SIMPLE;
	}
	
	public String toString() {
		return "CasosIfSimple( " + caso().toString() + ")";
	}

	@Override
	public void vincula() {
		this.caso.vincula();
	}

	@Override
	public void chequea() {
		this.caso.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.caso.chequea();
	}

	@Override
	public void etiquetas() {
		this.caso.etiquetas();
		this.setReturn(this.caso.hayReturn());
	}

	@Override
	public void codigo(int end) {
		this.caso.codigo(end);
	}
	
}

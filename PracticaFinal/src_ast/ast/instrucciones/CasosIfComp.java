package ast.instrucciones;

public class CasosIfComp extends CasosIf{
	
	private CasosIf casos;
	private Caso caso;
	
	public CasosIfComp(CasosIf casos, Caso caso, int row){
		super(row);
		this.casos = casos;
		this.caso = caso;
	}
	
	public CasosIf casos(){
		return this.casos;
	}
	
	public Caso caso(){
		return this.caso;
	}

	@Override
	public TipoCasosIf tipo() {
		return TipoCasosIf.CASOS_IF_COMP;
	}
	
	public String toString() {
		return "CasosIfComp( " + casos().toString() + ", " + caso().toString() + ")";
	}

	@Override
	public void vincula() {
		this.casos.vincula();
		this.caso.vincula();
	}

	@Override
	public void chequea() {
		this.casos.chequea();
		this.caso.chequea();
	}

	@Override
	public void etiquetas() {
		this.casos.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.casos.etiquetas();
		this.caso.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.caso.etiquetas();
		this.setReturn(this.casos.hayReturn() || this.caso.hayReturn());
	}

	@Override
	public void codigo(int end) {
		this.casos.codigo(end);
		this.caso.codigo(end);
	}

}

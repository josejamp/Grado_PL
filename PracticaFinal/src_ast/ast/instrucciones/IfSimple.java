package ast.instrucciones;

import ast.Prog;

public class IfSimple extends Inst{

	private CasosIf casos;
	
	public IfSimple(CasosIf casos, int row){
		super(row);
		this.casos = casos;
	}
	
	public CasosIf casos(){
		return this.casos;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.IF_SIMPLE;
	}
	
	public String toString() {
		return "IfSimple( " + casos().toString() + ")";
	}

	@Override
	public void vincula() {
		this.casos.vincula();
	}

	@Override
	public void chequea() {
		this.casos.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.casos.chequea();
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.casos.etiquetas();
		this.setReturn(this.casos.hayReturn());
		this.siguiente = Prog.cinst;		
	}

	@Override
	public void codigo() {
		this.casos.codigo(this.siguiente);
	}
	
}

package ast.instrucciones;

import ast.Prog;

public class IfElse extends Inst{
	
	private CasosIf casos;
	private Insts insts;
	
	public IfElse(CasosIf casos, Insts insts, int row){
		super(row);
		this.casos = casos;
		this.insts = insts;
	}
	
	public CasosIf casos(){
		return this.casos;
	}
	
	public Insts insts(){
		return this.insts;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.IF_ELSE;
	}
	
	public String toString() {
		return "IfElse( " + casos().toString() + ", " + insts().toString() + ")";
	}

	@Override
	public void vincula() {
		this.casos.vincula();
		this.insts.vincula();
	}

	@Override
	public void chequea() {
		this.casos.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.casos.chequea();
		this.insts.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.insts.chequea();
	}
	
	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.casos.etiquetas();
		this.insts.etiquetas();
		this.setReturn(this.casos.hayReturn() || this.insts.hayReturn());
		this.siguiente = Prog.cinst;
	}

	@Override
	public void codigo() {
		this.casos.codigo(this.siguiente);
		this.insts.codigo();
	}

}

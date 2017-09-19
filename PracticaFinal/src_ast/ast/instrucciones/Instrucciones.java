package ast.instrucciones;

public class Instrucciones extends Insts{
	
	private Insts insts;
	private Inst inst;
	
	public Instrucciones(Insts insts, Inst inst, int row){
		super(row);
		this.insts = insts;
		this.inst = inst;
		this.setReturn(false);
	}
	
	public Insts insts(){
		return this.insts;
	}
	
	public Inst inst(){
		return this.inst;
	}

	@Override
	public TipoInsts tipo() {
		return TipoInsts.INSTRUCCIONES;
	}
	
	public String toString() {
		return "Instrucciones( " + insts().toString() + ", " + inst().toString() + ")";
	}

	@Override
	public void vincula() {
		this.insts.vincula();
		this.inst.vincula();
	}

	@Override
	public void chequea() {
		this.insts.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.insts.chequea();
		this.inst.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.inst.chequea();
	}

	@Override
	public void etiquetas() {
		this.insts.etiquetas();
		this.inst.etiquetas();
		this.setReturn(this.insts.hayReturn() || this.inst.hayReturn());
	}

	@Override
	public int dirPrimeraInstruccion() {
		return this.insts.dirPrimeraInstruccion();
	}

	@Override
	public void codigo() {
		this.insts.codigo();
		this.inst.codigo();
	}

}

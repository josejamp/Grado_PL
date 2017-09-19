package ast.instrucciones;

public class Instruccion extends Insts{

	private Inst inst;
	
	public Instruccion(Inst inst, int row){
		super(row);
		this.inst = inst;
		this.setReturn(false);
	}
	
	public Inst inst(){
		return this.inst;
	}

	@Override
	public TipoInsts tipo() {
		return TipoInsts.INSTRUCCION;
	}
	
	public String toString() {
		return "Instruccion( " + inst().toString() + ")";
	}

	@Override
	public void vincula() {
		this.inst.vincula();
	}

	@Override
	public void chequea() {
		this.inst.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.inst.chequea();
	}

	@Override
	public void etiquetas() {
		this.inst.etiquetas();
		this.setReturn(this.inst.hayReturn());
	}

	@Override
	public int dirPrimeraInstruccion() {
		return this.inst.getComienzo();
	}

	@Override
	public void codigo() {
		this.inst.codigo();
	}
	
}

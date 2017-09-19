package ast.expresiones;

import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.declaraciones.Params;
import ast.declaraciones.TipoPar;

public class ExpComp extends Exp{

	private Exp exp;
	private E e;
	
	public ExpComp(Exp exp, E e, int row){
		super(row);
		this.exp = exp;
		this.e = e;
	}
	
	public Exp exp(){
		return this.exp;
	}
	
	public E e(){
		return this.e;
	}

	@Override
	public TipoExp tipo() {
		return TipoExp.EXP_COMP;
	}
	
	public String toString() {
		return "ExpComp( " + exp().toString() + ", " + e().toString() + ")";
	}

	@Override
	public void vincula() {
		this.exp.vincula();
		this.e.vincula();
	}

	@Override
	public int numParams() {
		return 1 + this.exp.numParams();
	}

	@Override
	public void chequea() {
		this.exp.chequea();
		this.e.chequea();
	}

	@Override
	public void chequeaTipos(Params params) {
		this.exp.chequeaTipos(params.params());
		if(!DescrT.tiposCompatibles(params.par().descrT(),this.e.getTipoDescrT()))
			GestionErroresSemanticos.error(this.getRow(),"Tipo de parametro no compatible");
		if(params.par().tipo().equals(TipoPar.PARAMETRO_REF) && !this.e.tipo().equals(TipoE.DESIGNADOR)){
			GestionErroresSemanticos.error(this.getRow(),"El parametro se debe pasar por referencia");
		}
	}

	@Override
	public void etiquetas() {
		this.exp.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesCalculoDirParametro();
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesPasoParametro();
	}



	@Override
	public void codigo(Params params) {
		this.exp.codigo(params.params());
		this.generaInstruccionesCalculoDirParametro(params);
		this.e.codigo();
		this.generaInstrucionesPasoParametro(params);
	}
}

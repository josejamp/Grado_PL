package ast.expresiones;

import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.declaraciones.Params;
import ast.declaraciones.TipoPar;

public class ExpSimple extends Exp{

	private E e;
	
	public ExpSimple(E e, int row){
		super(row);
		this.e = e;
	}
	
	public E e(){
		return this.e;
	}

	@Override
	public TipoExp tipo() {
		return TipoExp.EXP_SIMPLE;
	}
	
	public String toString() {
		return "ExpSimple( " + e().toString() + ")";
	}

	@Override
	public void vincula() {
		this.e.vincula();
	}

	@Override
	public int numParams() {
		return 1;
	}

	@Override
	public void chequea() {
		this.e.chequea();
	}

	@Override
	public void chequeaTipos(Params params) {
		if(!DescrT.tiposCompatibles(params.par().descrT(),this.e.getTipoDescrT()))
			GestionErroresSemanticos.error(this.getRow(),"Tipo de par�metro no compatible");
		if(params.par().tipo().equals(TipoPar.PARAMETRO_REF) && !this.e.tipo().equals(TipoE.DESIGNADOR)){
			GestionErroresSemanticos.error(this.getRow(),"El parametro se debe pasar por referencia");
		}
	}

	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesCalculoDirParametro();
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesPasoParametro();
	}

	@Override
	public void codigo(Params params) {
		this.generaInstruccionesCalculoDirParametro(params);
		this.e.codigo();
		this.generaInstrucionesPasoParametro(params);
	}
	
}

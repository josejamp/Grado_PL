package ast.declaraciones;

import ast.Prog;

public class ParametrosSimple extends Params{

	private Par par;
	
	public ParametrosSimple(Par par, int row){
		super(row);
		this.par = par;
	}
	
	public Par par(){
		return this.par;
	}

	@Override
	public TipoParams tipo() {
		return TipoParams.PARAMETROS_SIMPLE;
	}
	
	public String toString() {
		return "ParametrosSimple( " + par().toString() + ")";
	}

	@Override
	public void vincula() {
		this.par.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.par.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.par.simplificaTipos();
	}

	@Override
	public void chequea() {
		this.par.chequea();
	}

	@Override
	public int numParams() {
		return 1;
	}

	@Override
	public void asignaEspacio() {
		this.par.asignaEspacio();
	}
	
}

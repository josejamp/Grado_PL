package ast.declaraciones;

import ast.Prog;

public class Parametros extends Params{

	private Params params;
	private Par par;
	
	public Parametros(Params params, Par par, int row){
		super(row);
		this.params = params;
		this.par = par;
	}
	
	public Params params(){
		return this.params;
	}
	
	public Par par(){
		return this.par;
	}

	@Override
	public TipoParams tipo() {
		return TipoParams.PARAMETROS;
	}
	
	public String toString() {
		return "Parametros( " + params().toString() + ", " + par.toString() + ")";
	}

	@Override
	public void vincula() {
		this.params.vincula();
		this.par.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.params.vinculaRefs();
		this.par.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.params.simplificaTipos();
		this.par.simplificaTipos();
	}

	@Override
	public void chequea() {
		this.params.chequea();
		this.par.chequea();
	}

	@Override
	public int numParams() {
		return 1 + this.params.numParams();
	}
	
	@Override
	public void asignaEspacio() {
		this.params.asignaEspacio();
		this.par.asignaEspacio();
	}
	
	
}

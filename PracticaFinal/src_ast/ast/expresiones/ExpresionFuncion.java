package ast.expresiones;

import ast.Prog;

public class ExpresionFuncion extends E{

	private InvF fun;
	
	public ExpresionFuncion(InvF fun, int row){
		super(row);
		this.fun = fun;
	}
	
	public InvF fun(){
		return this.fun;
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.EXPRESION_FUNCION;
	}
	
	public String toString() {
		return "ExpresionFuncion( " + fun().toString() +")";
	}

	@Override
	public void vincula() {
		this.fun.vincula();
	}

	@Override
	public void chequea() {
		this.fun.chequea();
		super.tipo_des = this.fun.getTpoDes();
	}
	
	@Override
	public void etiquetas() {
		this.fun.etiquetas();
	}

	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void codigo() {
		this.fun.codigo();
	}
	
	

}

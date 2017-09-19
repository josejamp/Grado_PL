package ast.expresiones;

import ast.declaraciones.Params;

public class ExpVacia extends Exp{

	public ExpVacia(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoExp tipo() {
		return TipoExp.EXP_VACIA;
	}
	
	public String toString() {
		return "ExpVacia( )";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numParams() {
		return 0;
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
	}

	@Override
	public void chequeaTipos(Params params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiquetas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codigo(Params params) {
		// TODO Auto-generated method stub
		
	}

}

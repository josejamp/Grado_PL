package ast.declaraciones;

public class ParametrosVacio extends Params{

	public ParametrosVacio(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoParams tipo() {
		return TipoParams.PARAMETROS_VACIO;
	}
	
	public String toString() {
		return "ParametrosVacio( )";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vinculaRefs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simplificaTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numParams() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		// TODO Auto-generated method stub
		
	}

}

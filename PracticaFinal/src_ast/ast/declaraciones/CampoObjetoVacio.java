package ast.declaraciones;

public class CampoObjetoVacio extends CampoObj{

	public CampoObjetoVacio(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoCampObj tipo() {
		return TipoCampObj.CAMPO_OBJETO_VACIO;
	}

	public String toString() {
		return "CampoObjetoVacio( )";
	}
	
}

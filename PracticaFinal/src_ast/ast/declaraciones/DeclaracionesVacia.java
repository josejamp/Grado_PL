package ast.declaraciones;

public class DeclaracionesVacia extends Decs{
	
	public DeclaracionesVacia(int row) {
		super(row);
	}

	@Override
	public TipoDecs tipo() {
		return TipoDecs.DECLARACIONES_VACIA;
	}

	public String toString() {
		return "DeclaracionesVacia( )";
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
	public void simplificaDeTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int anidamiento() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiquetas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codigo() {
		// TODO Auto-generated method stub
		
	}
	
}

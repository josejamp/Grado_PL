package ast.declaraciones;

public class DeclaracionInt extends DescrT{

	public DeclaracionInt(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_INT;
	}
	
	public String toString() {
		return "DeclaracionInt( )";
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
	public DescrT tipoSimplificado() {
		return this;
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
	public Campo obtenMiembro(String campo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int anidamiento() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		this.calculaTam();
	}

	@Override
	public void etiquetas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codigo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculaTam() {
		super.tam = new Integer(1);
	}

}

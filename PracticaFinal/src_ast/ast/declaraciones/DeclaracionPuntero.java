package ast.declaraciones;

public class DeclaracionPuntero extends DescrT{

	private DescrT descrT;
	
	public DeclaracionPuntero(DescrT descrT, int row){
		super(row);
		this.descrT = descrT;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_PUNTERO;
	}
	
	public String toString() {
		return "DeclaracionPuntero( " + descrT().toString() + ")";
	}

	@Override
	public void vincula() {
		this.descrT.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DescrT tipoSimplificado() {
		this.descrT = this.descrT.tipoSimplificado();
		return this;
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		this.visitado = true;
		if(!visitado)this.descrT.chequea();
		this.visitado = false;
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
		this.descrT.asignaEspacio();
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

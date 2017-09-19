package ast.declaraciones;

public class DeclaracionArray extends DescrT{

	private DescrT descrT;
	private String num;
	
	public DeclaracionArray(DescrT descrT, String num, int row){
		super(row);
		this.descrT = descrT;
		this.num = num;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}
	
	public String num(){
		return this.num;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_ARRAY;
	}
	
	public String toString() {
		return "DeclaracionArray( " + descrT().toString() + ", " + num.toString() + ")";
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
		if(!visitado) this.descrT.chequea();
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
		if(this.tam == null){
			this.descrT.asignaEspacio();
			this.calculaTam();
		}
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
		this.descrT.calculaTam();
		this.tam = new Integer(this.descrT.getTam() * Integer.parseInt(this.num));
	}
	
}

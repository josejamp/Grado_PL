package ast.declaraciones;

import java.util.HashMap;

public class DeclaracionRegistro extends DescrT{

	private Campos campos;
	
	public DeclaracionRegistro(Campos campos, int row){
		super(row);
		this.campos = campos;
	}
	
	public Campos campos(){
		return this.campos;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_REGISTRO;
	}

	public String toString() {
		return "DeclaracionRegistro( " + campos().toString() + ")";
	}

	
	
	private HashMap<String, Campo> tablaCampos;
	
	@Override
	public void vincula() {
		this.tablaCampos = new HashMap<String, Campo>();
		this.campos.vincula(this.tablaCampos);
	}

	@Override
	public void vinculaRefs() {
		this.campos.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DescrT tipoSimplificado() {
		this.campos = this.campos.tipoSimplificado();
		return this;
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		this.visitado = true;
		if(!visitado)this.campos.chequea();
		this.visitado = false;
	}

	@Override
	public Campo obtenMiembro(String campo) {
		return this.campos.obtenMiembro(campo);
	}

	@Override
	public int anidamiento() {
		return 0;
	}

	@Override
	public void asignaEspacio() {
		if(this.tam == null){
			this.tam = 0;
			this.campos.asignaEspacio(0);
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
		this.tam = 0;
		this.campos.calculaTam(0);
		this.tam = new Integer(this.campos.getTam());
	}
	
}

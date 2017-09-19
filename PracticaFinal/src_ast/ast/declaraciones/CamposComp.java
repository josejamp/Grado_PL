package ast.declaraciones;

import java.util.HashMap;

public class CamposComp extends Campos{
	
	private Campos campos;
	private Campo campo;
	
	public CamposComp(Campos campos, Campo campo, int row){
		super(row);
		this.campos = campos;
		this.campo = campo;
	}
	
	public Campos campos(){
		return this.campos;
	}
	
	public Campo campo(){
		return this.campo;
	}

	@Override
	public TipoCampos tipo() {
		return TipoCampos.CAMPOS;
	}
	
	public String toString() {
		return "CampoComp( " + campos().toString() + ", " + campo.toString() + ")";
	}

	@Override
	public void vincula(HashMap<String, Campo> tablaCampos) {
		this.campos.vincula(tablaCampos);
		this.campo.vincula(tablaCampos);
	}

	@Override
	public void vinculaRefs() {
		this.campos.vinculaRefs();
		this.campo.vinculaRefs();
	}

	@Override
	public Campos tipoSimplificado() {
		this.campos = this.campos.tipoSimplificado();
		this.campo = this.campo.tipoSimplificado();
		return this;
	}

	@Override
	public void chequea() {
		this.campos.chequea();
		this.campo.chequea();
	}

	@Override
	public Campo obtenMiembro(String campo) {
		return this.campo.nombre().equals(campo)? this.campo:this.campos.obtenMiembro(campo);
	}

	@Override
	public boolean compatible(Campos campos) {
		return this.campos.compatible(campos.campos()) &&
			   this.campo.compatible(campos.campo());
	}

	@Override
	public int numCampos() {
		return 1 + this.campos.numCampos();
	}

	@Override
	public void asignaEspacio(int desp) {
		this.tam = desp;
		this.campos.asignaEspacio(this.tam);
		this.tam += this.campos.getTam();
		this.campo.asignaEspacio();
		this.campo.setDesp(this.tam);
		this.tam += this.campo.getTam();
		//System.out.println("Desp campo " + this.campo.nombre() + ": " + this.campo.getDesp());
	}

	@Override
	public void calculaTam(int desp) {
		this.tam = desp;
		this.campos.calculaTam(this.tam);
		this.tam += this.campos.getTam();
		this.campo.calculaTam();
		this.tam += this.campo.getTam();
	}

}

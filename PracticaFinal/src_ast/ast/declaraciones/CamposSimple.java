package ast.declaraciones;

import java.util.HashMap;

public class CamposSimple extends Campos{

	private Campo campo;
	
	public CamposSimple(Campo campo, int row){
		super(row);
		this.campo = campo;
	}
	
	public Campo campo(){
		return this.campo;
	}

	@Override
	public TipoCampos tipo() {
		return TipoCampos.CAMPOS_SIMPLE;
	}
	
	public String toString() {
		return "CamposSimple( " + campo.toString() + ")";
	}

	@Override
	public void vincula(HashMap<String, Campo> tablaCampos) {
		this.campo.vincula(tablaCampos);
	}

	@Override
	public void vinculaRefs() {
		this.campo.vinculaRefs();
	}

	@Override
	public Campos tipoSimplificado() {
		this.campo = this.campo.tipoSimplificado();
		return this;
	}

	@Override
	public void chequea() {
		this.campo.chequea();
	}

	@Override
	public Campo obtenMiembro(String campo) {
		return this.campo.nombre().equals(campo)? this.campo:null;
	}

	@Override
	public boolean compatible(Campos campos) {
		return this.campo.compatible(campos.campo());
	}

	@Override
	public int numCampos() {
		return 1;
	}

	@Override
	public void asignaEspacio(int desp) {
		this.campo.asignaEspacio();
		this.tam = this.campo.getTam();
		this.campo.setDesp(desp);
		//System.out.println("Desp campo " + this.campo.nombre() + ": " + this.campo.getDesp());
	}

	@Override
	public void calculaTam(int desp) {
		this.campo.calculaTam();
		this.tam = this.campo.getTam();
	}
	
}

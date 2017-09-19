package ast.declaraciones;

import java.util.HashMap;

import errors.GestionErroresSemanticos;

public class CampoConst extends Campo{

	private DescrT descrT;
	private String id;
	
	public CampoConst(DescrT descrT, String id, int row){
		super(row);
		this.descrT = descrT;
		this.id = id;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}
	
	public String nombre(){
		return this.id;
	}

	@Override
	public TipoCampo tipo() {
		return TipoCampo.CAMPO_CONST;
	}
	
	public String toString() {
		return "CampoConst( " + descrT().toString() + ", " + id.toString() + ")";
	}

	@Override
	public void vincula(HashMap<String, Campo> tablaCampos) {
		if(tablaCampos.containsKey(this.id)) GestionErroresSemanticos.error(this.getRow(),"campo repetido");
		else tablaCampos.put(id, this);
		this.descrT.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public Campo tipoSimplificado() {
		this.descrT = this.descrT.tipoSimplificado();
		return this;
	}

	@Override
	public void chequea() {
		this.descrT.chequea();
	}

	@Override
	public boolean compatible(Campo campo) {
		return DescrT.tiposCompatibles(this.descrT, campo.descrT());
	}

	@Override
	public void asignaEspacio() {
		this.descrT.asignaEspacio();
		this.tam = this.descrT.getTam();
		//System.out.println("En campo: " + this.tam);
	}

	@Override
	public void calculaTam() {
		this.descrT.calculaTam();
		this.tam = this.descrT.getTam();
	}
	
}

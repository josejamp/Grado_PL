package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.TablaSimbolos;

public class DecTipo extends DescrT{
	
	private DescrT descrT;
	private String id;
	
	public DecTipo(DescrT descrT, String id, int row){
		super(row);
		this.descrT = descrT;
		this.id = id;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DEC_TIPO;
	}
	
	public String toString() {
		return "DecTipo( " + descrT().toString() + ", " + id.toString() + ")";
	}

	@Override
	public void vincula() {
		this.descrT.vincula();
		if(!TablaSimbolos.insertaID(this.id, new Vinculo(this.descrT, TipoDec.DEC_T))) GestionErroresSemanticos.error(this.getRow(),"identificador duplicado");
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.descrT = this.descrT.tipoSimplificado();
	}

	@Override
	public DescrT tipoSimplificado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void muestraVinculos() {
		System.out.println("Vinculo de " + this.id + ": " + this.descrT.toString());
	}

	@Override
	public void chequea() {
		this.descrT.chequea();
	}

	@Override
	public Campo obtenMiembro(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int anidamiento() {
		return this.descrT.anidamiento();
	}

	@Override
	public void asignaEspacio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiquetas() {
		this.descrT.etiquetas();
	}

	@Override
	public void codigo() {
		this.descrT.codigo();
	}

	@Override
	public void calculaTam() {
		// TODO Auto-generated method stub
		
	}

}

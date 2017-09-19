package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.TablaSimbolos;

public class CabeceraSimple extends Cabecera{

	private Params params;
	private String id;
	
	public CabeceraSimple(Params params, String id, int row){
		super(row);
		this.params = params;
		this.id = id;
		this.info = new InfoGeneracionCodigo();
	}
	
	public Params params(){
		return this.params;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoCabecera tipo() {
		return TipoCabecera.CABECERA_SIMPLE;
	}
	
	public String toString() {
		return "CabeceraCSimple( " + params().toString()+", "+ id().toString()+ ")";
	}

	@Override
	public void vincula(String id, InfoGeneracionCodigo info) {
		this.info = info;
		TablaSimbolos.abreBloque();
		if(!id.equals(this.id)) GestionErroresSemanticos.error(this.getRow(),"funcion con distintos identificadores");
		TablaSimbolos.insertaID(this.id, new VinculoProc(new DeclaracionInt(this.getRow()), TipoDec.DEC_FUNCION_METODO, info, false, this.params));
		this.params.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.params.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.params.simplificaTipos();
	}

	@Override
	public void chequea() {
		this.params.chequea();
	}
	
	@Override
	public int numParams() {
		return this.params.numParams();
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void asignaEspacio(InfoGeneracionCodigo info) {
		this.info.setDir(info.getDir());
		this.info.setNivel(info.getNivel());
		this.info.setTam(info.getTam());
		this.info.setDirPrologoFun(info.getDirPrologoFun());
		this.params.asignaEspacio();
	}
	
}

package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.TablaSimbolos;

public class CabeceraComp extends Cabecera{

	private Params params;
	private String id;
	private DescrT descrT;
	
	public CabeceraComp(Params params, String id, DescrT descrT, int row){
		super(row);
		this.params = params;
		this.id = id;
		this.descrT = descrT;
		this.info = new InfoGeneracionCodigo();
	}
	
	public Params params(){
		return this.params;
	}
	
	public String id(){
		return this.id;
	}
	
	public DescrT descrT(){
		return this.descrT;
	}

	@Override
	public TipoCabecera tipo() {
		return TipoCabecera.CABECERA_COMP;
	}
	
	public String toString() {
		return "CabeceraComp( " + params().toString()+", "+ id().toString() + ", " + descrT().toString() + ")";
	}

	@Override
	public void vincula(String id, InfoGeneracionCodigo info) {
		this.info = info;
		this.descrT.vincula();
		TablaSimbolos.abreBloque();
		if(!id.equals(this.id)) GestionErroresSemanticos.error(this.getRow(),"funcion con distintos identificadores");
		TablaSimbolos.declaracionDe(this.id);
		TablaSimbolos.insertaID(this.id, new VinculoProc( this.descrT, TipoDec.DEC_FUNCION_METODO, info, false, this.params));
		this.params.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
		this.params.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.params.simplificaTipos();
		this.descrT = this.descrT.tipoSimplificado();
	}

	@Override
	public void chequea() {
		this.params.chequea();
		this.descrT.chequea();
		if(!this.descrT.tipo().equals(TipoDescrT.DECLARACION_INT) &&
				!this.descrT.tipo().equals(TipoDescrT.DECLARACION_REAL) &&
				!this.descrT.tipo().equals(TipoDescrT.DECLARACION_PUNTERO)){
			GestionErroresSemanticos.error(this.getRow(),"El tipo de la funcion deber ser int, real o un puntero");
		}
	}

	@Override
	public int numParams() {
		return this.params.numParams();
	}

	@Override
	public void muestraVinculos() {
		this.descrT.muestraVinculos();
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

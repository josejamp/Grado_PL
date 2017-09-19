package ast.declaraciones;

import errors.GestionErroresSemanticos;

public class DeclaracionObjeto extends DescrT{

	private CampoObj campoObj;
	private String id;
	
	public DeclaracionObjeto(CampoObj campoObj, String id, int row){
		super(row);
		this.campoObj = campoObj;
		this.id = id;
	}
	
	public CampoObj campoObj(){
		return this.campoObj;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_OBJETO;
	}
	
	public String toString() {
		return "DeclaracionObjeto( " + campoObj().toString() + ", " + id.toString() + ")";
	}

	@Override
	public void vincula() {
		GestionErroresSemanticos.error(this.getRow(),"El lenguaje no admite orientacion a objetos");
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void asignaEspacio() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
}

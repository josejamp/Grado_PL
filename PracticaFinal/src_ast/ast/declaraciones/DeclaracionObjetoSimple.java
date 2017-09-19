package ast.declaraciones;

import errors.GestionErroresSemanticos;

public class DeclaracionObjetoSimple extends DescrT{

	private CampoObj campoObj;
	
	public DeclaracionObjetoSimple(CampoObj campoObj, int row){
		super(row);
		this.campoObj = campoObj;
	}
	
	public CampoObj campoObj(){
		return this.campoObj;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DECLARACION_OBJETO_SIMPLE;
	}
	
	public String toString() {
		return "DeclaracionObjetoSimple( " + campoObj().toString() + ")";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
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

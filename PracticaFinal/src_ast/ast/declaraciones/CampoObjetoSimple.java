package ast.declaraciones;

public class CampoObjetoSimple extends CampoObj{

	private CampI campI;
	
	public CampoObjetoSimple(CampI campI, int row){
		super(row);
		this.campI = campI;
	}
	
	public CampI campI(){
		return this.campI;
	}

	@Override
	public TipoCampObj tipo() {
		return TipoCampObj.CAMPO_OBJETO_SIMPLE;
	}
	
	public String toString() {
		return "CampoI( " + campI().toString() + ")";
	}
	
}

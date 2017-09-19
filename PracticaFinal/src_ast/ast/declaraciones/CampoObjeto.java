package ast.declaraciones;

public class CampoObjeto extends CampoObj{

	private CampoObj campoObj;
	private CampI campI;
	
	public CampoObjeto(CampoObj campoObj, CampI campI, int row){
		super(row);
		this.campoObj = campoObj;
		this.campI = campI;
	}
	
	public CampoObj campoObj(){
		return this.campoObj;
	}
	
	public CampI campI(){
		return this.campI;
	}

	@Override
	public TipoCampObj tipo() {
		return TipoCampObj.CAMPO_OBJETO;
	}
	
	public String toString() {
		return "CampoObjeto( " + campoObj().toString() + ", " + campI.toString() + ")";
	}
	
}

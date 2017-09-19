package ast.declaraciones;

public class CampIMetodo extends CampI{

	private DecM decM;
	
	public CampIMetodo(DecM decM, int row){
		super(row);
		this.decM = decM;
	}
	
	public DecM decM(){
		return this.decM;
	}

	@Override
	public TipoCampI tipo() {
		return TipoCampI.CAMPO_I_METODO;
	}
	
	public String toString() {
		return "CampIMetodo( " + decM().toString() + ")";
	}
	
}

package ast.declaraciones;

public class CampICampo extends CampI{

	private Campo campo;
	
	public CampICampo(Campo campo, int row){
		super(row);
		this.campo = campo;
	}
	
	public Campo campo(){
		return this.campo;
	}

	@Override
	public TipoCampI tipo() {
		return TipoCampI.CAMPO_I_CAMPO;
	}
	
	public String toString() {
		return "CampICampo( " + campo().toString() + ")";
	}
	
}

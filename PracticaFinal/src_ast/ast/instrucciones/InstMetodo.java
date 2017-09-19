package ast.instrucciones;

import errors.GestionErroresSemanticos;
import ast.expresiones.InvM;

public class InstMetodo extends Inst{

	private InvM invM;
	
	public InstMetodo(InvM invM, int row){
		super(row);
		this.invM = invM;
	}
	
	public InvM invM(){
		return this.invM;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.INST_METODO;
	}
	
	public String toString() {
		return "InstMetodo( " + invM().toString() + ")";
	}

	@Override
	public void vincula() {
		GestionErroresSemanticos.error(this.getRow(),"El lenguaje no admite orientacion a objetos");
	}

	@Override
	public void chequea() {
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
	
}

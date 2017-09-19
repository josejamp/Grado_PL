package ast.expresiones;

import errors.GestionErroresSemanticos;
import ast.Prog;

public class ExpresionMetodo extends E{

	private InvM met;
	
	public ExpresionMetodo(InvM met, int row){
		super(row);
		this.met = met;
	}
	
	public InvM met(){
		return this.met;
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.EXPRESION_METODO;
	}
	
	public String toString() {
		return "ExpresionFuncion( " + met().toString() + ")";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
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
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void codigo() {
		// TODO Auto-generated method stub
		
	}
	
}

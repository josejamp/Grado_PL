package ast.expresiones;

import codigoP.AlmacenCodigoP;
import ast.Prog;
import ast.declaraciones.DeclaracionInt;

public class ExpEntero extends E{

	private String entero;
	
	public ExpEntero(String entero, int row) {
		super(row);
		this.entero = entero;   
	}
	public String entero() {return entero;}
	
	@Override
	public TipoE tipo() {
		return TipoE.ENTERO;
	}
	
	public String toString() {
		return "ExpEntero( " + entero().toString() + ")";
	}
	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void chequea() {
		super.tipo_des = new DeclaracionInt(this.getRow());
	}
	
	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesEntero();
	}
	private int numeroInstruccionesEntero() {
		// apila(valor)
		return 1;
	}
	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void codigo() {
		this.generaInstruccionesEntero();
	}
	private void generaInstruccionesEntero() {
		int valor = Integer.parseInt(this.entero);
		AlmacenCodigoP.addInst("apila("+valor+")");
	}

}

package ast.expresiones;

import codigoP.AlmacenCodigoP;
import ast.Prog;
import ast.declaraciones.DeclaracionInt;
import ast.declaraciones.DeclaracionReal;

public class ExpReal extends E{

	private String real;
	
	public ExpReal(String real, int row) {
		super(row);
		this.real = real;   
	}
	public String real() {return real;}
	
	@Override
	public TipoE tipo() {
		return TipoE.REAL;
	}
	
	public String toString() {
		return "ExpReal( " + real().toString() + ")";
	}
	
	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void chequea() {
		super.tipo_des = new DeclaracionReal(this.getRow());
	}
	
	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesReal();
	}
	private int numeroInstruccionesReal() {
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
		this.generaInstruccionesReal();
	}
	private void generaInstruccionesReal() {
		double valor = Double.valueOf(this.real);
		AlmacenCodigoP.addInst("apila("+valor+")");
	}
	
}

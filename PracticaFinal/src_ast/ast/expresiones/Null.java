package ast.expresiones;

import codigoP.AlmacenCodigoP;
import ast.Prog;
import ast.declaraciones.DeclaracionPuntero;

public class Null extends E{

	public Null(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoE tipo() {
		return TipoE.NULL;
	}

	public String toString() {
		return "Null( )";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		super.tipo_des = new DeclaracionPuntero(null, this.getRow());
	}

	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesNull();
	}

	private int numeroInstruccionesNull() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void codigo() {
		AlmacenCodigoP.addInst("apila(-1)");
	}	
	
}

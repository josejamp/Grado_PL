package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import ast.Prog;
import ast.expresiones.InvF;

public class InstFuncion extends Inst{

	private InvF invF;
	
	public InstFuncion(InvF invF, int row){
		super(row);
		this.invF = invF;
	}
	
	public InvF invF(){
		return this.invF;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.INST_FUNCION;
	}
	
	public String toString() {
		return "InstFuncion( " + invF().toString() + ")";
	}

	@Override
	public void vincula() {
		this.invF.vincula();
	}

	@Override
	public void chequea() {
		this.invF.chequea();
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.invF.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesFinInstFuncion();
		this.siguiente = Prog.cinst;
	}

	private int numeroInstruccionesFinInstFuncion() {
		// deaspila
		return 1;
	}

	@Override
	public void codigo() {
		this.invF.codigo();
		this.generaInstruccionesFinInstFuncion();
	}

	private void generaInstruccionesFinInstFuncion() {
		AlmacenCodigoP.addInst("desapila");
	}
	
}

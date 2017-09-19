package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.TipoDescrT;
import ast.expresiones.E;

public class Escritura extends Inst{

	private E e;
	
	public Escritura(E e, int row){
		super(row);
		this.e = e;
	}
	
	public E e(){
		return this.e;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.ESCRITURA;
	}
	
	public String toString() {
		return "Escritura( " + e().toString() + ")";
	}

	@Override
	public void vincula() {
		this.e.vincula();
	}

	@Override
	public void chequea() {
		this.e.chequea();
		if(!this.e.getTpoDes().equals(TipoDescrT.DECLARACION_INT) &&
		   !this.e.getTpoDes().equals(TipoDescrT.DECLARACION_REAL)){
			GestionErroresSemanticos.error(this.getRow(),"La expresion debe ser entera o real");
		}
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.e.numeroInstruccionesAccesoValor();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesFinWrite();
		this.siguiente = Prog.cinst;
		
	}

	private int numeroInstruccionesFinWrite() {
		// out
		return 1;
	}

	@Override
	public void codigo() {
		this.e.codigo();
		this.e.generaInstruccionesAccesoValor();
		this.generaInstruccionesFinWrite();
	}

	private void generaInstruccionesFinWrite() {
		AlmacenCodigoP.addInst("out");
	}
	
	
}

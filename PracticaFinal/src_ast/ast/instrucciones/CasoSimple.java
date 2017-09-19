package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.TipoDescrT;
import ast.expresiones.E;

public class CasoSimple extends Caso{

	private E e;
	private Insts insts;
	
	public CasoSimple(E e, Insts insts, int row){
		super(row);
		this.e = e;
		this.insts = insts;
	}
	
	public E e(){
		return this.e;
	}
	
	public Insts insts(){
		return this.insts;
	}
	
	@Override
	public TipoCaso tipo() {
		return TipoCaso.CASO_SIMPLE;
	}

	public String toString() {
		return "CasoSimple( " + e().toString() + ", " + insts().toString() + ")";
	}

	@Override
	public void vincula() {
		this.e.vincula();
		this.insts.vincula();
	}

	@Override
	public void chequea() {
		this.e.chequea();
		if(!this.e.getTpoDes().equals(TipoDescrT.DECLARACION_INT)){
			GestionErroresSemanticos.error(this.getRow(),"La expresion debe ser entera");
		}
		this.insts.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.insts.chequea();
	}
	
	public void etiquetas() {
		this.e.etiquetas();
		//System.out.println("Prog.cinst if antes: " + Prog.cinst);
		Prog.cinst = Prog.cinst + this.e.numeroInstruccionesAccesoValor();
		Prog.cinst = Prog.cinst + 1;
		this.comienzo = Prog.cinst;
		this.insts.etiquetas();
		this.setReturn(this.insts.hayReturn());
		Prog.cinst = Prog.cinst + 1;
		this.siguiente = Prog.cinst;
		//System.out.println("Prog.cinst if despues: " + Prog.cinst);
	}

	@Override
	public void codigo(int end) {
		this.e.codigo();
		this.e.generaInstruccionesAccesoValor();
		AlmacenCodigoP.addInst("ir_f("+(this.siguiente)+")");
		this.insts.codigo();
		AlmacenCodigoP.addInst("ir_a("+end+")");
	}
}

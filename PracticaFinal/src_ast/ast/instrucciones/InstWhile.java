package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.TipoDescrT;
import ast.expresiones.E;

public class InstWhile extends Inst{
	
	private E e;
	private Insts insts;
	
	public InstWhile(E e, Insts insts, int row){
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
	public TipoInst tipo() {
		return TipoInst.INST_WHILE;
	}

	public String toString() {
		return "While( " + e().toString() + ", " + insts().toString() + ")";
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

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.e.numeroInstruccionesAccesoValor();
		Prog.cinst = Prog.cinst + 1;
		this.insts.etiquetas();
		this.setReturn(this.insts.hayReturn());
		Prog.cinst = Prog.cinst + 1;
		this.siguiente = Prog.cinst;
		
	}

	@Override
	public void codigo() {
		this.e.codigo();
		this.e.generaInstruccionesAccesoValor();
		AlmacenCodigoP.addInst("ir_f("+this.siguiente+")");
		this.insts.codigo();
		AlmacenCodigoP.addInst("ir_a("+this.comienzo+")");
	}
	
}

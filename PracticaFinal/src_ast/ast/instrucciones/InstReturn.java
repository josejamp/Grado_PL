package ast.instrucciones;

import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.expresiones.E;

public class InstReturn extends Inst{

	private E e;
	
	public InstReturn(E e, int row){
		super(row);
		this.e = e;
	}
	
	public E e(){
		return this.e;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.INST_RETURN;
	}
	
	public String toString() {
		return "Return( " + e().toString() + ")";
	}

	@Override
	public void vincula() {
		this.e.vincula();
	}

	@Override
	public void chequea() {
		this.e.chequea();
		if(super.tipoDeProcPadre == null){
			GestionErroresSemanticos.error(this.getRow(),"Solo puede haber return dentro de una funcion");
		}
		else if(!DescrT.tiposCompatibles(super.tipoDeProcPadre, this.e.getTipoDescrT())){
			//System.out.println(super.tipoDeProcPadre);
			//System.out.println( this.e.getTipoDescrT());
			GestionErroresSemanticos.error(this.getRow(),"El tipo retornado debe ser igual que el declarado en la cabecera");
		}
	}

	@Override
	public void etiquetas() {
		this.setReturn(true);
		this.comienzo = Prog.cinst;
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.e.numeroInstruccionesAccesoValor();
		this.siguiente = Prog.cinst;
	}
	

	@Override
	public void codigo() {
		this.e.codigo();
		this.e.generaInstruccionesAccesoValor();
	}
	
}

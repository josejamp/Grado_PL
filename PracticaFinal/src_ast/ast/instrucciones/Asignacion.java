package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;
import ast.designadores.Designador;
import ast.expresiones.E;
import ast.expresiones.TipoE;

public class Asignacion extends Inst{

	private Designador des;
	private E e;
	
	public Asignacion(Designador des, E e, int row){
		super(row);
		this.des = des;
		this.e = e;
	}
	
	public Designador des(){
		return this.des;
	}
	
	public E e(){
		return this.e;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.ASIGNACION;
	}
	
	public String toString() {
		return "Asignacion( " + des().toString() + ", " + e().toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
		this.e.vincula();
	}

	@Override
	public void chequea() {
		this.e.chequea();
		this.des.chequea();
		if(!this.tiposCompatibles(this.des.getTipoDescrT(), this.e.getTipoDescrT())) GestionErroresSemanticos.error(this.getRow(),"Los tipos no son compatibles");
	}

	private boolean tiposCompatibles(DescrT d1, DescrT d2) {
		return  DescrT.tiposCompatibles(d1, d2);
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.des.etiquetas();
		this.e.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesFinAsig();
		this.siguiente = Prog.cinst;
	}

	private int numeroInstruccionesFinAsig() {
		//mueve o desapila_ind
		return 1;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.e.codigo();
		this.generaInstruccionesFinAsig();
	}

	private void generaInstruccionesFinAsig() {
		if(this.e.tipo().equals(TipoE.DESIGNADOR) ||this.e.tipo().equals(TipoE.ID)){
			int tam = this.e.getTam();
			AlmacenCodigoP.addInst("mueve("+tam+")");
		}
		else{
			AlmacenCodigoP.addInst("desapila_ind");
		}
	}
	
}

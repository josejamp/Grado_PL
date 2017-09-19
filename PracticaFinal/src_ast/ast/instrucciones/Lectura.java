package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.TipoDescrT;
import ast.designadores.Designador;

public class Lectura extends Inst{

	private Designador des;
	
	public Lectura(Designador des, int row){
		super(row);
		this.des = des;
	}
	
	public Designador des(){
		return this.des;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.LECTURA;
	}
	
	public String toString() {
		return "Lectura( " + des().toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
	}

	@Override
	public void chequea() {
		this.des.chequea();
		if(!this.des.getTpoDes().equals(TipoDescrT.DECLARACION_INT) &&
		   !this.des.getTpoDes().equals(TipoDescrT.DECLARACION_REAL)){
			GestionErroresSemanticos.error(this.getRow(),"El designador debe ser entero o real");
		}
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.des.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesFinRead();
		this.siguiente = Prog.cinst;		
	}

	private int numeroInstruccionesFinRead() {
		// in
		// desapila_ind
		return 2;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.generaInstruccionesFinRead();
	}

	private void generaInstruccionesFinRead() {
		AlmacenCodigoP.addInst("in");
		AlmacenCodigoP.addInst("desapila_ind");
	}
	

	
}

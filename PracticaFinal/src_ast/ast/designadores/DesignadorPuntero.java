package ast.designadores;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;

public class DesignadorPuntero extends Designador{

	private Designador des;
	
	public DesignadorPuntero(Designador des, int row){
		super(row);
		this.des = des;
	}
	
	public Designador des(){
		return this.des;
	}
	
	@Override
	public TipoDesignador tipo() {
		return TipoDesignador.DESIGNADOR_PUNTERO;
	}
	
	public String toString() {
		return "DesignadorPuntero( " + des().toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
	}

	@Override
	public void chequea() {
		DescrT t = null;
		this.des.chequea();
		if (this.des.tipo_des == null) 
			t = null;
		else if (this.des.getTpoDes().equals(TipoDescrT.DECLARACION_PUNTERO))
			t = this.des.tipo_des.descrT();
		else GestionErroresSemanticos.error(this.getRow(),"El designador deberia ser un puntero");
		super.tipo_des = t;
	}

	@Override
	public void etiquetas() {
		this.des.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesDeReferencia();
		
	}

	private int numeroInstruccionesDeReferencia() {
		// apila_ind
		return 1;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.generaInstruccionesDeReferencia();
	}

	private void generaInstruccionesDeReferencia() {
		AlmacenCodigoP.addInst("apila_ind");
	}

	@Override
	public int getTam() {
		if(this.des.getTipoDescrT().descrT().getTam() == null) this.des.getTipoDescrT().descrT().calculaTam();
		//System.out.println("Tam " + this.des + ": " + this.des.getTipoDescrT().descrT().getTam());
		return this.des.getTipoDescrT().descrT().getTam();
	}

	@Override
	public int getTamTipoBasico() {
		return this.getTam();
	}
	
}

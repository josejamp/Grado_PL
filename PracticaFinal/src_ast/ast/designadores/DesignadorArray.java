package ast.designadores;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;
import ast.expresiones.E;

public class DesignadorArray extends Designador{

	private Designador des;
	private E exp;
	
	public DesignadorArray(Designador des, E exp, int row){
		super(row);
		this.des = des;
		this.exp = exp;
	}
	
	public Designador des(){
		return this.des;
	}
	
	public E exp(){
		return this.exp;
	}
	
	@Override
	public TipoDesignador tipo() {
		return TipoDesignador.DESIGNADOR_ARRAY;
	}

	public String toString() {
		return "DesignadorArray( " + des().toString() + ", " + exp.toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
		this.exp.vincula();
	}

	@Override
	public void chequea() {
		DescrT t = null;
		this.des.chequea();
		this.exp.chequea();
		
		if(this.des==null || this.exp==null){
			t = null;
		}
		else if(!this.des.getTpoDes().equals(TipoDescrT.DECLARACION_ARRAY)){
			GestionErroresSemanticos.error(this.getRow(),"El designador deber�a ser de tipo array");
			//t = null;
		}
		else if(!this.exp.getTpoDes().equals(TipoDescrT.DECLARACION_INT)){
			GestionErroresSemanticos.error(this.getRow(),"El indice debe ser de tipo entero");
			//t = null;
		}
		else if (this.des.getTpoDes().equals(TipoDescrT.DECLARACION_ARRAY)){
			t = this.des.tipo_des.descrT();
			
		}
		else t = null;
		super.tipo_des = t;
	}

	@Override
	public void etiquetas() {
		this.des.etiquetas();
		this.exp.etiquetas();
		Prog.cinst = Prog.cinst + this.exp.numeroInstruccionesAccesoValor();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesIndexacion();
	}

	private int numeroInstruccionesIndexacion() {
		// apila(Tam_tipo_basico)
		// mul
		// suma
		return 3;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.exp.codigo();
		this.exp.generaInstruccionesAccesoValor();
		this.generaInstruccionesIndexacion();
	}

	private void generaInstruccionesIndexacion() {
		int tam = this.getTam();
		AlmacenCodigoP.addInst("apila("+ tam +")");
		AlmacenCodigoP.addInst("mul");
		AlmacenCodigoP.addInst("suma");
	}

	@Override
	public int getTam() {
		if(this.des.getTipoDescrT().descrT().getTam() == null) this.des.getTipoDescrT().descrT().calculaTam();
		//System.out.println("Tam " + this.des + ": " + this.des.getTipoDescrT().descrT().getTam());
		return this.des.getTipoDescrT().descrT().getTam();
	}

	@Override
	public int getTamTipoBasico() {
		int tam;
		if(this.des.getTipoDescrT().descrT().getTam() == null) this.des.getTipoDescrT().descrT().calculaTam();
		//System.out.println("Tam " + this.des + ": " + this.des.getTipoDescrT().descrT().getTam());
		if(this.des.getTipoDescrT().descrT().tipo().equals(TipoDescrT.DECLARACION_PUNTERO)){
			if(this.des.getTipoDescrT().descrT().descrT().getTam() == null) this.des.getTipoDescrT().descrT().descrT().calculaTam();
			tam = this.des.getTipoDescrT().descrT().descrT().getTam();
		}
		else tam = this.des.getTipoDescrT().descrT().getTam();
		return tam;
	}
	
}

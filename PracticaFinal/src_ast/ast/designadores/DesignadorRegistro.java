package ast.designadores;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.Campo;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;

public class DesignadorRegistro extends Designador{

	private Designador des;
	private String campo;
	
	public DesignadorRegistro(Designador des, String campo, int row){
		super(row);
		this.des = des;
		this.campo = campo;
	}
	
	public Designador des(){
		return this.des;
	}
	
	public String campo(){
		return this.campo;
	}
	
	@Override
	public TipoDesignador tipo() {
		return TipoDesignador.DESIGNADOR_REGISTRO;
	}

	public String toString() {
		return "DesignadorRegistro( " + des().toString() + ", " + campo.toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
	}

	@Override
	public void chequea() {
		DescrT t=null;
		this.des.chequea();
		 if (this.des.tipo_des != null) {
			 if (this.des.getTpoDes().equals(TipoDescrT.DECLARACION_REGISTRO)) {
				 Campo m = this.des.tipo_des.obtenMiembro(this.campo);
				 if(m == null){
					 GestionErroresSemanticos.error(this.getRow(),"Miembro inexistente");
					// t=null;
				 }
				 else
					 t = m.descrT();
			 }
			 else {
				 GestionErroresSemanticos.error(this.getRow(),"El designador deber�a ser de tipo registro");
				// t=null;
			 }
		 }
		 else t=null;
		 super.tipo_des = t; 
	}

	@Override
	public void etiquetas() {
		this.des.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesAccesoCampo();
	}

	private int numeroInstruccionesAccesoCampo() {
		// apila(desp_campo)
		// suma
		return 2;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.generaInstuccionesAccesoCampo();
	}

	private void generaInstuccionesAccesoCampo() {
		Campo m = this.des.tipo_des.obtenMiembro(this.campo);
		int desp = m.getDesp();
		AlmacenCodigoP.addInst("apila("+desp+")");
		AlmacenCodigoP.addInst("suma");
	}

	@Override
	public int getTam() {
		Campo m = this.des.tipo_des.obtenMiembro(this.campo);
		int tam;
		if(m.descrT().tipo().equals(TipoDescrT.DECLARACION_PUNTERO)){
			if(m.descrT().descrT().getTam() == null) m.descrT().descrT().calculaTam();
			tam = m.descrT().descrT().getTam();
		}
		else {
			tam = m.getTam();
		}
		//System.out.println("Tam " + this.campo + ": " + tam);
		return tam;
	}

	@Override
	public int getTamTipoBasico() {
		return this.getTam();
	}

}

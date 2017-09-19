package ast.instrucciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.TipoDescrT;
import ast.designadores.Designador;

public class LiberarMemoria extends Inst{

	private Designador des;
	
	public LiberarMemoria(Designador des, int row){
		super(row);
		this.des = des;
	}
	
	public Designador des(){
		return this.des;
	}

	@Override
	public TipoInst tipo() {
		return TipoInst.LIBERAR_MEMORIA;
	}
	
	public String toString() {
		return "LiberarMemoria( " + des().toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
	}

	@Override
	public void chequea() {
		this.des.chequea();
		if(!this.des.getTpoDes().equals(TipoDescrT.DECLARACION_PUNTERO)){
			GestionErroresSemanticos.error(this.getRow(),"El designador debe ser un puntero");
		}
	}

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		this.des.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesFinLiberaMem();
		this.siguiente = Prog.cinst;
		
	}

	private int numeroInstruccionesFinLiberaMem() {
		// apila_ind
		// free
		return 2;
	}

	@Override
	public void codigo() {
		this.des.codigo();
		this.generaInstruccionesFinDelete();
	}

	private void generaInstruccionesFinDelete() {
		int tam = this.des.getTamTipoBasico();
		AlmacenCodigoP.addInst("apila_ind");
		AlmacenCodigoP.addInst("free("+tam+")");
	}
	

	
}

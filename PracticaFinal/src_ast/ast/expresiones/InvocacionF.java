package ast.expresiones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDec;
import ast.declaraciones.Vinculo;
import ast.declaraciones.VinculoProc;

public class InvocacionF extends InvF{

	private String id;
	private Exp exp;
	
	public InvocacionF(String id, Exp exp, int row){
		super(row);
		this.id = id;
		this.exp = exp;
	}
	
	public String id(){
		return this.id;
	}
	
	public Exp exp(){
		return this.exp;
	}

	@Override
	public TipoInvF tipo() {
		return TipoInvF.INVOCACION_F;
	}
	
	public String toString() {
		return "InvocacionF( " + id().toString() + ", " + exp().toString() + ")";
	}

	private VinculoProc vinculo;
	
	@Override
	public void vincula() {
		//System.out.println(TablaSimbolos.declaracionDe(this.id));
		//System.out.println(TablaSimbolos.declaracionDe(this.id).getTipo());
		this.vinculo = (VinculoProc)TablaSimbolos.declaracionDe(this.id);
		if(this.vinculo == null) GestionErroresSemanticos.error(this.getRow(),"identificador no declarado");
		this.exp.vincula();
	}

	@Override
	public void chequea() {
		DescrT t;
		if (!this.validoComoDesignador()) {
			GestionErroresSemanticos.error(this.getRow(),"El identificador debe ser una funcion");
			 //t=null;
		}
		else{
			 t = this.vinculo.getDescrT();
			super.tipo_des = t;
			if(this.exp.numParams() != this.vinculo.getParams().numParams()){
				//System.out.println("Exp: " + this.exp.numParams());
				//System.out.println("Par: " + this.vinculo.getParams().numParams());
				GestionErroresSemanticos.error(this.getRow(),"La funcion no tiene el numero de parametros correcto");
			}
			else{
				this.exp.chequea();
				this.exp.chequeaTipos(this.vinculo.getParams());
			}
		}
	}
	
	private boolean validoComoDesignador(){
		return this.vinculo.getTipo().equals(TipoDec.DEC_FUNCION_METODO);
	}
	

	@Override
	public void etiquetas() {
		this.comienzo = Prog.cinst;
		 Prog.cinst = Prog.cinst + this.numeroInstruccionesPasoObjeto();
		 this.exp.etiquetas();
		 Prog.cinst = Prog.cinst + this.numeroInstruccionesFinLlamada();
		 this.siguiente = Prog.cinst; 
	}

	private int numeroInstruccionesFinLlamada() {
		// apila_dir(0)
		// apila(1)
		// suma
		// apila(this.siguiente)
		// desapila_ind
		// ir_a(dir_prologo)
		return 6;
	}

	private int numeroInstruccionesPasoObjeto() {
		// No hay soporte de objetos
		return 0;
	}

	@Override
	public void codigo() {
		this.generaInstruccionesPasoObjeto();
		this.exp.codigo(this.vinculo.getParams());
		this.generaInstruccionesFinLlamada();
	}

	private void generaInstruccionesFinLlamada() {
		//System.out.println("FinLlamada: " + this.vinculo.getInfo());
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(1)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("apila("+this.siguiente+")");
		AlmacenCodigoP.addInst("desapila_ind");
		int dirPrologo = this.vinculo.getInfo().getDirPrologoFun();
		AlmacenCodigoP.addInst("ir_a("+dirPrologo+")");
	}

	private void generaInstruccionesPasoObjeto() {
		// TODO Auto-generated method stub
		
	}
	
}

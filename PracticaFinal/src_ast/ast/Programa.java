package ast;

import codigoP.AlmacenCodigoP;
import ast.declaraciones.DecFuncion;
import ast.declaraciones.Decs;
import ast.instrucciones.Insts;

public class Programa extends Prog{

	private Decs decs;
	private Insts insts;
	
	public Programa(Decs decs, Insts insts, int row){
		super(row);
		this.decs = decs;
		this.insts = insts;
	}
	
	public Decs decs(){
		return this.decs;
	}
	
	public Insts insts(){
		return this.insts;
	}
	
	@Override
	public TipoProg tipo() {
		return TipoProg.PROGRAMA;
	}
	
	public String toString() {
		return "Programa( " + decs().toString()+", "+ insts().toString()+ ")";
	}
	
	public void vincula(boolean inicial){
		if(inicial){
			TablaSimbolos.iniciaTS();
			TablaSimbolos.abreBloque();
		}
		this.decs.vincula();
		this.decs.vinculaRefs();
		this.insts.vincula();
	}

	@Override
	public void simplificaDeTipos() {
		this.decs.simplificaDeTipos();
	}

	@Override
	public void muestraVinculos() {
		this.decs.muestraVinculos();
	}

	@Override
	public void chequea() {
		this.decs.chequea();
		this.insts.setTipoDeProcPadre(this.getTipoDeProcPadre());
		this.insts.chequea();
	}

	@Override
	public void asignaEspacio(boolean funcion) {
		if(!funcion){
			super.anidamiento = this.decs.anidamiento();
			Prog.dir = super.anidamiento+1;
			//System.out.println("ANIDAMIENTO: " + this.decs.anidamiento());
			Prog.nivel = 0;
		}
		this.decs.asignaEspacio();
		super.tamDatos = Prog.dir-super.anidamiento;
		//System.out.println("TAM DATOS: " + super.tamDatos);
	}

	@Override
	public int anidamiento() {
		return this.decs.anidamiento();
	}

	@Override
	public void etiquetas(DecFuncion funcion) {
		if(funcion == null){
			Prog.cinst = 0;
			this.etiquetasCreacionClases();
			Prog.cinst += this.numeroInstruccionesActivacion();
			this.decs.etiquetas();
			this.insts.etiquetas();
		}
		else{
			this.decs.etiquetas();
			//funcion.setDir(Prog.cinst);
			funcion.setDirPrologo(Prog.cinst);
			//System.out.println("Prog.cinst: " + funcion.getDirPrologo());
			Prog.cinst = Prog.cinst + funcion.numeroInstrucccionesPrologo();
			this.insts.etiquetas();
			if(!this.insts.hayReturn()){
				Prog.cinst = Prog.cinst + funcion.numeroInstruccionesReturnAux();
			}
			Prog.cinst = Prog.cinst + funcion.numeroInstrucccionesEpilogo(); 
		}
	}

	private int numeroInstruccionesActivacion() {
		// apila(3)
		// desapila_dir(0)
		// ir_a(dir_primera_instruccion)
		return 3;
	}

	private void etiquetasCreacionClases() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codigo(DecFuncion funcion) {
		if(funcion == null){
			this.codigoCreacionClases();
			this.generaInstruccionesActivacion();
			this.decs.codigo();
			this.insts.codigo();
		}
		else{
			this.decs.codigo();
			this.dirPrologo = Prog.cinst;
			funcion.generaInstruccionesPrologo();
			this.insts.codigo();
			if(!this.insts.hayReturn()){
				//System.out.println("hayReturn: " + this.insts.hayReturn());
				funcion.generaInstruccionesReturnAux();
			}
			funcion.generaInstruccionesEpilogo();
		}
	}

	private void generaInstruccionesActivacion() {
		int dir_primera_inst = this.insts.dirPrimeraInstruccion();
		AlmacenCodigoP.addInst("apila(" + (super.anidamiento+super.tamDatos) + ")");
		AlmacenCodigoP.addInst("desapila_dir(0)");
		AlmacenCodigoP.addInst("ir_a("+dir_primera_inst+")");
	}

	private void codigoCreacionClases() {
		
	}

}

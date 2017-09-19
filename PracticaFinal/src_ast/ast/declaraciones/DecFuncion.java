package ast.declaraciones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;

public class DecFuncion extends DecF{
	
	private Cabecera cabecera;
	private Prog prog;
	private String id;
	
	public DecFuncion(Cabecera cabecera, Prog prog, String id, int row){
		super(row);
		this.cabecera = cabecera;
		this.prog = prog;
		this.id = id;
		this.info = new InfoGeneracionCodigo();
	}
	
	public Cabecera cabecera(){
		return this.cabecera;
	}
	
	public Prog prog(){
		return this.prog;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoDecF tipo() {
		return TipoDecF.DEC_FUNCION;
	}

	public String toString() {
		return "DecFuncion( " + cabecera().toString() + ", " + prog.toString() + ", " +id.toString() + ")";
	}
	
	private DescrT tipoDeFuncionAux;

	@Override
	public void vincula() {
		this.vinculaProc();
		TablaSimbolos.cierraBloque();
		if(this.cabecera.tipo().equals(TipoCabecera.CABECERA_SIMPLE)){
			if(!TablaSimbolos.insertaID(id, new VinculoProc( new DeclaracionInt(this.getRow()), TipoDec.DEC_FUNCION_METODO, this.info, false, this.cabecera.params()))) GestionErroresSemanticos.error(this.getRow(),"identificador duplicado");
			else this.tipoDeFuncionAux = new DeclaracionInt(this.getRow());
		}
		else{
			if(!TablaSimbolos.insertaID(id, new VinculoProc( this.cabecera.descrT(), TipoDec.DEC_FUNCION_METODO, this.info, false, this.cabecera.params()))) GestionErroresSemanticos.error(this.getRow(),"identificador duplicado");
			else this.tipoDeFuncionAux = this.cabecera.descrT();
		}
	}

	private void vinculaProc() {
		this.cabecera.vincula(this.id, this.info);
		this.prog.vincula(false);
	}

	@Override
	public void vinculaRefs() {
		this.cabecera.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.cabecera.simplificaTipos();
		this.prog.simplificaDeTipos();
		this.tipoDeFuncionAux = this.tipoDeFuncionAux.tipoSimplificado();
	}

	@Override
	public void chequea() {
		this.cabecera.chequea();
		if(this.cabecera.tipo().equals(TipoCabecera.CABECERA_COMP)){
			this.prog.setTipoDeProcPadre(this.cabecera.descrT());
		}
		else this.prog.setTipoDeProcPadre(new DeclaracionInt(this.getRow()));
		this.prog.chequea();
	}

	@Override
	public int numParams() {
		return this.cabecera.numParams();
	}

	@Override
	public void muestraVinculos() {
		System.out.println("Tipo de funcion " + this.id + ": " + this.tipoDeFuncionAux.toString());
		this.cabecera.muestraVinculos();
	}

	@Override
	public int anidamiento() {
		//System.out.println("ANIDAMIENTO DE FUNCION: " + this.prog.anidamiento());
		return (1 + this.prog.anidamiento());
	}
	
	
	private InfoGeneracionCodigo info;	

	@Override
	public void asignaEspacio() {
		int copiaDir = Prog.dir;
		int copiaNivel = Prog.nivel;
		Prog.nivel += 1; 
		this.info.setNivel(Prog.nivel);
		Prog.dir = 0;
		this.cabecera.asignaEspacio(this.info);
		this.prog.asignaEspacio(true);
		this.info.setNivel(Prog.nivel);
		this.info.setDir(Prog.dir);
		Prog.dir = copiaDir;
		Prog.nivel = copiaNivel;
	}

	@Override
	public void etiquetas() {
		this.prog.etiquetas(this);
	}
	public void setDir(int dir){
		this.info.setDir(dir);
	}
	
	public void setDirPrologo(int dir){
		this.info.setDirPrologoFun(dir);
	}
	
	public int getDirPrologo(){
		return this.info.getDirPrologoFun();
	}

	public int numeroInstrucccionesPrologo() {
		//5 para guardar valor antiguo display
		//4 para fijar nuevo valor
		//4 par fijar CP
		return 13; 
	}

	public int numeroInstrucccionesEpilogo() {
		//4 restaurar valor del CP
		//5 restaurar valor antiguo display
		//5 volver (4 acceso dir + 1 volver)
		return 14;
	}

	@Override
	public void codigo() {
		this.prog.codigo(this);
	}

	public void generaInstruccionesPrologo() {
		/* Guardar valor antiguo display  */
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(2)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("apila_dir("+this.info.getNivel()+")");
		AlmacenCodigoP.addInst("desapila_ind");
		
		/* Nuevo valor display  */
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(3)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("desapila_dir(" + this.info.getNivel() + ")");
		
		/* Nuevo valor display  */
		AlmacenCodigoP.addInst("apila(" + (this.info.getDir() + 2) +")");
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("desapila_dir(0)");
	}

	public void generaInstruccionesEpilogo() {
		/* Restaurar valor CP  */
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila("+ (this.info.getDir() + 2)+ ")");
		AlmacenCodigoP.addInst("resta");
		AlmacenCodigoP.addInst("desapila_dir(0)");
		
		/* Restaurar valor display  */
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(2)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("apila_ind");
		AlmacenCodigoP.addInst("desapila_dir("+this.info.getNivel()+")");
		
		/* Retornar  */
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(1)");
		AlmacenCodigoP.addInst("suma");
		AlmacenCodigoP.addInst("apila_ind");
		AlmacenCodigoP.addInst("ir_ind");
	}

	public int numeroInstruccionesReturnAux() {
		// apila(0) | apila(-1)
		return 1;
	}

	public void generaInstruccionesReturnAux() {
		//System.out.println("Sin return, tipo: " + this.tipoDeFuncionAux.tipo());
		if(this.tipoDeFuncionAux.tipo().equals(TipoDescrT.DECLARACION_INT) || this.tipoDeFuncionAux.tipo().equals(TipoDescrT.DECLARACION_REAL)){
			AlmacenCodigoP.addInst("apila(0)");
		}
		else if(this.tipoDeFuncionAux.tipo().equals(TipoDescrT.DECLARACION_PUNTERO)){
			AlmacenCodigoP.addInst("apila(-1)");
		}
	}
	
}

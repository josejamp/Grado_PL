package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;

public class DecVariable extends DecVar{

	private DescrT descrT;
	private String id;
	
	public DecVariable(DescrT descrT, String id, int row){
		super(row);
		this.descrT = descrT;
		this.id = id;
		this.info = new InfoGeneracionCodigo();
	}
	
	public DescrT descrT(){
		return this.descrT;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoDecVar tipo() {
		return TipoDecVar.DEC_VARIABLE;
	}
	
	public String toString() {
		return "DecVariable( " + descrT().toString() + ", " + id.toString() + ")";
	}

	@Override
	public void vincula() {
		this.descrT.vincula(); //pasamos al vinculo el nivel y la direccion de la variable nulas, luego tendran valor
		if(!TablaSimbolos.insertaID(this.id, new Vinculo(this.descrT, TipoDec.DEC_V, this.info, false))) GestionErroresSemanticos.error(this.getRow(),"identificador duplicado");
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.descrT = this.descrT.tipoSimplificado();
	}

	@Override
	public void muestraVincuos() {
		System.out.println("Declaracion de " + this.id + ": " + this.descrT.toString());
	}

	@Override
	public void chequea() {
		this.descrT.chequea();
	}
	
	
	private InfoGeneracionCodigo info;

	@Override
	public void asignaEspacio() {
		this.info.setNivel(Prog.nivel);
		this.info.setDir(Prog.dir);
		if(this.descrT.tipo().equals(TipoDescrT.DECLARACION_OBJETO) || this.descrT.tipo().equals(TipoDescrT.DECLARACION_OBJETO_SIMPLE)){
			
		}
		else{
			//System.out.println("Antes " + this.id + ": " + Prog.dir);
			this.descrT.asignaEspacio();
			Prog.dir += this.descrT.getTam();
			//System.out.println("Prog.dir despues " + this.id + ": " + Prog.dir);
		}
		this.info.setTam(this.getTam());
	}
	
	public int getTam(){
		return this.descrT.getTam();
	}
	
}

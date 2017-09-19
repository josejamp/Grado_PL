package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;

public class Parametro extends Par{

	private DescrT descrT;
	private String id;
	
	public Parametro(DescrT descrT, String id, int row){
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
	public TipoPar tipo() {
		return TipoPar.PARAMETRO;
	}
	
	public String toString() {
		return "Parametro( " + descrT().toString() + ", " + id.toString() + ")";
	}

	@Override
	public void vincula() {
		this.descrT.vincula();
		if(!TablaSimbolos.insertaID(this.id, new Vinculo(this.descrT, TipoDec.DEC_V, this.info, false))) GestionErroresSemanticos.error(this.getRow(),"identificador duplicado");
	}

	@Override
	public void vinculaRefs() {
		this.descrT.vinculaRefs();
	}

	@Override
	public void simplificaTipos() {
		this.descrT = this.descrT.tipoSimplificado();
	}

	@Override
	public void chequea() {
		this.descrT.chequea();
	}


	
	@Override
	public void asignaEspacio() {
		this.info.setNivel(Prog.nivel);
		this.info.setDir(Prog.dir);
		this.descrT.asignaEspacio();
		Prog.dir = Prog.dir + this.descrT.tam;
		this.info.setTam(this.descrT.tam);
		//System.out.println("Parametro " + this.id() + ": " + this.info.getDir());
	}
	
}

package ast.declaraciones;

import ast.Prog;

public class Declaraciones extends Decs{

	private Decs decs;
	private Dec dec;
	
	public Declaraciones(Decs decs, Dec dec, int row){
		super(row);
		this.decs = decs;
		this.dec = dec;
	}
	
	public Decs decs(){
		return this.decs;
	}
	
	public Dec dec(){
		return this.dec;
	}

	@Override
	public TipoDecs tipo() {
		return TipoDecs.DECLARACIONES;
	}
	
	public String toString() {
		return "Declaraciones( " + decs().toString() + ", " + dec.toString() + ")";
	}

	@Override
	public void vincula() {
		this.decs.vincula();
		this.dec.vincula();
	}

	@Override
	public void vinculaRefs() {
		this.decs.vinculaRefs();
		this.dec.vinculaRefs();
	}

	@Override
	public void simplificaDeTipos() {
		this.decs.simplificaDeTipos();
		this.dec.simplificaDeTipos();
	}

	@Override
	public void muestraVinculos() {
		this.decs.muestraVinculos();
		this.dec.muestraVinculos();
	}

	@Override
	public void chequea() {
		this.decs.chequea();
		this.dec.chequea();
	}

	@Override
	public int anidamiento() {
		int anidamiento;
		anidamiento = Math.max(this.dec.anidamiento(), this.decs.anidamiento());
		return anidamiento;
	}

	@Override
	public void asignaEspacio() {
		this.decs.asignaEspacio();
		//System.out.println(Prog.dir);
		this.dec.asignaEspacio();
	}

	@Override
	public void etiquetas() {
		this.decs.etiquetas();
		this.dec.etiquetas();
	}

	@Override
	public void codigo() {
		this.decs.codigo();
		this.dec.codigo();
	}
	
}

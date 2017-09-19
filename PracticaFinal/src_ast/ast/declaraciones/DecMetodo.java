package ast.declaraciones;

import ast.Prog;

public class DecMetodo extends DecM{

	private Cabecera cabecera;
	private Prog prog;
	private String id;
	
	public DecMetodo(Cabecera cabecera, Prog prog, String id, int row){
		super(row);
		this.cabecera = cabecera;
		this.prog = prog;
		this.id = id;
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
	public TipoDecM tipo() {
		return TipoDecM.DEC_METODO;
	}
	
	public String toString() {
		return "DecMetodo( " + cabecera().toString() + ", " + prog().toString() + ", " + id.toString() + ")";
	}
	
}

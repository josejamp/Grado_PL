package ast.expresiones;

import ast.designadores.Designador;

public class InvocacionM extends InvM{

	private Designador des;
	private String id;
	private Exp exp;
	
	public InvocacionM(Designador des, String id, Exp exp, int row){
		super(row);
		this.des = des;
		this.id = id;
		this.exp = exp;
	}
	
	public Designador des(){
		return this.des;
	}
	
	public String id(){
		return this.id;
	}
	
	public Exp exp(){
		return this.exp;
	}

	@Override
	public TipoInvM tipo() {
		return TipoInvM.INVOCACION_M;
	}
	
	public String toString() {
		return "InvocacionM( " + des().toString() + ", " + id().toString() + ", " + exp.toString() + ")";
	}
	
}

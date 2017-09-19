package ast.expresiones;

import ast.Prog;
import ast.designadores.Designador;

public class DesignadorE extends E{

	private Designador des;
	
	public DesignadorE(Designador des, int row){
		super(row);
		this.des = des;
	}
	
	public Designador des(){
		return this.des;
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.DESIGNADOR;
	}
	
	public String toString() {
		return "Designador( " + des().toString() + ")";
	}

	@Override
	public void vincula() {
		this.des.vincula();
	}

	@Override
	public void chequea() {
		this.des.chequea();
		super.tipo_des = this.des.getTipoDescrT();
	}

	@Override
	public void etiquetas() {
		this.des.etiquetas();
	}

	@Override
	public int getTam() {
		return this.des.getTam();
	}

	@Override
	public void codigo() {
		this.des.codigo();
	}

}

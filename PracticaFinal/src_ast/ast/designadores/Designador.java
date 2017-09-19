package ast.designadores;

import ast.declaraciones.Campo;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;
import ast.expresiones.E;


public abstract class Designador {
	
	private int row;
	public Designador(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	 public abstract TipoDesignador tipo();
	 
	 public Designador des() {throw new UnsupportedOperationException("designador");}
	 public E exp() {throw new UnsupportedOperationException("expresion");}
	 public String campo() {throw new UnsupportedOperationException("campo");}
	 public String lex() {throw new UnsupportedOperationException("lexema");}
	 
	 
	 public abstract void vincula();
	 
	 
	 protected DescrT tipo_des;
	 public TipoDescrT getTpoDes(){
		 return this.tipo_des.tipo();
	 }
	 public DescrT getTipoDescrT(){
		 return this.tipo_des;
	 }
	 public abstract void chequea();
	 
	 public abstract void etiquetas();

	public abstract void codigo();

	public abstract int getTam();
	public abstract int getTamTipoBasico();

	 
	 
}

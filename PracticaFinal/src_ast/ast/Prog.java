package ast;

import ast.declaraciones.DecFuncion;
import ast.declaraciones.Decs;
import ast.declaraciones.DescrT;
import ast.instrucciones.Insts;

public abstract class Prog {

	private int row;
	public Prog(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}


	public abstract TipoProg tipo();
	
	public Decs decs(){throw new UnsupportedOperationException("declaraciones");}
	public Insts insts(){throw new UnsupportedOperationException("instrucciones");}

	public abstract void vincula(boolean inicial);
	
	public abstract void simplificaDeTipos();
	public abstract void muestraVinculos();
	
	
	private DescrT tipoDeProcPadre;
	public DescrT getTipoDeProcPadre(){
		return this.tipoDeProcPadre;
	}
	public void setTipoDeProcPadre(DescrT tipoDeProcPadre){
		this.tipoDeProcPadre = tipoDeProcPadre;
	}
	public abstract void chequea();
	
	
	public static int dir;
	public static int nivel;
	public abstract void asignaEspacio(boolean funcion);
	public abstract int anidamiento();
	
	public static int cinst;
	public abstract void etiquetas(DecFuncion funcion);
	public abstract void codigo(DecFuncion funcion);
	
	protected int dirPrologo;
	public int getDirPrologo() {
		return dirPrologo;
	}
	public void setDirPrologo(int dirPrologo) {
		this.dirPrologo = dirPrologo;
	}
	
	protected int anidamiento;
	protected int tamDatos;
	
	
}

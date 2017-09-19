package ast.expresiones;

import codigoP.AlmacenCodigoP;
import ast.declaraciones.Params;
import ast.declaraciones.TipoPar;

public abstract class Exp {
	
	private int row;
	public Exp(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	

	public abstract TipoExp tipo();
	
	public Exp exp() {throw new UnsupportedOperationException("exp");}
	public E e() {throw new UnsupportedOperationException("e");}

	public abstract void vincula();
	
	public abstract int numParams();

	public abstract void chequea();
	public abstract void chequeaTipos(Params params);
	public abstract void etiquetas();
	protected int numeroInstruccionesCalculoDirParametro() {
		//apila_dir(0)
		//apila(3)
		//suma
		//apila(dir)
		//suma
		return 5;
	}
	protected int numeroInstruccionesPasoParametro() {
		// desapila_ind | mueve
		return 1;
	}

	public abstract void codigo(Params params);
	protected void generaInstruccionesCalculoDirParametro(Params params){
		AlmacenCodigoP.addInst("apila_dir(0)");
		AlmacenCodigoP.addInst("apila(3)");
		AlmacenCodigoP.addInst("suma");
		int dir = params.par().getInfo().getDir();
		AlmacenCodigoP.addInst("apila("+dir+")");
		AlmacenCodigoP.addInst("suma");
	}
	protected void generaInstrucionesPasoParametro(Params params){
		if(params.par().tipo().equals(TipoPar.PARAMETRO)){
			if(this.e().tipo().equals(TipoE.ID)){
				int tam = this.e().getTam();
				AlmacenCodigoP.addInst("mueve("+tam+")");
			}
			else if(this.e().tipo().equals(TipoE.DESIGNADOR)){
				int tam = this.e().getTam();
				AlmacenCodigoP.addInst("mueve("+tam+")");
			}
			else{
				AlmacenCodigoP.addInst("desapila_ind");
			}
		}
		else{
			AlmacenCodigoP.addInst("desapila_ind");
		}
	}
	
}

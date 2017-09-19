package ast.expresiones;

import codigoP.AlmacenCodigoP;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDescrT;
import ast.designadores.Designador;

public abstract class E {
	
	private int row;
	public E(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoE tipo();
	
	public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
	public E opnd2() {throw new UnsupportedOperationException("opnd2");}
	public String entero(){throw new UnsupportedOperationException("entero");}
	public String real(){throw new UnsupportedOperationException("real");}
	public String id(){throw new UnsupportedOperationException("id");}
	public Designador des(){throw new UnsupportedOperationException("designador");}
	public InvF fun(){throw new UnsupportedOperationException("funcion");}
	public InvM met(){throw new UnsupportedOperationException("metodo");}

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

	public int numeroInstruccionesAccesoValor() {
		if(this.tipo().equals(TipoE.DESIGNADOR) || this.tipo().equals(TipoE.ID)){
			return 1;
		}
		else return 0;
	}

	public abstract void codigo();

	public void generaInstruccionesAccesoValor() {
		//System.out.println(this.tipo());
		if(this.tipo().equals(TipoE.DESIGNADOR) || this.tipo().equals(TipoE.ID)){
			AlmacenCodigoP.addInst("apila_ind");
		}
	}

	public abstract int getTam();

}

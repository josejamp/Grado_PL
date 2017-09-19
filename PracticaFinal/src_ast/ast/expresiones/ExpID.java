package ast.expresiones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDec;
import ast.declaraciones.Vinculo;

public class ExpID extends E{

	private String id;
	
	public ExpID(String id, int row) {
		super(row);
		this.id = id;   
	}
	public String id() {return id;}
	
	@Override
	public TipoE tipo() {
		return TipoE.ENTERO;
	}
	
	public String toString() {
		return "ExpID( " + real().toString() + ")";
	}
	
	
	private Vinculo vinculo;

	@Override
	public void vincula() {
		this.vinculo = TablaSimbolos.declaracionDe(this.id);
		if(this.vinculo == null) GestionErroresSemanticos.error(this.getRow(),"identificador no declarado");
	}
	@Override
	public void chequea() {
		DescrT t=null;
		if (!this.validoComoDesignador()) {
			GestionErroresSemanticos.error(this.getRow(),"El identificador debe ser una variable");
			 //t=null;
		}
		 else
			 t = this.vinculo.getDescrT();
		super.tipo_des = t;
	}
	
	private boolean validoComoDesignador(){
		return this.vinculo.getTipo().equals(TipoDec.DEC_FUNCION_METODO);
	}
	
	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesId();
	}
	
	private int numeroInstruccionesId() {
		if(this.vinculo.getInfo().getNivel().equals( new Integer(0))){ //variable global
			//apila(dir)
			return 1;
		} else if(this.vinculo.getRef()){ //parametro por referencia
			// apila_dir(N)
			// apila(dir)
			// suma
			// apila-ind
			return 4;
		} else{ //variable local o parametro por valor
			// apila_dir(N)
			// apila(dir)
			// suma
			return 3;
		}
	}
	
	public int getTam(){
		return this.vinculo.getInfo().getTam();
	}
	@Override
	public void codigo() {
		Integer nivel = this.vinculo.getInfo().getNivel();
		Integer dir = this.vinculo.getInfo().getDir();
		if(nivel.equals(0)){ //variable global
			AlmacenCodigoP.addInst("apila("+dir+")");
		} else if(this.vinculo.getRef()){ //parametro por referencia
			AlmacenCodigoP.addInst("apila_dir("+nivel+")");
			AlmacenCodigoP.addInst("apila("+dir+")");
			AlmacenCodigoP.addInst("suma");
			AlmacenCodigoP.addInst("apila_ind");
		} else{ //variable local o parametro por valor
			AlmacenCodigoP.addInst("apila_dir("+nivel+")");
			AlmacenCodigoP.addInst("apila("+dir+")");
			AlmacenCodigoP.addInst("suma");
		}
	}
}

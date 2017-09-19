package ast.designadores;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.TablaSimbolos;
import ast.declaraciones.DescrT;
import ast.declaraciones.TipoDec;
import ast.declaraciones.TipoDescrT;
import ast.declaraciones.Vinculo;

public class DesignadorID extends Designador{

	private String lex;
	
	public DesignadorID(String lex, int row){
		super(row);
		this.lex = lex;
	}
	
	public String lex(){
		return this.lex;
	}
	
	@Override
	public TipoDesignador tipo() {
		return TipoDesignador.DESIGNADOR_ID;
	}
	
	public String toString() {
		return "DesignadorID( " + lex.toString() + ")";
	}

	private Vinculo vinculo;

	@Override
	public void vincula() {
		this.vinculo = TablaSimbolos.declaracionDe(this.lex);
		//System.out.println("En designador: " + this.vinculo.toString());
		if(this.vinculo == null) GestionErroresSemanticos.error(this.getRow(),"identificador no declarado");
	}

	@Override
	public void chequea() {
		DescrT t;
		if (!this.validoComoDesignador()) {
			GestionErroresSemanticos.error(this.getRow(),"El identificador debe ser una variable");
			 t=null;
		}
		 else
			 t = this.vinculo.getDescrT().tipoSimplificado();
		super.tipo_des = t;
	}
	
	private boolean validoComoDesignador(){
		return this.vinculo.getTipo().equals(TipoDec.DEC_V);
	}

	@Override
	public void etiquetas() {
		Prog.cinst = Prog.cinst + this.numeroInstruccionesAccesoId();
	}

	private int numeroInstruccionesAccesoId() {
		//System.out.println(this.lex);
		//System.out.println(this.vinculo.getDescrT());
		//System.out.println(this.vinculo.getTipo());
		//System.out.println(this.vinculo.getInfo().toString());
		if(this.vinculo.getInfo().getNivel().equals(0)){ //variable global
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

	@Override
	public int getTam() {
		int tam;
		//System.out.println("Tipo " + this.lex + ": " + this.getTpoDes());
		if(this.getTpoDes().equals(TipoDescrT.DECLARACION_PUNTERO)){
			tam = this.getTipoDescrT().descrT().getTam();
		}
		else tam = this.vinculo.getInfo().getTam();
		//System.out.println("Tam " + this.lex + ": " + tam);
		return tam;
	}

	@Override
	public void codigo() {
		Integer nivel = this.vinculo.getInfo().getNivel();
		Integer dir = this.vinculo.getInfo().getDir();
		if(nivel.equals(0)){ //variable global
			AlmacenCodigoP.addInst("apila("+ dir + ")");
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

	@Override
	public int getTamTipoBasico() {
		return this.getTam();
	}
	
}

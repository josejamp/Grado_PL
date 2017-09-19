package ast.expresiones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DeclaracionInt;
import ast.declaraciones.DeclaracionReal;
import ast.declaraciones.TipoDescrT;

public class Suma extends EBin{

	public Suma(E opnd1, E opnd2, int row) {
		super(opnd1, opnd2, row);
	}
	@Override
	public TipoE tipo() {
		return TipoE.SUMA;
	}
	
	public String toString() {
		return "Suma( " + opnd1().toString() + ", " + opnd2().toString() + ")";
	}
	
	public void chequea() {
		super.opnd1.chequea();
		super.opnd2.chequea();
		if(super.opnd1.getTpoDes() == null || super.opnd2.getTpoDes() == null){
			super.tipo_des = null;
		}
		else if((super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_INT)) && (super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_INT))){
			super.tipo_des = new DeclaracionInt(this.getRow());
		}
		else if(((super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_INT) || super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_REAL)) && super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_REAL))
				|| ((super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_INT) || super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_REAL)) && super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_REAL))){
			super.tipo_des = new DeclaracionReal(this.getRow());
		}
		else GestionErroresSemanticos.error(this.getRow(),"Tipos no compatibles");
	}
	
	public void etiquetas(){
		super.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesSuma();
	}
	private int numeroInstruccionesSuma() {
		return 1;
	}
	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void codigo(){
		super.codigo();
		this.generaInstruccionesSuma();
	}
	private void generaInstruccionesSuma() {
		AlmacenCodigoP.addInst("suma");
	}
	
}

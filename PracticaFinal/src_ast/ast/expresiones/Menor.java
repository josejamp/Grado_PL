package ast.expresiones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DeclaracionInt;
import ast.declaraciones.TipoDescrT;

public class Menor extends EBin{

	public Menor(E opnd1, E opnd2, int row) {
		super(opnd1, opnd2, row);
	}
	@Override
	public TipoE tipo() {
		return TipoE.MENOR;
	}
	
	public String toString() {
		return "Menor( " + opnd1().toString() + ", " + opnd2().toString() + ")";
	}
	
	@Override
	public void chequea() {
		super.opnd1.chequea();
		super.opnd2.chequea();
		if(super.opnd1.getTpoDes() == null || super.opnd2.getTpoDes() == null){
			super.tipo_des = null;
		}
		else if((super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_INT) || super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_REAL))
				&& (super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_INT) || super.opnd2.getTpoDes().equals(TipoDescrT.DECLARACION_REAL))){
			super.tipo_des = new DeclaracionInt(this.getRow());
		}
		else GestionErroresSemanticos.error(this.getRow(),"Tipos no compatibles");
	}
	
	public void etiquetas(){
		super.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesMenor();
	}
	private int numeroInstruccionesMenor() {
		return 1;
	}
	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void codigo(){
		super.codigo();
		this.generaInstruccionesMenor();
	}
	private void generaInstruccionesMenor() {
		AlmacenCodigoP.addInst("menor");
	}
	
}

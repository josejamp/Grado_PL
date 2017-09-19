package ast.expresiones;

import codigoP.AlmacenCodigoP;
import errors.GestionErroresSemanticos;
import ast.Prog;
import ast.declaraciones.DeclaracionInt;
import ast.declaraciones.DeclaracionReal;
import ast.declaraciones.TipoDescrT;

public class CastInt extends EUn{

	public CastInt(E opnd1, int row) {
		super(opnd1, row);
	}

	@Override
	public TipoE tipo() {
		return TipoE.CAST_INT;
	}

	public String toString() {
		return "CastInt( " + opnd1().toString() + ")";
	}
	
	@Override
	public void chequea() {
		super.opnd1.chequea();
		if(super.opnd1.getTpoDes() == null){
			super.tipo_des = null;
		}
		else if(super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_INT)){
			super.tipo_des = new DeclaracionInt(this.getRow());
		}
		else if(super.opnd1.getTpoDes().equals(TipoDescrT.DECLARACION_REAL)){
			super.tipo_des = new DeclaracionInt(this.getRow());
		}
		else GestionErroresSemanticos.error(this.getRow(),"Tipos no compatibles");
	}
	
	public void etiquetas(){
		super.etiquetas();
		Prog.cinst = Prog.cinst + this.numeroInstruccionesCastInt();
	}

	private int numeroInstruccionesCastInt() {
		return 1;
	}

	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void codigo(){
		super.codigo();
		this.generaInstruccionesCastInt();
	}
	private void generaInstruccionesCastInt() {
		AlmacenCodigoP.addInst("castInt");
	}
	
}

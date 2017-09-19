package ast.declaraciones;

import errors.GestionErroresSemanticos;

public class DecFMMet extends DecFM{

	private DecM decM;
	
	public DecFMMet(DecM decM, int row){
		super(row);
		this.decM = decM;
	}
	
	public DecM decM(){
		return this.decM;
	}

	@Override
	public TipoDecFM tipo() {
		return TipoDecFM.DEC_FM_MET;
	}
	
	public String toString() {
		return "DecFMMet( " + decM().toString() + ")";
	}

	@Override
	public void vincula() {
		GestionErroresSemanticos.error(this.getRow(),"El lenguaje no admite orientacion a objetos");
	}

	@Override
	public void vinculaRefs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simplificaTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numParams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int anidamiento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void asignaEspacio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiquetas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codigo() {
		// TODO Auto-generated method stub
		
	}
	
}

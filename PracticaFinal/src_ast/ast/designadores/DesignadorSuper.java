package ast.designadores;

import errors.GestionErroresSemanticos;

public class DesignadorSuper extends Designador {

	public DesignadorSuper(int row) {
		super(row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoDesignador tipo() {
		return TipoDesignador.DESIGNADOR_SUPER;
	}
	
	public String toString() {
		return "DesignadorSuper( )";
	}

	@Override
	public void vincula() {
		GestionErroresSemanticos.error(this.getRow(),"El lenguaje no admite orientacion a objetos");
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiquetas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void codigo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTamTipoBasico() {
		// TODO Auto-generated method stub
		return 0;
	}

}

package ast.declaraciones;

import errors.GestionErroresSemanticos;
import ast.TablaSimbolos;

public class DescripcionTipo extends DescrT{

	private String id;
	
	public DescripcionTipo(String id, int row){
		super(row);
		this.id = id;
	}
	
	public String id(){
		return this.id;
	}

	@Override
	public TipoDescrT tipo() {
		return TipoDescrT.DESCRIPCION_TIPO;
	}
	
	public String toString() {
		return "DescripcionTipo( " + id.toString() + ")";
	}

	@Override
	public void vincula() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vinculaRefs() {
		super.vinculo = TablaSimbolos.declaracionDe(this.id);
		//System.out.println("Vinculo de " + this.id + " antes: " + super.vinculo.toString());
		if(super.vinculo == null) GestionErroresSemanticos.error(this.getRow(),"identificador no declarado");
	}

	@Override
	public void simplificaDeTipos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DescrT tipoSimplificado() {
		DescrT des = super.vinculo.getDescrT();
		while(des.tipo().equals(TipoDescrT.DESCRIPCION_TIPO)){
			des = des.vinculo.getDescrT();
		}
		return des;
	}

	@Override
	public void muestraVinculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Campo obtenMiembro(String campo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int anidamiento() {
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

	@Override
	public void calculaTam() {
		// TODO Auto-generated method stub
		
	}
	
}

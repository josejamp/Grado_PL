package ast.declaraciones;

public abstract class DescrT {

	private int row;
	public DescrT(int row){
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public abstract TipoDescrT tipo();
	
	public String id(){throw new UnsupportedOperationException("id");}
	public String num(){throw new UnsupportedOperationException("entero");}
	public DescrT descrT(){throw new UnsupportedOperationException("descripcion de tipo");}
	public Campos campos(){throw new UnsupportedOperationException("campo de registro");}
	public CampoObj campoObj(){throw new UnsupportedOperationException("campo de objeto");}

	
	
	
	protected Vinculo vinculo;
	public Vinculo getVinculo(){
		return this.vinculo;
	}
	
	public abstract void vincula();
	public abstract void vinculaRefs();

	public abstract void simplificaDeTipos();
	public abstract DescrT tipoSimplificado();
	public abstract void muestraVinculos();

	protected boolean visitado;
	public void setVisitado(boolean visitado){
		this.visitado = visitado;
	}
	public abstract void chequea();
	public abstract Campo obtenMiembro(String campo);
	public static boolean tiposCompatibles(DescrT des1, DescrT des2) {
		boolean res;
		DescrT d1 = null, d2 = null;
		//System.out.println("Des1: " + des1.toString());
		//System.out.println("Des2: " + des2.toString());
		if(des1 == null || des2 == null){
			return true;
		}
		else {
			if(!des1.visitado && !des2.visitado){
				if(des1.tipo().equals(TipoDescrT.DESCRIPCION_TIPO)){
					d1 = des1.vinculo.getDescrT().tipoSimplificado();
					d1.visitado = des1.visitado;
				}
				else d1 = des1;
				if(des2.tipo().equals(TipoDescrT.DESCRIPCION_TIPO)){
					d2 = des2.vinculo.getDescrT().tipoSimplificado();
					d2.visitado = des2.visitado;
				}
				else d2 = des2;
				//System.out.println("D1: " + d1.toString());
				//System.out.println("D2: " + d1.toString());
				//System.out.println("D1 tipo: " + d1.tipo());
				//System.out.println("D2 tipo: " + d2.tipo());
				if((d1.tipo().equals(TipoDescrT.DECLARACION_INT) && d2.tipo().equals(TipoDescrT.DECLARACION_INT))){
					res = true;
				}
				else if((d1.tipo().equals(TipoDescrT.DECLARACION_REAL) && (d2.tipo().equals(TipoDescrT.DECLARACION_REAL) || d2.tipo().equals(TipoDescrT.DECLARACION_INT)))){
					res = true;
				}
				else if((d1.tipo().equals(TipoDescrT.DECLARACION_ARRAY) && d2.tipo().equals(TipoDescrT.DECLARACION_ARRAY))){
				   d1.setVisitado(true);
				   d2.setVisitado(true);
				  // System.out.println("Num1: " + d1.num());
				  // System.out.println("Num2: " + d2.num());
				   res = d1.num().equals(d2.num()) && DescrT.tiposCompatibles(d1.descrT(), d2.descrT());
				   d1.setVisitado(false);
				   d2.setVisitado(false);
				}
				else if(d1.tipo().equals(TipoDescrT.DECLARACION_PUNTERO) && d2.tipo().equals(TipoDescrT.DECLARACION_PUNTERO) ){
				   d1.setVisitado(true);
				   d2.setVisitado(true);
				   if(d1 == null || d2 == null) return true; //El puntero apunta a null
				   else res = DescrT.tiposCompatibles(d1.descrT(), d2.descrT());
				   d1.setVisitado(false);
				   d2.setVisitado(false);
				}
				else if(d1.tipo().equals(TipoDescrT.DECLARACION_REGISTRO) && d2.tipo().equals(TipoDescrT.DECLARACION_REGISTRO) ){
					d1.setVisitado(true);
				   d2.setVisitado(true);
				   res = d1.campos().numCampos() == d2.campos().numCampos() && d1.campos().compatible(d2.campos());
				   d1.setVisitado(false);
				   d2.setVisitado(false);		
				}
				else res = false;
				}
			else {
				res = true;
			}
		}
		return res;
	}

	
	protected Integer tam;
	public Integer getTam(){
		return this.tam;
	}
	public abstract int anidamiento();
	public abstract void asignaEspacio();
	public abstract void calculaTam();
	public abstract void etiquetas();

	public abstract void codigo();
	
	
}

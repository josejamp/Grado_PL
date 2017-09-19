package ast.declaraciones;

public class Vinculo {
	
	private DescrT descrT;
	private TipoDec tipo;
	
	public Vinculo(DescrT descripcionTipo, TipoDec decT) {
		this.descrT = descripcionTipo;
		this.tipo = decT;
	}
	
	public DescrT getDescrT() {
		return descrT;
	}
	public void setDescrT(DescrT descrT) {
		this.descrT = descrT;
	}
	public TipoDec getTipo() {
		return tipo;
	}
	public void setTipo(TipoDec tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return this.descrT.toString();
	}
	
	
	/*
	 * Informacion para la generacion de codigo
	 */
	private InfoGeneracionCodigo info;
	private Boolean ref;
	
	public Vinculo(DescrT descripcionTipo, TipoDec decT, InfoGeneracionCodigo info, Boolean ref) {
		this.descrT = descripcionTipo;
		this.tipo = decT;
		this.info = info;
		this.ref = ref;
	}

	public Boolean getRef() {
		return ref;
	}

	public void setRef(Boolean ref) {
		this.ref = ref;
	}

	public InfoGeneracionCodigo getInfo() {
		return info;
	}

	public void setInfo(InfoGeneracionCodigo info) {
		this.info = info;
	}
	
	

}

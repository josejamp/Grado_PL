package ast.declaraciones;

public class VinculoProc extends Vinculo{

	private Params params;
	
	public VinculoProc(DescrT descripcionTipo, TipoDec decT) {
		super(descripcionTipo, decT);
	}
	
	public VinculoProc(DescrT descripcionTipo, TipoDec decT, InfoGeneracionCodigo info, Boolean ref, Params params) {
		super(descripcionTipo, decT, info, ref);
		this.params = params;
	}
	
	public  Params getParams(){
		return this.params;
	}

}

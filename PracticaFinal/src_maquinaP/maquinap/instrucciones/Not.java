package maquinap.instrucciones;

public class Not extends InstruccionLogicaUnaria{

	@Override
	public int opera(int v1) {
		if(v1 != 0)
			return 0;
		else return 1;
	}

}

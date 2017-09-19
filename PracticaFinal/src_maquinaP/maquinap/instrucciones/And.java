package maquinap.instrucciones;

public class And extends InstruccionLogicaBinaria{

	@Override
	public int opera(int v1, int v2) {
		if(v1 == 1 && v2 == 1)
			return 1;
		else return 0;
	}

}

package maquinap.instrucciones;

public class Menos extends InstruccionAritmeticaUnaria{

	@Override
	public int opera(int v1) {
		return -v1;
	}

	@Override
	public double opera(double v1) {
		return -v1;
	}

}

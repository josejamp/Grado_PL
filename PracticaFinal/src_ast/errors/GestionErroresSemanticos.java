package errors;

public class GestionErroresSemanticos {

	public static void error(int fila, String mensaje) {
	     System.out.println("ERROR fila "+fila+": " + mensaje); 
	     System.exit(1);
	   }  
	
}

package codigoP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribeEnFichero {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	
	public static void escribe(ArrayList<String> almacen){
		try {
 
			File file = new File("codigoP.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			String content = "";
			for(String inst: almacen){
				content += inst + EscribeEnFichero.LINE_SEPARATOR;
			}
			
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

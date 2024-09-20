package ArchivosTxt;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {

	public static void main(String[] args) {
		
		
		try(FileWriter fw = new FileWriter("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt")){
			
				fw.write("Hola Mundo! \n");
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}	

	}

}

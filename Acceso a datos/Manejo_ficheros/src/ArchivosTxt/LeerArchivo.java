package ArchivosTxt;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt")){
			
				int charLeido;
				while((charLeido = fr.read())	!= -1) {
					System.out.print((char) charLeido);
				}
				
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}

		}
	
}

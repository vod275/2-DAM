package ArchivosUTF;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class crearUTF {

	public static void main(String[] args)  throws IOException {
		
		 File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenasUTF.dat"); 
		 RandomAccessFile file = new RandomAccessFile(fichero, "rw"); 
		 String apellido[] = { "FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY" }; 
		 int dep[] = { 10, 20, 10, 10, 30, 30, 20 }; 
		 Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 }; 
		 
		 
		 int n = apellido.length; 
		 int posicion = 0; 
		 for (int i = 0; i < n; i++) { 
			 file.seek(posicion); 
			 file.writeInt(i + 1); 
			 file.writeUTF(apellido[i]); 
			 file.writeInt(dep[i]); 
			 file.writeDouble(salario[i]); 
			 posicion = posicion + 36; 
		 } 
		 file.close(); 
	}
		

}



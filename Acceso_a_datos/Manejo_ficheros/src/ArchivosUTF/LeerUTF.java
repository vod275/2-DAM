package ArchivosUTF;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerUTF {

	public static void main(String[] args) throws IOException {
		
		File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenasUTF.dat"); 
		RandomAccessFile file = new RandomAccessFile(fichero, "r"); 
		int id, dep, posicion = 0; 
		Double salario; 
		
		for (;;) {  
			file.seek(posicion); 
			id = file.readInt(); 
			String apellidoS = file.readUTF(); 	
		
			dep = file.readInt(); 
			salario = file.readDouble(); 
		
			System.out.println( "ID: " + id + ", Apellido: " + apellidoS  
					+ ", Departamento: " + dep + ", Salario: " + salario); 
		
			System.out.println("Posicion=" + posicion + ", filepointer= "  
					+ file.getFilePointer() + ",  file leng: "+ file.length()); 
			posicion = posicion + 36; 
		
			if (posicion >= file.length()) 
			break; 
		} 
		
		file.close(); 

	}
}



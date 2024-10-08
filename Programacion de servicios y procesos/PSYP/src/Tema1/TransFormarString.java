package Tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TransFormarString {

	public static void main(String[] args) throws IOException {
	
			
			try (InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(ipsr);
						
				FileWriter fw2 = new FileWriter(new File("C:\\Users\\batne\\eclipse-workspace\\UT1_EjemplosClase\\UT1-pruebas\\src\\pruebas\\ExportToFile.txt"));
				FileWriter fw3 = new FileWriter(new File(".\\src\\pruebas\\ExportToFile2.txt"));
				
				BufferedWriter bw = new BufferedWriter(fw2)) {
					
				String line = "";
				do {
					line = br.readLine();
					bw.write(line);
					bw.newLine();
		           
				} while (!line.isBlank());
			}catch (Exception ex)
	        {
	            ex.printStackTrace();
	            System.out.println(ex.getMessage());
	        }
		}
	

}

package Tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TransFormarString {

	public static void main(String[] args) throws IOException {
		
	

			InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(ipsr);	
			
			String line = "";
			do {
				line = br.readLine();
				System.out.println(line.toUpperCase());					
			} while (!line.isBlank());

		} 

	

}

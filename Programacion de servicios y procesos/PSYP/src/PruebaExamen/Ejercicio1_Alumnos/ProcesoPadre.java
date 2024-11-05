package PruebaExamen.Ejercicio1_Alumnos;

import java.io.*;
import java.nio.charset.Charset;

public class ProcesoPadre {

	private final static String ENTER = "\n";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//String[] ficherosEntrada = new String[args.length];
		String resp = "";
	    String claseProcesa="Ejercicio1_Alumnos.LecturaAlumnos";
        File path = new File(".\\bin\\");
        int numVeces = 0,contF = 0;
        
        //controlamos que se haya introducido como argumento algun nombre de archivo
        if (args.length <= 0) {
        	System.out.println("No se ha introducido ningún argumento");
        } else {
        	for (int i = 0; i<args.length;i++) {
        		//de cada archivo de datos sacamos su nombre sin extensión
        		//para crear el archivo de salida y de error a partir de él
            	String ficheroEntrada = args[i];
            	int pos = ficheroEntrada.indexOf(".");
            	String nombreFichero = ficheroEntrada.substring(0, pos);
            	contF++;
            	String fichSalida = nombreFichero + contF+"S.txt";
            	String fichError = nombreFichero + contF+"E.txt";
            	
            	FileWriter fwS = new FileWriter(new File(fichSalida));
	        	BufferedWriter bwS = new BufferedWriter(fwS);
	        	PrintWriter pw = new PrintWriter(fwS);

	        	FileReader fileReader = new FileReader(ficheroEntrada);
	        	BufferedReader br = new BufferedReader(fileReader);

	        	ProcessBuilder pb1 = new ProcessBuilder("java",claseProcesa).directory(path);
    	        pb1.redirectError(new File(fichError));
    	        Process p1 = pb1.start();
    	       
    	        InputStream is = p1.getInputStream();
    	        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
    	        BufferedReader brp = new BufferedReader(isr);

    	        OutputStream os = p1.getOutputStream();
	        	String lineaLeida = br.readLine();
	        	resp = brp.readLine();
	            while (lineaLeida != null) {
	            	System.out.println("linea leida: "+lineaLeida);
	            	os.write((lineaLeida + ENTER).getBytes());
	            	os.flush();
	            	
	            	resp = brp.readLine();
	            	System.out.println("respuesta: "+resp);
	            	if (resp.equals("fin")) {
	            		break;
	            	} else {
	            		bwS.write(resp);
		            	bwS.newLine();
	            	}
	                lineaLeida = br.readLine();
	            }
	            
	            resp = brp.readLine();
	            numVeces++;
	            
	            pw.println(resp);
	            pw.flush();
	       
	            pw.close();
	            br.close();
    	         
            } 
        }
        if (numVeces > 1)
        	System.out.println(numVeces + " veces se ha ejecutado el programa LecturaAlumnos.");
        else if (numVeces == 1)
        	System.out.println(numVeces + " vez se ha ejecutado el programa LecturaAlumnos.");
	}
}

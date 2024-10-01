package Tema1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;



public class ProcessSegundaOutputPrueba {
	
	private static final String DELIMITER = "\n";
	private static final String PWS = "powershell";
	private static final String COMMAND_HELP = "help";
	private static final String COMMAND_TREE = "tree";
	private static final String COMMAND_DIR = "dir";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Process proc1 = new ProcessBuilder(PWS, COMMAND_HELP).redirectErrorStream(true).start();
		Process proc2 = new ProcessBuilder(PWS, COMMAND_TREE).redirectErrorStream(true).start();
		//Thread.sleep(6000);
		InputStream inputStream1 = proc1.getInputStream();
		InputStream inputStream2 = proc2.getInputStream();
	
			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1, "UTF-8"));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));

			var lines1 = br1.lines();
			var lines2 = br2.lines();
			//Thread.sleep(6000);
			String s1 = lines1.collect(Collectors.joining(DELIMITER));
			String s2 = lines2.collect(Collectors.joining(DELIMITER));
			
			Process proc3 = new ProcessBuilder(PWS, COMMAND_DIR).redirectErrorStream(true).start();
			InputStream inputStream3 = proc3.getInputStream();
			BufferedReader br3 = new BufferedReader(new InputStreamReader(inputStream3, "UTF-8"));
			var lines3 = br3.lines();
			String s3 = lines3.collect(Collectors.joining(DELIMITER));
			proc3.onExit().defaultExecutor().execute(()->System.out.println(s3));
			
			proc1.onExit().defaultExecutor().execute(()->System.out.println(s1));
			proc2.onExit().defaultExecutor().execute(()->System.out.println(s2));
			
			Thread.sleep(3000);
			proc1.destroy();
			proc2.destroy();
			proc3.destroy();
			
	}

}
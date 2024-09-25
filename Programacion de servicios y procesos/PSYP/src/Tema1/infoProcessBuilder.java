package Tema1;

import java.io.IOException;
import java.io.File;
public class infoProcessBuilder {
	private static final String EDGE = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	private static final String CMD = "cmd";
	private static final String PWS = "powershell";
	private static final String COMMAND_HELP = "help";
	private static final String COMMAND_NETS = "netstat";
	private static final String COMMAND_TREE = "tree";
	private static final String COMMAND_DIR = "dir";
			
	public static void main(String[] args) throws IOException, InterruptedException {

		//process3 redirige su datos de error a la salida estandar
		Process process3 = new ProcessBuilder(EDGE).redirectErrorStream(true).start();
		Process process4 = new ProcessBuilder(PWS, " dam2").redirectErrorStream(true).start();
		
		process3.waitFor();
		Thread.sleep(3000);
		process3.destroy();
		Thread.sleep(1000);
		process4.destroy();
		process3.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pws 3"));
		process4.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pws 4"));
		
		
		//process5 redirige su datos de error al archivo errores.txt
		Process process5 = new ProcessBuilder(PWS, COMMAND_HELP).redirectError(new File("errores5.txt")).start();
		Process process6 = new ProcessBuilder(PWS, " dam2").redirectError(new File("errores6.txt")).start();
		System.out.println(process5.pid());
		Thread.sleep(3000);
		process5.destroy();
		Thread.sleep(1000);
		process6.destroy();
		process5.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pws 5"));
		process6.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pws 6"));
		
		Process process7 = new ProcessBuilder(EDGE).start();
		ProcessHandle processH8 = ProcessHandle.of(process7.pid()).get();
		Thread.sleep(4000);
		processH8.destroyForcibly();
		
		Thread.sleep(4000);
		process7.destroyForcibly();
		process7.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pws 7"));
		processH8.onExit().defaultExecutor().execute(()->System.out.println("Hemos matado el proceso pwsH 8"));
 }
}

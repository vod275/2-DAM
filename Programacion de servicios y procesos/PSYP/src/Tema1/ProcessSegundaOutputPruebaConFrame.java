package Tema1;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ProcessSegundaOutputPruebaConFrame {
	
	private static final String DELIMITER = "\n";
	private static final String PWS = "powershell";
	private static final String COMMAND_HELP = "help";
	private static final String COMMAND_TREE = "tree";
	
	public static void main(String[] args) throws IOException {
		
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		JTextArea areaTxt = new JTextArea();
		areaTxt.setBackground(Color.black);
		areaTxt.setForeground(Color.cyan);
		JScrollPane scrollPane = new JScrollPane(areaTxt);
		scrollPane.setSize(frame.getWidth(), frame.getHeight());
		areaTxt.setSize(scrollPane.getSize());
		areaTxt.setEditable(true);
		areaTxt.setFont(new Font("Arial",Font.BOLD,frame.getHeight() >> 5));
		frame.add(scrollPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//unity -> ver que es
		Process proc1 = new ProcessBuilder(PWS, COMMAND_HELP).redirectErrorStream(true).start();
		Process proc2 = new ProcessBuilder(PWS, COMMAND_TREE).redirectErrorStream(true).start();

		InputStream inputStream1 = proc1.getInputStream();
		InputStream inputStream2 = proc2.getInputStream();

			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1, "UTF-8"));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
			
			var lines1 = br1.lines();
			var lines2 = br2.lines();
			
			areaTxt.append(lines1.collect(Collectors.joining(DELIMITER)));
			
			String s2 = lines2.collect(Collectors.joining(DELIMITER));
			
			proc1.onExit().defaultExecutor().execute(()->frame.setVisible(true));
			proc2.onExit().defaultExecutor().execute(()->System.out.println(s2));
			
	}

}
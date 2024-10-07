package Ejemplo1;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Eje extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eje frame = new Eje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Eje() {
		setBounds(100, 100, 421, 356);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

package softwareJuicios.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import softwareJuicios.interfaz.paneles.AltaJuicioPanel;
import softwareJuicios.interfaz.paneles.AltaPersonaPanel;
import softwareJuicios.interfaz.paneles.AltaJuezPanel;

public class AltasWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasWindow window = new AltasWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltasWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		AltaJuezPanel panel = new AltaJuezPanel();
		frame.getContentPane().add(panel);
		
		AltaPersonaPanel altaPersonaPanel = new AltaPersonaPanel();
		frame.getContentPane().add(altaPersonaPanel);
	}

}

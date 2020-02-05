package softwareJuicios.interfaz;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import softwareJuicios.interfaz.paneles.alta.AltaJuezPanel;
import softwareJuicios.interfaz.paneles.alta.AltaPersonaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaPersonaPanel;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

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
				frame.getContentPane().setLayout(new BorderLayout(0, 0));
								
								JScrollPane scrollPane = new JScrollPane();
								frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
								
								JPanel panel_2 = new JPanel();
								scrollPane.setViewportView(panel_2);
								
										AltaJuezPanel panel = new AltaJuezPanel();
										panel_2.add(panel);
										
												ListaPersonaPanel panel_1 = new ListaPersonaPanel();
												panel_2.add(panel_1);
												
														AltaPersonaPanel altaPersonaPanel = new AltaPersonaPanel();
														panel_2.add(altaPersonaPanel);
	}

}

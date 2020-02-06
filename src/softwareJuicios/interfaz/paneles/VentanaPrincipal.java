package softwareJuicios.interfaz.paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDenuncias = new JMenu("Denuncias");
		menuBar.add(mnDenuncias);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnDenuncias.add(mntmNuevo);
		
		JMenuItem mntmVer = new JMenuItem("Listar");
		mnDenuncias.add(mntmVer);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnDenuncias.add(mntmEliminar);
		
		JMenu mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);
		
		JMenuItem menuItem = new JMenuItem("Nuevo");
		mnPersonas.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Listar");
		mnPersonas.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Eliminar");
		mnPersonas.add(menuItem_2);
		
		JMenu mnJuicios = new JMenu("Juicios");
		menuBar.add(mnJuicios);
		
		JMenuItem menuItem_3 = new JMenuItem("Nuevo");
		mnJuicios.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Listar");
		mnJuicios.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Eliminar");
		mnJuicios.add(menuItem_5);
		
		JMenu mnJueces = new JMenu("Jueces");
		menuBar.add(mnJueces);
		
		JMenuItem menuItem_6 = new JMenuItem("Nuevo");
		mnJueces.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Listar");
		mnJueces.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Eliminar");
		mnJueces.add(menuItem_8);
	}
}

package softwareJuicios.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import softwareJuicios.interfaz.paneles.alta.AltaDenunciaPanel;
import softwareJuicios.interfaz.paneles.alta.AltaJuicioPanel;
import softwareJuicios.interfaz.paneles.alta.AltaPersonaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuezPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuicioPanel;
import softwareJuicios.interfaz.paneles.listar.ListaPersonaPanel;

public class VentanaPrincipal {

	private JFrame frame;
	public static JDesktopPane desktopPane;
	public static JInternalFrame internalFrameListJuicios;
	public static JInternalFrame internalFrameListJueces;
	public static JInternalFrame internalFrameListPersonas;
	public static JInternalFrame internalFrameListDenuncias;
	public static JInternalFrame internalFrameAltaJuicios;
	public static JInternalFrame internalFrameAltaJueces;
	public static JInternalFrame internalFrameAltaPersonas;
	public static JInternalFrame internalFrameAltaDenuncias;

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

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(224, 255, 255));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnAbrir = new JMenu("Abrir");
		mnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenDenuncias();
			}
		});
		menuBar.add(mnAbrir);

		JMenuItem mntmVer = new JMenuItem("Denuncias");
		mntmVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenDenuncias();
			}
		});
		mnAbrir.add(mntmVer);

		JMenuItem mntmPersonas = new JMenuItem("Personas");
		mnAbrir.add(mntmPersonas);
		mntmPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenPersonas();
			}
		});

		JMenuItem mntmJuicios = new JMenuItem("Juicios");
		mnAbrir.add(mntmJuicios);
		mntmJuicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenJuicios();
			}
		});

		JMenuItem mntmJueces = new JMenuItem("Jueces");
		mnAbrir.add(mntmJueces);
		mntmJueces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenJueces();
			}
		});
	}

	public static void doAddDenuncias() {
		if (internalFrameAltaDenuncias == null) {
			internalFrameAltaDenuncias = new JInternalFrame("NUEVA DENUNCIA", true, false, false, false);
			internalFrameAltaDenuncias.getContentPane().add(new AltaDenunciaPanel(), BorderLayout.CENTER);
		}
		internalFrameAltaDenuncias.setBounds(0, 0, 500, 400);

		if (internalFrameAltaDenuncias.getParent() == null) {
			desktopPane.add(internalFrameAltaDenuncias);
		}

		internalFrameAltaDenuncias.setVisible(true);
		internalFrameAltaDenuncias.moveToFront();
	}

	public static void doAddPersonas() {
		if (internalFrameAltaPersonas == null) {
			internalFrameAltaPersonas = new JInternalFrame("NUEVA PERSONA", true, false, false, false);
			internalFrameAltaPersonas.getContentPane().add(new AltaPersonaPanel(), BorderLayout.CENTER);
		}
		internalFrameAltaPersonas.setBounds(0, 0, 500, 400);

		if (internalFrameAltaPersonas.getParent() == null) {
			desktopPane.add(internalFrameAltaPersonas);
		}

		internalFrameAltaPersonas.setVisible(true);
		internalFrameAltaPersonas.moveToFront();
	}

	public void doAddJuicios() {
		if (internalFrameAltaJuicios == null) {
			internalFrameAltaJuicios = new JInternalFrame("NUEVO JUICIO", true, false, false, false);
			internalFrameAltaJuicios.getContentPane().add(new AltaJuicioPanel(), BorderLayout.CENTER);
		}
		internalFrameAltaJuicios.setBounds(0, 0, 500, 400);

		if (internalFrameAltaJuicios.getParent() == null) {
			desktopPane.add(internalFrameAltaJuicios);
		}

		internalFrameAltaJueces.setVisible(true);
		internalFrameAltaJueces.moveToFront();
	}

	public static void doAddJueces() {
		if (internalFrameAltaJueces == null) {
			internalFrameAltaJueces = new JInternalFrame("NUEVO JUEZ", true, false, false, false);
			internalFrameAltaJueces.getContentPane().add(new ListaJuezPanel(), BorderLayout.CENTER);
		}
		internalFrameAltaJueces.setBounds(0, 0, 500, 400);

		if (internalFrameAltaJueces.getParent() == null) {
			desktopPane.add(internalFrameAltaJueces);
		}

		internalFrameAltaJueces.setVisible(true);
		internalFrameAltaJueces.moveToFront();
	}

	protected void doOpenPersonas() {
		if (internalFrameListPersonas == null) {
			internalFrameListPersonas = new JInternalFrame("PERSONAS", true, false, false, false);
			internalFrameListPersonas.getContentPane().add(new ListaPersonaPanel(), BorderLayout.CENTER);
		}
		internalFrameListPersonas.setBounds(0, 0, 500, 400);

		if (internalFrameListPersonas.getParent() == null) {
			desktopPane.add(internalFrameListPersonas);
		}

		internalFrameListPersonas.setVisible(true);
		internalFrameListPersonas.moveToFront();
	}

	protected void doOpenDenuncias() {
		if (internalFrameListDenuncias == null) {
			internalFrameListDenuncias = new JInternalFrame("DENUNCIAS", true, false, false, false);
			internalFrameListDenuncias.getContentPane().add(new ListaDenunciaPanel(), BorderLayout.CENTER);
		}
		internalFrameListDenuncias.setBounds(0, 0, 500, 400);

		if (internalFrameListDenuncias.getParent() == null) {
			desktopPane.add(internalFrameListDenuncias);
		}

		internalFrameListDenuncias.setVisible(true);
		internalFrameListDenuncias.moveToFront();
	}

	protected void doOpenJuicios() {
		if (internalFrameListJuicios == null) {
			internalFrameListJuicios = new JInternalFrame("JUICIOS", true, false, false, false);
			internalFrameListJuicios.getContentPane().add(new ListaJuicioPanel(), BorderLayout.CENTER);
		}
		internalFrameListJuicios.setBounds(0, 0, 500, 400);

		if (internalFrameListJuicios.getParent() == null) {
			desktopPane.add(internalFrameListJuicios);
		}

		internalFrameListJuicios.setVisible(true);
		internalFrameListJuicios.moveToFront();
	}

	protected void doOpenJueces() {
		if (internalFrameListJueces == null) {
			internalFrameListJueces = new JInternalFrame("JUECES", true, false, false, false);
			internalFrameListJueces.setBounds(0, 0, 500, 400);
			desktopPane.add(internalFrameListJueces);
			internalFrameListJueces.getContentPane().add(new ListaJuezPanel(), BorderLayout.CENTER);
			internalFrameListJueces.setVisible(true);
		}
		if (!(internalFrameListJueces.getParent() == null)) {
			desktopPane.add(internalFrameListJueces);
		}
		internalFrameListJueces.setVisible(true);
		internalFrameListJueces.moveToFront();
	}
}

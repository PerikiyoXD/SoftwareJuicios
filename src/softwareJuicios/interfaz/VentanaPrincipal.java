package softwareJuicios.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import softwareJuicios.entidades.Juez;
import softwareJuicios.interfaz.paneles.alta.AltaDenunciaPanel;
import softwareJuicios.interfaz.paneles.alta.AltaJuezPanel;
import softwareJuicios.interfaz.paneles.alta.AltaJuicioPanel;
import softwareJuicios.interfaz.paneles.alta.AltaPersonaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciasPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuecesPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuiciosPanel;
import softwareJuicios.interfaz.paneles.listar.ListaPersonasPanel;
import softwareJuicios.interfaz.paneles.modificar.ModificarDenunciaPanel;
import softwareJuicios.interfaz.paneles.modificar.ModificarJuezPanel;
import softwareJuicios.interfaz.paneles.modificar.ModificarJuicioPanel;
import softwareJuicios.interfaz.paneles.modificar.ModificarPersonaPanel;

public class VentanaPrincipal {

	public JFrame frame;
	public static JDesktopPane desktopPane;
	public static JInternalFrame intFrameListaJuicios;
	public static JInternalFrame intFrameListaJueces;
	public static JInternalFrame intFrameListaPersonas;
	public static JInternalFrame intFrameListaDenuncias;

	public static JInternalFrame intFrameAltaJuicio;
	public static JInternalFrame intFrameAltaJuez;
	public static JInternalFrame intFrameAltaPersona;
	public static JInternalFrame intFrameAltaDenuncia;

	public static JInternalFrame intFrameModifyJuicio;
	public static JInternalFrame intFrameModifyJuez;
	public static JInternalFrame intFrameModifyPersona;
	public static JInternalFrame intFrameModifyDenuncia;

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
				doListDenuncias();
			}
		});
		menuBar.add(mnAbrir);
		
				JMenuItem mntmPersonas = new JMenuItem("Personas");
				mnAbrir.add(mntmPersonas);
				mntmPersonas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doListPersonas();
					}
				});
		
				JMenuItem mntmJueces = new JMenuItem("Jueces");
				mnAbrir.add(mntmJueces);
				mntmJueces.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doListJueces();
					}
				});

		JMenuItem mntmJuicios = new JMenuItem("Juicios");
		mnAbrir.add(mntmJuicios);
		mntmJuicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doListJuicios();
			}
		});
		
				JMenuItem mntmVer = new JMenuItem("Denuncias");
				mntmVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doListDenuncias();
					}
				});
				mnAbrir.add(mntmVer);
	}

	public static void doInsertDenuncias() {
		if (intFrameAltaDenuncia == null) {
			intFrameAltaDenuncia = new JInternalFrame("NUEVA DENUNCIA", true, true, false, false);
			intFrameAltaDenuncia.getContentPane().add(new AltaDenunciaPanel(), BorderLayout.CENTER);
		}
		intFrameAltaDenuncia.setBounds(0, 0, 600, 450);

		if (intFrameAltaDenuncia.getParent() == null) {
			desktopPane.add(intFrameAltaDenuncia);
		}

		intFrameAltaDenuncia.setVisible(true);
		intFrameAltaDenuncia.moveToFront();
	}

	public static void doInsertJueces() {
		if (intFrameAltaJuez == null) {
			intFrameAltaJuez = new JInternalFrame("NUEVO JUEZ", true, true, false, false);
			intFrameAltaJuez.getContentPane().add(new AltaJuezPanel(), BorderLayout.CENTER);
		}
		intFrameAltaJuez.setBounds(0, 0, 600, 450);

		if (intFrameAltaJuez.getParent() == null) {
			desktopPane.add(intFrameAltaJuez);
		}

		intFrameAltaJuez.setVisible(true);
		intFrameAltaJuez.moveToFront();
	}

	public static void doInsertJuicios() {
		if (intFrameAltaJuicio == null) {
			intFrameAltaJuicio = new JInternalFrame("NUEVO JUICIO", true, true, false, false);
			intFrameAltaJuicio.getContentPane().add(new AltaJuicioPanel(), BorderLayout.CENTER);
		}
		intFrameAltaJuicio.setBounds(0, 0, 600, 450);

		if (intFrameAltaJuicio.getParent() == null) {
			desktopPane.add(intFrameAltaJuicio);
		}

		intFrameAltaJuicio.setVisible(true);
		intFrameAltaJuicio.moveToFront();
	}

	public static void doInsertPersonas() {
		if (intFrameAltaPersona == null) {
			intFrameAltaPersona = new JInternalFrame("NUEVA PERSONA", true, true, false, false);
			intFrameAltaPersona.getContentPane().add(new AltaPersonaPanel(), BorderLayout.CENTER);
		}
		intFrameAltaPersona.setBounds(0, 0, 600, 450);

		if (intFrameAltaPersona.getParent() == null) {
			desktopPane.add(intFrameAltaPersona);
		}

		intFrameAltaPersona.setVisible(true);
		intFrameAltaPersona.moveToFront();
	}

	protected void doListDenuncias() {
		if (intFrameListaDenuncias == null) {
			intFrameListaDenuncias = new JInternalFrame("DENUNCIAS", true, true, false, false);
			intFrameListaDenuncias.getContentPane().add(new ListaDenunciasPanel(), BorderLayout.CENTER);
		}
		intFrameListaDenuncias.setBounds(0, 0, 600, 450);

		if (intFrameListaDenuncias.getParent() == null) {
			desktopPane.add(intFrameListaDenuncias);
		}

		intFrameListaDenuncias.setVisible(true);
		intFrameListaDenuncias.moveToFront();
	}

	protected void doListJueces() {
		if (intFrameListaJueces == null) {
			intFrameListaJueces = new JInternalFrame("JUECES", true, true, false, false);
			intFrameListaJueces.getContentPane().add(new ListaJuecesPanel(), BorderLayout.CENTER);
		}
		intFrameListaJueces.setBounds(0, 0, 600, 450);

		if (intFrameListaJueces.getParent() == null) {
			desktopPane.add(intFrameListaJueces);
		}

		intFrameListaJueces.setVisible(true);
		intFrameListaJueces.moveToFront();
	}

	protected void doListJuicios() {
		if (intFrameListaJuicios == null) {
			intFrameListaJuicios = new JInternalFrame("JUICIOS", true, true, false, false);
			intFrameListaJuicios.getContentPane().add(new ListaJuiciosPanel(), BorderLayout.CENTER);
		}
		intFrameListaJuicios.setBounds(0, 0, 600, 450);

		if (intFrameListaJuicios.getParent() == null) {
			desktopPane.add(intFrameListaJuicios);
		}

		intFrameListaJuicios.setVisible(true);
		intFrameListaJuicios.moveToFront();
	}

	protected void doListPersonas() {
		if (intFrameListaPersonas == null) {
			intFrameListaPersonas = new JInternalFrame("PERSONAS", true, true, false, false);
			intFrameListaPersonas.getContentPane().add(new ListaPersonasPanel(), BorderLayout.CENTER);
		}
		intFrameListaPersonas.setBounds(0, 0, 600, 450);

		if (intFrameListaPersonas.getParent() == null) {
			desktopPane.add(intFrameListaPersonas);
		}

		intFrameListaPersonas.setVisible(true);
		intFrameListaPersonas.moveToFront();
	}

	public static void doModifyDenuncia() {
		if (intFrameModifyDenuncia == null) {
			intFrameModifyDenuncia = new JInternalFrame("MODIFICAR DENUNCIA", true, true, false, false);
			intFrameModifyDenuncia.getContentPane().add(new ModificarDenunciaPanel(), BorderLayout.CENTER);
		}
		intFrameModifyDenuncia.setBounds(0, 0, 600, 450);

		if (intFrameModifyDenuncia.getParent() == null) {
			desktopPane.add(intFrameModifyDenuncia);
		}

		intFrameModifyDenuncia.setVisible(true);
		intFrameModifyDenuncia.moveToFront();
	}

	public static void doModifyJuez(Juez juez) {
		if (intFrameModifyJuez == null) {
			intFrameModifyJuez = new JInternalFrame("MODIFICAR JUEZ", true, true, false, false);
			intFrameModifyJuez.getContentPane().add(new ModificarJuezPanel(juez), BorderLayout.CENTER);
		}
		intFrameModifyJuez.setBounds(0, 0, 600, 450);

		if (intFrameModifyJuez.getParent() == null) {
			desktopPane.add(intFrameModifyJuez);
		}

		intFrameModifyJuez.setVisible(true);
		intFrameModifyJuez.moveToFront();
	}

	public static void doModifyJuicio() {
		if (intFrameModifyJuicio == null) {
			intFrameModifyJuicio = new JInternalFrame("MODIFICAR JUICIO", true, true, false, false);
			intFrameModifyJuicio.getContentPane().add(new ModificarJuicioPanel(), BorderLayout.CENTER);
		}
		intFrameModifyJuicio.setBounds(0, 0, 600, 450);

		if (intFrameModifyJuicio.getParent() == null) {
			desktopPane.add(intFrameModifyJuicio);
		}

		intFrameModifyJuicio.setVisible(true);
		intFrameModifyJuicio.moveToFront();
	}

	public static void doModifyPersona() {
		if (intFrameModifyPersona == null) {
			intFrameModifyPersona = new JInternalFrame("MODIFICAR PERSONA", true, true, false, false);
			intFrameModifyPersona.getContentPane().add(new ModificarPersonaPanel(), BorderLayout.CENTER);
		}
		intFrameModifyPersona.setBounds(0, 0, 600, 450);

		if (intFrameModifyPersona.getParent() == null) {
			desktopPane.add(intFrameModifyPersona);
		}

		intFrameModifyPersona.setVisible(true);
		intFrameModifyPersona.moveToFront();
	}
}

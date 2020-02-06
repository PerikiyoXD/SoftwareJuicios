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
import softwareJuicios.interfaz.paneles.alta.AltaJuezPanel;
import softwareJuicios.interfaz.paneles.alta.AltaJuicioPanel;
import softwareJuicios.interfaz.paneles.alta.AltaPersonaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuezPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuicioPanel;
import softwareJuicios.interfaz.paneles.listar.ListaPersonaPanel;

public class VentanaPrincipal {

	private JFrame frame;
	private JInternalFrame internalFrameListJuicios;
	private JInternalFrame internalFrameListJueces;
	private JInternalFrame internalFrameListPersonas;
	private JInternalFrame internalFrameListDenuncias;
	private JDesktopPane desktopPane;
	private JInternalFrame internalFrameAltaJuicios;
	private JInternalFrame internalFrameAltaJueces;
	private JInternalFrame internalFrameAltaPersonas;
	private JInternalFrame internalFrameAltaDenuncias;

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

		JMenu mnDenuncias = new JMenu("Denuncias");
		mnDenuncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenDenuncias();
			}
		});
		menuBar.add(mnDenuncias);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAddDenuncias();
			}
		});
		
				JMenuItem mntmVer = new JMenuItem("Listar");
				mntmVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doOpenDenuncias();
					}
				});
				mnDenuncias.add(mntmVer);
		mnDenuncias.add(mntmNuevo);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRemoveDenuncias();
			}
		});
		mnDenuncias.add(mntmEliminar);

		JMenu mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);

		JMenuItem menuItem = new JMenuItem("Nuevo");
		mnPersonas.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("Listar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenPersonas();
			}
		});
		mnPersonas.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Eliminar");
		mnPersonas.add(menuItem_2);

		JMenu mnJuicios = new JMenu("Juicios");
		menuBar.add(mnJuicios);

		JMenuItem menuItem_3 = new JMenuItem("Nuevo");
		mnJuicios.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("Listar");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenJuicios();
			}
		});
		mnJuicios.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("Eliminar");
		mnJuicios.add(menuItem_5);

		JMenu mnJueces = new JMenu("Jueces");
		menuBar.add(mnJueces);

		JMenuItem menuItem_6 = new JMenuItem("Nuevo");
		mnJueces.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("Listar");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOpenJueces();
			}
		});
		mnJueces.add(menuItem_7);

		JMenuItem menuItem_8 = new JMenuItem("Eliminar");
		mnJueces.add(menuItem_8);
	}

	protected void doRemoveDenuncias() {

	}

	protected void doRemovePersonas() {

	}

	protected void doRemoveJuicios() {

	}

	protected void doRemoveJueces() {

	}

	protected void doAddDenuncias() {
		if (internalFrameAltaDenuncias == null) {
			internalFrameAltaDenuncias = new JInternalFrame("Nueva denuncia", true, true, true, true);
			internalFrameAltaDenuncias.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameAltaDenuncias);
			internalFrameAltaDenuncias.getContentPane().add(new AltaDenunciaPanel(), BorderLayout.CENTER);
			internalFrameAltaDenuncias.setVisible(true);
		} else {
			internalFrameAltaDenuncias.moveToFront();
			// ((AltaDenunciaPanel)
			// internalFrameAltaDenuncias.getContentPane().getComponent(0));
		}
	}

	protected void doAddPersonas() {
		if (internalFrameAltaPersonas == null) {
			internalFrameAltaPersonas = new JInternalFrame("Nueva persona", true, true, true, true);
			internalFrameAltaPersonas.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameAltaPersonas);
			internalFrameAltaPersonas.getContentPane().add(new AltaPersonaPanel(), BorderLayout.CENTER);
			internalFrameAltaPersonas.setVisible(true);
		} else {
			internalFrameAltaPersonas.moveToFront();
			// ((ListaPersonaPanel)
			// internalFrameAltaPersonas.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doAddJuicios() {
		if (internalFrameAltaJuicios == null) {
			internalFrameAltaJuicios = new JInternalFrame("Nuevo juicio", true, true, true, true);
			internalFrameAltaJuicios.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameAltaJuicios);
			internalFrameAltaJuicios.getContentPane().add(new AltaJuicioPanel(), BorderLayout.CENTER);
			internalFrameAltaJuicios.setVisible(true);
		} else {
			internalFrameAltaJuicios.moveToFront();
			// ((ListaPersonaPanel)
			// internalFrameAltaJuicios.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doAddJueces() {
		if (internalFrameAltaJueces == null) {
			internalFrameAltaJueces = new JInternalFrame("Nuevo juez", true, true, true, true);
			internalFrameAltaJueces.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameAltaJueces);
			internalFrameAltaJueces.getContentPane().add(new AltaJuezPanel(), BorderLayout.CENTER);
			internalFrameAltaJueces.setVisible(true);
		} else {
			internalFrameAltaJueces.moveToFront();
			// ((ListaPersonaPanel)
			// internalFrameAltaJueces.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doOpenPersonas() {
		if (internalFrameListPersonas == null) {
			internalFrameListPersonas = new JInternalFrame("Lista personas", true, true, true, true);
			internalFrameListPersonas.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameListPersonas);
			internalFrameListPersonas.getContentPane().add(new ListaPersonaPanel(), BorderLayout.CENTER);
			internalFrameListPersonas.setVisible(true);
		} else {
			internalFrameListPersonas.moveToFront();
			((ListaPersonaPanel) internalFrameListPersonas.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doOpenDenuncias() {
		if (internalFrameListDenuncias == null) {
			internalFrameListDenuncias = new JInternalFrame("Lista denuncias", true, true, true, true);
			internalFrameListDenuncias.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameListDenuncias);
			internalFrameListDenuncias.getContentPane().add(new ListaDenunciaPanel(), BorderLayout.CENTER);
			internalFrameListDenuncias.setVisible(true);
		} else {
			internalFrameListDenuncias.moveToFront();
			((ListaDenunciaPanel) internalFrameListDenuncias.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doOpenJuicios() {
		if (internalFrameListJuicios == null) {
			internalFrameListJuicios = new JInternalFrame("Lista juicios", true, true, true, true);
			internalFrameListJuicios.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameListJuicios);
			internalFrameListJuicios.getContentPane().add(new ListaJuicioPanel(), BorderLayout.CENTER);
			internalFrameListJuicios.setVisible(true);
		} else {
			internalFrameListJuicios.moveToFront();
			((ListaJuicioPanel) internalFrameListJuicios.getContentPane().getComponent(0)).populate();
		}
	}

	protected void doOpenJueces() {
		if (internalFrameListJueces == null) {
			internalFrameListJueces = new JInternalFrame("Lista jueces", true, true, true, true);
			internalFrameListJueces.setBounds(0, 0, 400, 350);
			desktopPane.add(internalFrameListJueces);
			internalFrameListJueces.getContentPane().add(new ListaJuezPanel(), BorderLayout.CENTER);
			internalFrameListJueces.setVisible(true);
		} else {
			internalFrameListJueces.moveToFront();
			((ListaJuezPanel) internalFrameListJueces.getContentPane().getComponent(0)).populate();
		}
	}
}

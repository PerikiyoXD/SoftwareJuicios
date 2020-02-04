package softwareJuicios.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.entidades.Persona;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 536060181222456289L;
	private JPanel contentPane;

	public Juez juez = new Juez("12345678A", "Juan", "Fernandez");
	public Persona persona = new Persona("12345678B", "Roberto", "Garcia");
	public Persona victima = new Persona("00000001C", "Marina", "Lopez");

	public Juicio juicio = new Juicio(1, 1, new Date(), null, "Don Benito", false, null);

	public Denuncia denuncia = new Denuncia(persona.getDni(), victima.getDni(), "Violación", 1,
			juicio.getFechaInicio());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		// TODO: Inicializar la BD luego! No depender de una BD llena

		/*
		 * ConectorNeodatis.abrirBaseDatos(); ConectorNeodatis.baseDatos.store(persona);
		 * ConectorNeodatis.baseDatos.store(victima);
		 * ConectorNeodatis.baseDatos.store(juez);
		 * ConectorNeodatis.baseDatos.store(juicio);
		 * ConectorNeodatis.baseDatos.store(denuncia);
		 * ConectorNeodatis.cerrarBaseDatos();
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

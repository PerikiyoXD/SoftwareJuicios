package softwareJuicios.interfaz.paneles.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.Configuracion;
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.interfaz.paneles.listar.ListaPersonasPanel;

public class AltaPersonaPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellido;

	public AltaPersonaPanel() {
		setBorder(new TitledBorder(null, "Alta de persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[33%][grow]", "[][][][grow][]"));

		JLabel lblNewLabel = new JLabel("DNI");
		add(lblNewLabel, "cell 0 0,alignx trailing");

		tfDNI = new JTextField();
		add(tfDNI, "cell 1 0,growx");
		tfDNI.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		add(lblNewLabel_1, "cell 0 1,alignx trailing");

		tfNombre = new JTextField();
		add(tfNombre, "cell 1 1,growx");
		tfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		add(lblNewLabel_2, "cell 0 2,alignx trailing");

		tfApellido = new JTextField();
		add(tfApellido, "cell 1 2,growx");
		tfApellido.setColumns(10);

		JButton btnLimpiar = new JButton("Limpiar");
		add(btnLimpiar, "flowx,cell 0 4 2 1,growx");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doInsert();
			}
		});
		add(btnNewButton, "cell 0 4,growx");

	}

	protected void doInsert() {
		String dni = tfDNI.getText();
		String nombre = tfNombre.getText();
		String apellido = tfApellido.getText();

		// Comprobar DNI Valido
		if (!dni.matches(Configuracion.REGEX_DNI)) {
			JOptionPane.showMessageDialog(this, "El DNI ofrecido no es v�lido.", "Error al insertar persona",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Comprobar DNI no existe
		{
			for (Persona persona : GestionPersona.personas) {
				if (dni.equals(persona.dni)) {
					JOptionPane.showMessageDialog(this, "El DNI ofrecido ya existe.", "Error al insertar persona",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}

		Persona persona = new Persona(dni, nombre, apellido);
		GestionPersona.alta(persona);
		((ListaPersonasPanel) VentanaPrincipal.intFrameListaPersonas.getContentPane().getComponent(0)).doUpdate();
	}

}

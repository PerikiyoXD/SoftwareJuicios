package softwareJuicios.interfaz.paneles.modificar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Juez;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.interfaz.paneles.listar.ListaJuecesPanel;

public class ModificarJuezPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private JTextField tfOldDNI;
	private JTextField tfOldNombre;
	private JTextField tfOldApellido;
	private JTextField tfApellido;
	private JTextField tfNombre;
	private JTextField tfDNI;
	private Juez originalJuez;
	private JButton bModify;

	public ModificarJuezPanel(Juez juez) {
		originalJuez = juez;

		setBorder(null);
		setLayout(new MigLayout("", "[grow][grow][][grow][grow]", "[][][][][grow][]"));

		JLabel lblNewLabel_3 = new JLabel("Datos antiguos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNewLabel_3, "cell 0 0 2 1");

		JLabel lblNuevosDatos = new JLabel("Datos nuevos");
		lblNuevosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNuevosDatos, "cell 3 0 2 1");

		JLabel lblNewLabel = new JLabel("DNI");
		add(lblNewLabel, "cell 0 1,alignx trailing");

		tfOldDNI = new JTextField();
		tfOldDNI.setEditable(false);
		add(tfOldDNI, "cell 1 1,growx");
		tfOldDNI.setColumns(10);

		JLabel label = new JLabel("DNI");
		add(label, "cell 3 1,alignx trailing");

		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		add(tfDNI, "cell 4 1,growx");

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		add(lblNewLabel_1, "cell 0 2,alignx trailing");

		tfOldNombre = new JTextField();
		tfOldNombre.setEditable(false);
		add(tfOldNombre, "cell 1 2,growx");
		tfOldNombre.setColumns(10);

		JLabel label_1 = new JLabel("Nombre");
		add(label_1, "cell 3 2,alignx trailing");

		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		add(tfNombre, "cell 4 2,growx");

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		add(lblNewLabel_2, "cell 0 3,alignx trailing");

		tfOldApellido = new JTextField();
		tfOldApellido.setEditable(false);
		add(tfOldApellido, "cell 1 3,growx");
		tfOldApellido.setColumns(10);

		JLabel label_2 = new JLabel("Apellido");
		add(label_2, "cell 3 3,alignx trailing");

		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		add(tfApellido, "cell 4 3,growx");

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		add(separator, "cell 2 0 1 5,growy");

		bModify = new JButton("Aceptar");
		bModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doModify();
			}
		});
		add(bModify, "cell 0 5 5 1,growx");

		feedOldObjectData();
	}

	private void feedOldObjectData() {
		tfOldDNI.setText(originalJuez.dniJuez);
		tfOldNombre.setText(originalJuez.nombre);
		tfOldApellido.setText(originalJuez.apellidos);
	}

	protected void doModify() {
		String dni = tfOldDNI.getText();
		String nombre = tfNombre.getText();
		String apellido = tfApellido.getText();

		Juez juez = new Juez(dni, nombre.isEmpty() ? nombre : tfOldNombre.getText(),
				apellido.isEmpty() ? apellido : tfOldNombre.getText());

		GestionJuez.modificar(juez);
		((ListaJuecesPanel) VentanaPrincipal.intFrameListaJueces.getContentPane().getComponent(0)).doUpdate();
	}
}

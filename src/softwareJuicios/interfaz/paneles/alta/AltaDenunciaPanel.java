package softwareJuicios.interfaz.paneles.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.interfaz.paneles.listar.IListaPanel;

public class AltaDenunciaPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private static JComboBox<Persona> cbDNIAcusado;
	private static JComboBox<Persona> cbDNIVictima;
	private JTextArea taDescripcion;
	private JCalendar calendar;
	private JTextField tfID;

	public AltaDenunciaPanel() {
		setBorder(new TitledBorder(null, "Alta de persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[33%][grow]", "[][][][][center][grow,fill][bottom]"));

		JLabel lblIdDenuncia = new JLabel("ID Denuncia");
		add(lblIdDenuncia, "cell 0 0,alignx trailing");

		tfID = new JTextField();
		tfID.setEditable(false);
		add(tfID, "cell 1 0,growx");
		tfID.setColumns(10);

		JLabel lblNewLabel = new JLabel("DNI Acusado");
		add(lblNewLabel, "cell 0 1,alignx trailing");

		cbDNIAcusado = new JComboBox<Persona>();
		add(cbDNIAcusado, "cell 1 1,growx");

		JLabel lblNewLabel_1 = new JLabel("DNI Victima");
		add(lblNewLabel_1, "cell 0 2,alignx trailing");

		cbDNIVictima = new JComboBox<Persona>();

		add(cbDNIVictima, "cell 1 2,growx");

		JLabel lblComntario = new JLabel("Descripcion");
		add(lblComntario, "cell 0 3,alignx trailing");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 3,grow");

		taDescripcion = new JTextArea();
		taDescripcion.setRows(4);
		taDescripcion.setColumns(10);
		scrollPane.setViewportView(taDescripcion);

		JLabel lblNewLabel_2 = new JLabel("Fecha de formalizacion");
		add(lblNewLabel_2, "cell 0 4,alignx trailing");

		calendar = new JCalendar();
		add(calendar, "flowx,cell 1 4,growx,aligny center");

		JButton btnLimpiar = new JButton("Limpiar");
		add(btnLimpiar, "flowx,cell 0 6 2 1,growx");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doInsert();
			}
		});
		add(btnNewButton, "cell 0 6 2 1,growx");
		tfID.setText(Integer.toString(getLastID() + 1));

		doUpdate();
	}

	private void doUpdate() {

		DefaultComboBoxModel<Persona> x = new DefaultComboBoxModel<Persona>();
		x.addElement(null);
		for (Persona persona : GestionPersona.personas) {
			x.addElement(persona);
		}
		DefaultComboBoxModel<Persona> y = new DefaultComboBoxModel<Persona>();
		y.addElement(null);
		for (Persona persona : GestionPersona.personas) {
			y.addElement(persona);
		}
		cbDNIVictima.setModel(x);
		cbDNIAcusado.setModel(y);
	}

	protected int getLastID() {
		int ultimoID = 0;
		for (Denuncia denuncia : GestionDenuncia.denuncias) {
			if (denuncia.idDenuncia > ultimoID) {
				ultimoID = denuncia.idDenuncia;
			}
		}
		return ultimoID;
	}

	protected void doInsert() {
		int idDenuncia = getLastID() + 1;
		String dniAcusado = (String) cbDNIAcusado.getSelectedItem();
		String dniVictima = (String) cbDNIVictima.getSelectedItem();
		String descripcion = taDescripcion.getText();
		Date fechaFormalizacion = calendar.getDate();
		Denuncia denuncia = new Denuncia(dniAcusado, dniVictima, descripcion, idDenuncia, fechaFormalizacion);
		GestionDenuncia.alta(denuncia);
		((IListaPanel) VentanaPrincipal.internalFrameListDenuncias.getContentPane().getComponent(0)).doUpdate();
	}

}

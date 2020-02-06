package softwareJuicios.interfaz.paneles.alta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.gestion.GestionJuicio;
import softwareJuicios.operaciones.Consultas;

public class AltaJuicioPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private JTextField tfIdJuicio;
	private JComboBox<String> cbIdDenuncia;
	private JTextField tfLocalidad;
	private JCalendar calendar;
	private JButton btnLimpiar;
	private JComboBox<?> cbJuicioAnterior;

	public AltaJuicioPanel() {
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Alta de juicio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new MigLayout("", "[33%][grow]", "[][][][][][grow][]"));

		add(new JLabel("Referencia de juicio"), "cell 0 0,alignx trailing");

		tfIdJuicio = new JTextField();
		tfIdJuicio.setEditable(false);
		tfIdJuicio.setEnabled(false);
		add(tfIdJuicio, "cell 1 0,growx");
		tfIdJuicio.setColumns(10);

		add(new JLabel("Referencia de denuncia"), "cell 0 1,alignx right");

		cbIdDenuncia = new JComboBox<String>();
		add(cbIdDenuncia, "cell 1 1,growx");

		add(new JLabel("Juicio anterior"), "cell 0 2,alignx trailing");

		cbJuicioAnterior = new JComboBox<Object>();
		add(cbJuicioAnterior, "cell 1 2,growx");

		add(new JLabel("Localidad"), "cell 0 3,alignx trailing");

		tfLocalidad = new JTextField();
		add(tfLocalidad, "cell 1 3,growx");
		tfLocalidad.setColumns(10);

		add(new JLabel("Fecha del juicio"), "cell 0 4,alignx right");

		calendar = new JCalendar();
		add(calendar, "cell 1 4,alignx center");

		btnLimpiar = new JButton("Limpiar");
		add(btnLimpiar, "flowx,cell 0 6 2 1,growx");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction();
			}
		});
		add(btnNewButton, "cell 0 6 2 1,growx");

		actualizarCampos();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void actualizarCampos() {
		Consultas.actualizarDatos();
		DefaultComboBoxModel<Juicio> modeloJuicios = new DefaultComboBoxModel<Juicio>();
		DefaultComboBoxModel<Denuncia> modeloDenuncia = new DefaultComboBoxModel<Denuncia>();

		for (Denuncia denuncia : GestionDenuncia.denuncias) {
			modeloDenuncia.addElement(denuncia);
		}

		modeloJuicios.addElement(null);
		for (Juicio juicio : GestionJuicio.juicios) {
			modeloJuicios.addElement(juicio);
		}
		cbJuicioAnterior.setModel((ComboBoxModel) modeloJuicios);
		cbIdDenuncia.setModel((ComboBoxModel) modeloDenuncia);
	}

	public void doAction() {
		int cuenta = Consultas.count(Juicio.class);
		int idJuicio = cuenta + 1;
		Denuncia denuncia = (Denuncia) cbIdDenuncia.getSelectedItem();
		int idDenuncia = denuncia.idDenuncia;
		Date fechaInicio = calendar.getDate(), fechaFinalizacion = null;
		String localidad = tfLocalidad.getText();
		boolean finalizado = false;
		Juicio juicioAnterior = (Juicio) cbJuicioAnterior.getSelectedItem();
		Juicio juicio = new Juicio(idJuicio, idDenuncia, new java.sql.Date(fechaInicio.getTime()),
				(java.sql.Date) fechaFinalizacion, localidad, finalizado, juicioAnterior);
		GestionJuicio.alta(juicio);
	}

}

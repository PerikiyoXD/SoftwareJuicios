package softwareJuicios.interfaz.paneles.modificar;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import net.miginfocom.swing.MigLayout;

public class ModificarDenunciaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013005213706154836L;
	String[] datosAntiguos;
	String[] datosnuevos;
	private JTextField hintId;
	private JTextField hintDniAcusado;
	private JTextField hintDniVictima;
	private JTextField nuevoDniAcusado;
	private JTextField nuevoDniVictima;
	private JCalendar nuevaFecha;

	/**
	 * Create the panel.
	 */
	public ModificarDenunciaPanel() {
		setBorder(new TitledBorder(null, "Modificar denuncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[491px,grow][]"));

		JPanel datosPanel = new JPanel();
		add(datosPanel, "cell 0 0,grow");
		datosPanel.setLayout(new MigLayout("", "[][grow][grow]", "[][][][grow][grow][]"));

		JLabel lblNewLabel = new JLabel("ID ");
		datosPanel.add(lblNewLabel, "cell 0 0,alignx trailing");

		hintId = new JTextField();
		hintId.setHorizontalAlignment(SwingConstants.CENTER);
		hintId.setEditable(false);
		datosPanel.add(hintId, "cell 1 0 2 1,alignx center");
		hintId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Dni acusado");
		datosPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");

		hintDniAcusado = new JTextField();
		hintDniAcusado.setEditable(false);
		datosPanel.add(hintDniAcusado, "flowx,cell 1 1,growx");
		hintDniAcusado.setColumns(10);

		nuevoDniAcusado = new JTextField();
		datosPanel.add(nuevoDniAcusado, "cell 2 1,growx");
		nuevoDniAcusado.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dni victima");
		datosPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");

		hintDniVictima = new JTextField();
		hintDniVictima.setEditable(false);
		datosPanel.add(hintDniVictima, "flowx,cell 1 2,growx");
		hintDniVictima.setColumns(10);

		nuevoDniVictima = new JTextField();
		datosPanel.add(nuevoDniVictima, "cell 2 2,growx");
		nuevoDniVictima.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		datosPanel.add(lblNewLabel_3, "cell 0 3");

		JTextArea hintComentario = new JTextArea();
		hintComentario.setEditable(false);
		datosPanel.add(hintComentario, "flowx,cell 1 3,grow");

		JTextArea nuevoComentario = new JTextArea();
		datosPanel.add(nuevoComentario, "cell 2 3,grow");

		JLabel lblNewLabel_4 = new JLabel("Fecha");
		datosPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");

		JCalendar oldFecha = new JCalendar();
		oldFecha.setNullDateButtonVisible(true);
		oldFecha.setNullDateButtonText("Usar fecha nula");
		oldFecha.getDayChooser().setWeekOfYearVisible(false);
		datosPanel.add(oldFecha, "cell 1 4,alignx center,aligny center");

		nuevaFecha = new JCalendar();
		nuevaFecha.setDecorationBackgroundColor(Color.CYAN);
		nuevaFecha.setWeekdayForeground(Color.BLUE);
		nuevaFecha.setSundayForeground(Color.RED);
		nuevaFecha.setNullDateButtonVisible(true);
		nuevaFecha.setNullDateButtonText("Usar fecha nula");
		nuevaFecha.getDayChooser().setWeekOfYearVisible(false);
		datosPanel.add(nuevaFecha, "cell 2 4,alignx center,aligny center");

		JButton btnNewButton = new JButton("Modificar");
		datosPanel.add(btnNewButton, "flowx,cell 0 5 3 1,growx");
	}

}

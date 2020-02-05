package softwareJuicios.interfaz.paneles.alta;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AltaDenunciaPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private JTextField tfDNI;
	private JTextField tfNombre;

	public AltaDenunciaPanel() {
		setBorder(new TitledBorder(null, "Alta de persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[33%][grow]", "[][][][grow,center][grow,fill][bottom]"));
		
		JLabel lblNewLabel = new JLabel("DNI Acusado");
		add(lblNewLabel, "cell 0 0,alignx trailing");
		
		tfDNI = new JTextField();
		add(tfDNI, "cell 1 0,growx");
		tfDNI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI Victima");
		add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		tfNombre = new JTextField();
		add(tfNombre, "cell 1 1,growx");
		tfNombre.setColumns(10);
		
		JLabel lblComntario = new JLabel("Descripcion");
		add(lblComntario, "cell 0 2,alignx trailing");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 2,grow");
		
		JTextArea taDescripcion = new JTextArea();
		taDescripcion.setRows(4);
		taDescripcion.setColumns(10);
		scrollPane.setViewportView(taDescripcion);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de formalizacion");
		add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		JCalendar calendar = new JCalendar();
		add(calendar, "flowx,cell 1 3,growx,aligny center");
		
		JButton btnLimpiar = new JButton("Limpiar");
		add(btnLimpiar, "flowx,cell 0 5 2 1,growx");
		
		JButton btnNewButton = new JButton("Aceptar");
		add(btnNewButton, "cell 0 5 2 1,growx");

	}

}

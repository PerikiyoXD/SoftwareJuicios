package softwareJuicios.interfaz.paneles;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class AltaJuezPanel extends JPanel {
	private static final long serialVersionUID = -9197532968226095389L;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellido;

	public AltaJuezPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Alta de juez", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		add(btnNewButton, "cell 0 4,growx");

	}

}

package softwareJuicios.interfaz.paneles.modificar;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.interfaz.paneles.listar.ListaJuezPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModificarJuezPanel extends JPanel {

	
	public ListaJuezPanel lista;
	public String datos[];
	private JTextField hintDni;
	private JTextField hintNombre;
	private JTextField hintApellidos;
	private JTextField nuevoNombre;
	private JTextField nuevoApallido;
	/**
	 * Create the panel.
	 */
	public ModificarJuezPanel() {
		setBorder(new TitledBorder(null, "Modificar juez", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px][grow]", "[491px,grow][]"));
		lista=new ListaJuezPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		
		JPanel panelNuevoDatos = new JPanel();
		add(panelNuevoDatos, "cell 1 0,grow");
		panelNuevoDatos.setLayout(new MigLayout("", "[][grow][grow]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Dni");
		panelNuevoDatos.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		hintDni = new JTextField();
		hintDni.setEditable(false);
		panelNuevoDatos.add(hintDni, "cell 1 0,growx,aligny top");
		hintDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		panelNuevoDatos.add(lblNombre, "cell 0 1,alignx trailing");
		
		hintNombre = new JTextField();
		hintNombre.setEditable(false);
		panelNuevoDatos.add(hintNombre, "cell 1 1,growx");
		hintNombre.setColumns(10);
		
		nuevoNombre = new JTextField();
		panelNuevoDatos.add(nuevoNombre, "cell 2 1,growx");
		nuevoNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panelNuevoDatos.add(lblApellidos, "cell 0 2,alignx trailing");
		
		hintApellidos = new JTextField();
		hintApellidos.setEditable(false);
		panelNuevoDatos.add(hintApellidos, "cell 1 2,growx");
		hintApellidos.setColumns(10);
		
		nuevoApallido = new JTextField();
		panelNuevoDatos.add(nuevoApallido, "cell 2 2,growx");
		nuevoApallido.setColumns(10);
		
		JButton btnModificarRegistro = new JButton("Modificar registro");
		add(btnModificarRegistro, "flowx,cell 0 1");
		
		JButton btnAceptarCambios = new JButton("Aceptar cambios");
		add(btnAceptarCambios, "cell 0 1");
		
		
	}

}

package softwareJuicios.interfaz.paneles.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciasPanel;



public class ModificarPersonaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013005213706154836L;
	
	private ListaDenunciasPanel lista;
	public String datos[];
	public String datosAntiguos[];
	private JTextField hintDni;
	private JTextField hintNombre;
	private JTextField hintApellidos;
	private JTextField nuevoNombre;
	private JTextField nuevoApallido;
	/**
	 * Create the panel.
	 */
	public ModificarPersonaPanel() {
		setBorder(new TitledBorder(null, "Modificar denuncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px][grow]", "[491px,grow][]"));
		lista= new ListaDenunciasPanel();
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
		JButton btnModificarRegistroSeleccionado = new JButton("Modificar registro seleccionado");
		btnModificarRegistroSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doAction();
			}

		});
		add(btnModificarRegistroSeleccionado, "flowx,cell 0 1");
		
		JButton btnNewButton = new JButton("Aceptar cambios");
		add(btnNewButton, "cell 0 1");
	}

	private void doFinaly() {
		String campo[] = null, dato[] = null;

		int i = 0;
		if (!nuevoNombre.getText().isEmpty()) {
			campo[i] = "nombre";
			dato[i] = nuevoNombre.getText();
			i++;

		} else if (!nuevoApallido.getText().isEmpty()) {
			campo[i] = "apellido";
			dato[i] = nuevoApallido.getText();
			i++;

		}
		Persona p = new Persona(datosAntiguos[0], dato[0], dato[1]);
		GestionPersona.modificar(p, campo, dato, "dni");

	}

	private void doAction() {
		// TODO Auto-generated method stub
		int i = lista.table.getSelectedRow();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "no ha seleccionado ningun registro");
		} else {
			String datosaux[] = { String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 0)),
					String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 1)),
					String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 2))};
			datosAntiguos = datosaux;
		}
	}


}

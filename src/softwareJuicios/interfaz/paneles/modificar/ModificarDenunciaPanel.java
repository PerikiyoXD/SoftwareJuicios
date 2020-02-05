package softwareJuicios.interfaz.paneles.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;



public class ModificarDenunciaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013005213706154836L;
	
	private ListaDenunciaPanel lista;
	String []datos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ModificarDenunciaPanel() {
		setBorder(new TitledBorder(null, "Modificar denuncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px][grow]", "[491px,grow][]"));
		lista= new ListaDenunciaPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		
		JButton btnModificarRegistroSeleccionado = new JButton("Modificar registro seleccionado");
		btnModificarRegistroSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doAction();
			}

		});
		
		JPanel datosPanel = new JPanel();
		add(datosPanel, "cell 1 0,grow");
		datosPanel.setLayout(new MigLayout("", "[][grow]", "[][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("ID ");
		datosPanel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		textField.setEditable(false);
		datosPanel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dni acusado");
		datosPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		datosPanel.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dni victima");
		datosPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		datosPanel.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		datosPanel.add(lblNewLabel_3, "cell 0 3");
		
		JTextArea textArea = new JTextArea();
		datosPanel.add(textArea, "cell 1 3,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha");
		datosPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		datosPanel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		add(btnModificarRegistroSeleccionado, "flowx,cell 0 1");
		
		JButton btnAceptarCambios = new JButton("Aceptar cambios");
		add(btnAceptarCambios, "cell 0 1");
	}

	private void doAction() {
		// TODO Auto-generated method stub
		int i=lista.table.getSelectedRow();
		if (i==-1) {
			JOptionPane.showMessageDialog(null, "no ha seleccionado ningun registro");
		}else {
		String datosaux[]= {String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),0)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),1)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),2)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),3)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),5))};
		datos=datosaux;
		}
	}

}

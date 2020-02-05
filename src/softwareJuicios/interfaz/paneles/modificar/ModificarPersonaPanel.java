package softwareJuicios.interfaz.paneles.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;



public class ModificarPersonaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013005213706154836L;
	
	private ListaDenunciaPanel lista;
	String []datos;

	/**
	 * Create the panel.
	 */
	public ModificarPersonaPanel() {
		setBorder(new TitledBorder(null, "Modificar denuncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px]", "[491px][]"));
		lista= new ListaDenunciaPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		
		JButton btnModificarRegistroSeleccionado = new JButton("Modificar registro seleccionado");
		btnModificarRegistroSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doAction();
			}

		});
		add(btnModificarRegistroSeleccionado, "cell 0 1");
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

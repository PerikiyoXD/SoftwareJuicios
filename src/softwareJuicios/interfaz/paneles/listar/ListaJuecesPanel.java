package softwareJuicios.interfaz.paneles.listar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Juez;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.operaciones.Consultas;

/***
 * Panel con una tabla que muestra jueces. Permite actualizar, insertar y borrar
 * elementos.
 */
public class ListaJuecesPanel extends JPanel implements IListaPanel {
	private static final long serialVersionUID = 4399415890397369410L;
	public static final Object[] TABLE_COLUMNS = new Object[] { "DNI", "Nombre", "Apellidos" };

	public JTable table;
	private JButton bUpdate;
	private JScrollPane scrollPane;
	private JButton bInsert;
	private JButton bDelete;

	public ListaJuecesPanel() {
		setBorder(new TitledBorder(null, "Lista de jueces", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][]"));

		bUpdate = new JButton("Actualizar");
		bUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doUpdate();
			}
		});

		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		scrollPane.setViewportView(table);

		bInsert = new JButton("Insertar");
		bInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doInsert();
			}
		});
		add(bInsert, "flowx,cell 0 1");
		add(bUpdate, "cell 0 1,growx");

		bDelete = new JButton("Eliminar");
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		add(bDelete, "cell 0 1");

		// Llenar la tabla con datos
		doUpdate();
	}

	/***
	 * Lógica de eliminación
	 */
	public void doDelete() {
		int selectedRow = table.getSelectedRow();
		String dniJuez = (String) table.getValueAt(selectedRow, 0);

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar");
			return;
		}

		for (Juez j : GestionJuez.jueces) {
			if (j.dniJuez == dniJuez) {
				GestionJuez.baja(j);
				doUpdate();
				return;
			}
		}
	}

	/***
	 * Lógica de inserción
	 */
	public void doInsert() {
		VentanaPrincipal.doAddJueces();
	}

	/***
	 * Lógica de actualización
	 */
	public void doUpdate() {
		Consultas.actualizarDatos();
		DefaultTableModel dtm = new DefaultTableModel(null, TABLE_COLUMNS) {
			private static final long serialVersionUID = -9003045890991085220L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Iteramos y añadimos cada elemento a la tabla
		for (Juez j : GestionJuez.jueces) {
			dtm.addRow(new Object[] { j.dniJuez, j.nombre, j.apellidos });
		}
		table.setModel(dtm);
	}
}

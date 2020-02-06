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
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.operaciones.Consultas;

/***
 * Panel con una tabla que muestra personas. Permite actualizar, insertar y
 * borrar elementos.
 */
public class ListaPersonasPanel extends JPanel implements IListaPanel {
	private static final long serialVersionUID = 4260193286369716923L;
	public static final Object[] TABLE_COLUMNS = new Object[] { "DNI", "Nombre", "Apellidos" };

	private JTable table;
	private JButton bUpdate;
	private JScrollPane scrollPane;
	private JButton bInsert;
	private JButton bDelete;

	public ListaPersonasPanel() {
		setBorder(new TitledBorder(null, "Lista de personas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		// Comprobar selección en tabla es valida
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar");
			return;
		}

		String dniPersona = (String) table.getValueAt(selectedRow, 0);

		for (Persona p : GestionPersona.personas) {
			if (p.dni.equals(dniPersona)) {
				GestionPersona.baja(p);
				doUpdate();
				return;
			}
		}
	}

	/***
	 * Lógica de inserción
	 */
	public void doInsert() {
		VentanaPrincipal.doAddPersonas();
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
		for (Persona persona : GestionPersona.personas) {
			dtm.addRow(new Object[] { persona.dni, persona.nombre, persona.apellido });
		}
		table.setModel(dtm);
	}
}

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
import softwareJuicios.entidades.Juicio;
import softwareJuicios.gestion.GestionJuicio;
import softwareJuicios.interfaz.VentanaPrincipal;
import softwareJuicios.operaciones.Consultas;

/***
 * Panel con una tabla que muestra juicios. Permite actualizar, insertar y
 * borrar elementos.
 */
public class ListaJuiciosPanel extends JPanel implements IListaPanel {
	private static final long serialVersionUID = 4399415890397369410L;
	public static final Object[] TABLE_COLUMNS = new Object[] { "ID", "ID Anterior", "Fecha Inicio", "Fecha finaliz.",
			"Localidad", "Denuncia" };

	public JTable table;
	private JButton bAction;
	private JScrollPane scrollPane;
	private JButton bInsert;
	private JButton bDelete;
	private JButton bModify;

	public ListaJuiciosPanel() {
		setBorder(new TitledBorder(null, "Lista de juicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][][][]"));

		scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		bInsert = new JButton("Insertar");
		bInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doInsert();
			}
		});

		bDelete = new JButton("Eliminar");
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		add(scrollPane, "cell 0 0,grow");
		add(bInsert, "flowx,cell 0 2");

		bModify = new JButton("Modificar");
		bModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doModify();
			}
		});
		add(bModify, "cell 0 2");
		add(bDelete, "cell 0 2");

		bAction = new JButton("Actualizar");
		bAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doUpdate();
			}
		});
		add(bAction, "cell 0 3,growx");

		doUpdate();
	}

	/***
	 * Lógica de modificación
	 */
	public void doModify() {
		// TODO Auto-generated method stub

	}

	/***
	 * Lógica de inserción
	 */
	public void doInsert() {
		VentanaPrincipal.doInsertJuicios();
	}

	/***
	 * Lógica de eliminación
	 */
	public void doDelete() {
		int selectedRow = table.getSelectedRow();
		int idJuicio = (int) table.getValueAt(selectedRow, 0);

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar");
			return;
		}

		for (Juicio j : GestionJuicio.juicios) {
			if (j.idJuicio == idJuicio) {
				GestionJuicio.baja(j);
				return;
			}
		}
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
		for (Juicio j : GestionJuicio.juicios) {
			dtm.addRow(new Object[] { j.idJuicio, j.juicioAnterior, j.fechaInicio, j.fechaFinalizacion, j.localidad,
					j.idDenuncia });
		}
		table.setModel(dtm);
	}
}

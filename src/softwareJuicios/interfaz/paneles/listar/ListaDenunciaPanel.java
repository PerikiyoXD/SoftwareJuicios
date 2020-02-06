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
import softwareJuicios.entidades.Denuncia;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.operaciones.Consultas;

/***
 * Panel con una tabla que muestra denuncias.
 */
public class ListaDenunciaPanel extends JPanel {
	private static final long serialVersionUID = 4399415890397369410L;
	public static final Object[] TABLE_COLUMNS = new Object[] { "ID Denuncia", "DNI Acusado", "DNI Víctima",
			"Descripción", "Fecha formalización" };

	public JTable table;
	private JButton bAction;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnAadir;

	public ListaDenunciaPanel() {
		setBorder(new TitledBorder(null, "Lista de denuncias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][]"));

		bAction = new JButton("Actualizar");
		bAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populate();
			}
		});

		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		scrollPane.setViewportView(table);

		btnAadir = new JButton("A\u00F1adir");
		add(btnAadir, "flowx,cell 0 1");
		add(bAction, "cell 0 1,growx");

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		add(btnEliminar, "cell 0 1");

		// Llenar la tabla con datos
		populate();
	}

	protected void doDelete() {
		int selectedRow = table.getSelectedRow();
		int idDenuncia = (int) table.getValueAt(selectedRow, 0);

		Denuncia denunciaEliminar = null;

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar");
			return;
		}

		for (Denuncia d : GestionDenuncia.denuncias) {
			if (d.idDenuncia == idDenuncia) {
				denunciaEliminar = d;
				GestionDenuncia.baja(d);
				return;
			}
		}

	}

	/***
	 * Llena la tabla con los elementos a llenar.
	 */
	public void populate() {
		Consultas.actualizarDatos();
		DefaultTableModel dtm = new DefaultTableModel(null, TABLE_COLUMNS) {
			private static final long serialVersionUID = -9003045890991085220L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Iteramos y añadimos cada elemento a la tabla
		for (Denuncia d : GestionDenuncia.denuncias) {
			dtm.addRow(new Object[] { d.idDenuncia, d.dniAcusado, d.dniVictima, d.descripcion, d.fechaFormalizacion });
		}
		table.setModel(dtm);
	}
}

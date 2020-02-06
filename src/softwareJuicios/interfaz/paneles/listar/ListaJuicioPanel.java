package softwareJuicios.interfaz.paneles.listar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.gestion.GestionJuicio;
import softwareJuicios.operaciones.Consultas;

/***
 * Panel con una tabla que muestra juicios.
 */
public class ListaJuicioPanel extends JPanel {
	private static final long serialVersionUID = 4399415890397369410L;
	public static final Object[] TABLE_COLUMNS = new Object[] { "ID", "ID Anterior", "Fecha Inicio", "Fecha finaliz.",
			"Localidad", "Denuncia" };

	public JTable table;
	private JButton bAction;
	private JScrollPane scrollPane;

	public ListaJuicioPanel() {
		setBorder(new TitledBorder(null, "Lista de juicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		add(bAction, "cell 0 1,growx");

		populate();
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
		for (Juicio j : GestionJuicio.juicios) {
			dtm.addRow(new Object[] { j.idJuicio, j.juicioAnterior, j.fechaInicio, j.fechaFinalizacion, j.localidad,
					j.idDenuncia });
		}
		table.setModel(dtm);
	}
}

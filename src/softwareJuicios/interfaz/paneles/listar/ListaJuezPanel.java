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
import softwareJuicios.entidades.Juez;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.operaciones.Consultas;

public class ListaJuezPanel extends JPanel {

	private static final long serialVersionUID = 4399415890397369410L;

	public JTable table;

	/**
	 * Create the panel.
	 */
	public ListaJuezPanel() {
		setBorder(new TitledBorder(null, "Lista de jueces", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][]"));

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populate();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		scrollPane.setViewportView(table);
		add(btnNewButton, "cell 0 1,growx");

		populate();
	}

	private void populate() {
		Consultas.actualizarDatos();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Dni juez");
		dtm.addColumn("nombre");
		dtm.addColumn("Apellidos");

		for (Juez j : GestionJuez.jueces) {
			dtm.addRow(new Object[] { j.dniJuez, j.nombre, j.apellidos });
		}
		table.setModel(dtm);

	}
}

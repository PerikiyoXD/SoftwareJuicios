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
import softwareJuicios.entidades.Denuncia;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.operaciones.Consultas;

public class ListaDenunciaPanel extends JPanel {

	private static final long serialVersionUID = 4399415890397369410L;

	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaDenunciaPanel() {
		setBorder(new TitledBorder(null, "Lista de denuncias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		dtm.addColumn("ID de denuncia");
		dtm.addColumn("Dni acusado");
		dtm.addColumn("Dni victima");
		dtm.addColumn("Descripcion");
		dtm.addColumn("Fecha de formalizacion");
		for (Denuncia d : GestionDenuncia.denuncias) {
			dtm.addRow(new Object[] { d.idDenuncia, d.dniAcusado, d.dniVictima, d.descripcion, d.fechaFormalizacion });
		}
		table.setModel(dtm);

	}

}

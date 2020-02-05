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

public class ListaJuicioPanel extends JPanel {

	private static final long serialVersionUID = 4399415890397369410L;
	public JTable table;

	public ListaJuicioPanel() {
		setBorder(new TitledBorder(null, "Lista de juicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		dtm.addColumn("ID del juicio");
		dtm.addColumn("ID juicio anterior");
		dtm.addColumn("Fecha de Inicio");
		dtm.addColumn("Fecha de finalizacion");
		dtm.addColumn("Localidad");
		dtm.addColumn("ID de denuncia");
		for (Juicio j : GestionJuicio.juicios) {
			dtm.addRow(new Object[] { j.idJuicio, j.juicioAnterior, j.fechaInicio, j.fechaFinalizacion, j.localidad,
					j.idDenuncia });
		}
		table.setModel(dtm);

	}

}

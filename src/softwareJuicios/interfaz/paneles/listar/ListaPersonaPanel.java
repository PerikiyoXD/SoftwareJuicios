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
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.operaciones.Consultas;

public class ListaPersonaPanel extends JPanel {
	private static final long serialVersionUID = 4260193286369716923L;
	private JTable table;

	public ListaPersonaPanel() {
		setBorder(new TitledBorder(null, "Lista de personas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		dtm.addColumn("DNI");
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		for (Persona persona : GestionPersona.personas) {
			dtm.addRow(new Object[] { persona.dni, persona.nombre, persona.apellido });
		}
		table.setModel(dtm);

	}

}

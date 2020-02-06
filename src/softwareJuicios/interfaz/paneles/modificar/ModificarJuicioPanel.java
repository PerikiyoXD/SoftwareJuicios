package softwareJuicios.interfaz.paneles.modificar;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.gestion.GestionJuicio;
import softwareJuicios.interfaz.paneles.listar.ListaJuiciosPanel;
import softwareJuicios.operaciones.Consultas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModificarJuicioPanel extends JPanel {
	public ListaJuiciosPanel lista;
	public String datos[];
	public String datosAntiguos[];
	private JTextField hintJuicioAnterior;
	private JTextField hintFechaI;
	private JTextField hintFechaF;
	private JTextField hintLocalidad;
	private JTextField hintIdDenuncia;
	private JTextField nuevoJuicioA;
	private JTextField nuevoFechaI;
	private JTextField nuevoFechaF;
	private JTextField nuevoLocalidad;
	private JTextField nuevoIdDenuncia;
	/**
	 * Create the panel.
	 */
	public ModificarJuicioPanel() {
		setBorder(new TitledBorder(null, "Modificar juicio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px][grow]", "[491px,grow][]"));
		lista = new ListaJuiciosPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("ID Juicio anterior");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		hintJuicioAnterior = new JTextField();
		hintJuicioAnterior.setEditable(false);
		panel.add(hintJuicioAnterior, "flowx,cell 1 0,growx");
		hintJuicioAnterior.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		panel.add(lblFechaInicio, "cell 0 1,alignx trailing");
		
		hintFechaI = new JTextField();
		hintFechaI.setEditable(false);
		hintFechaI.setColumns(10);
		panel.add(hintFechaI, "flowx,cell 1 1,growx");
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		panel.add(lblFechaFin, "cell 0 2,alignx trailing");
		
		hintFechaF = new JTextField();
		hintFechaF.setEditable(false);
		hintFechaF.setColumns(10);
		panel.add(hintFechaF, "flowx,cell 1 2,growx");
		
		JLabel lblLocalidad = new JLabel("Localidad");
		panel.add(lblLocalidad, "cell 0 3,alignx trailing");
		
		hintLocalidad = new JTextField();
		hintLocalidad.setEditable(false);
		hintLocalidad.setColumns(10);
		panel.add(hintLocalidad, "flowx,cell 1 3,growx");
		
		JLabel lblIdDenuncia = new JLabel("Id denuncia");
		panel.add(lblIdDenuncia, "cell 0 4,alignx trailing");
		
		hintIdDenuncia = new JTextField();
		hintIdDenuncia.setEditable(false);
		hintIdDenuncia.setColumns(10);
		panel.add(hintIdDenuncia, "flowx,cell 1 4,growx");
		
		nuevoJuicioA = new JTextField();
		panel.add(nuevoJuicioA, "cell 1 0");
		nuevoJuicioA.setColumns(10);
		
		nuevoFechaI = new JTextField();
		nuevoFechaI.setColumns(10);
		panel.add(nuevoFechaI, "cell 1 1");
		
		nuevoFechaF = new JTextField();
		nuevoFechaF.setColumns(10);
		panel.add(nuevoFechaF, "cell 1 2");
		
		nuevoLocalidad = new JTextField();
		nuevoLocalidad.setColumns(10);
		panel.add(nuevoLocalidad, "cell 1 3");
		
		nuevoIdDenuncia = new JTextField();
		nuevoIdDenuncia.setColumns(10);
		panel.add(nuevoIdDenuncia, "cell 1 4");
		
		JButton btnNewButton = new JButton("Modificar registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction();
			}
		});
		add(btnNewButton, "flowx,cell 0 1");
		
		JButton btnNewButton_1 = new JButton("Aceptar cambios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doFinaly();
			}
		});
		add(btnNewButton_1, "cell 0 1");
		
		
	}
	private void doFinaly() {
		String campo[] = null, dato[] = null;
  Date fechaI = null; Date fechaF = null;boolean fin=false;
		int i = 0;
		if (!nuevoFechaI.getText().isEmpty()) {
			campo[i] = "fechaInicio";
			 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		      
		        try {
		            fechaI = formato.parse(nuevoFechaI.getText());
		        } 
		        catch (ParseException ex) 
		        {
		            System.out.println(ex);
		        }
			dato[i] =nuevoFechaI.getText();
			i++;

		} else if (!nuevoFechaF.getText().isEmpty()) {
			campo[i] = "fechaFinalizacion";
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	      
	        try {
	            fechaF = formato.parse(nuevoFechaF.getText());
	        } 
	        catch (ParseException ex) 
	        {
	            System.out.println(ex);
	        }
		dato[i] =nuevoFechaF.getText();
			i++;
			fin=true;

		} else if (!nuevoJuicioA.getText().isEmpty() && Consultas.comprobarRegistro(Consultas.getObject(3, nuevoJuicioA.getText()))) {
			campo[i] = "idJuicioAnterior";
			dato[i] = nuevoJuicioA.getText();
			i++;

		} else if (!nuevoLocalidad.getText().isEmpty()) {
			campo[i] = "localidad";
			dato[i] = nuevoLocalidad.getText();
			i++;

		} else if (!nuevoIdDenuncia.getText().isEmpty() &&  Consultas.comprobarRegistro(Consultas.getObject(1, nuevoIdDenuncia.getText())) ) {
			campo[i] = "idDenuncia";
			dato[i] = nuevoIdDenuncia.getText();
			i++;

		}
		
		
		Juicio j=new Juicio(Integer.parseInt(datosAntiguos[0]),Integer.parseInt(dato[4]),fechaI,fechaF,dato[3],fin,(Juicio)Consultas.getObject(3, dato[2]));
		GestionJuicio.modificar(j, campo, dato, "dniJuicio");

	}

	private void doAction() {
		// TODO Auto-generated method stub
		int i = lista.table.getSelectedRow();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "no ha seleccionado ningun registro");
		} else {
			String datosaux[] = { String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 0)),
					String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 1)),
					String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 2)),
					String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 3)),String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(), 4)) };
			datosAntiguos = datosaux;
		}
	}

}

package softwareJuicios.interfaz.paneles.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import softwareJuicios.entidades.Denuncia;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;



public class ModificarDenunciaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013005213706154836L;
	
	private ListaDenunciaPanel lista;
	String []datosAntiguos;
	String []datosnuevos;
	private JTextField hintId;
	private JTextField hintDniAcusado;
	private JTextField hintDniVictima;
	private JTextField hintFecha;
	private JTextField nuevoDniAcusado;
	private JTextField nuevoDniVictima;
	private JCalendar nuevaFecha;

	/**
	 * Create the panel.
	 */
	public ModificarDenunciaPanel() {
		setBorder(new TitledBorder(null, "Modificar denuncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[478px][grow]", "[491px,grow][]"));
		lista= new ListaDenunciaPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		
		JButton btnModificarRegistroSeleccionado = new JButton("Modificar registro seleccionado");
		btnModificarRegistroSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doAction();
			}

		});
		
		JPanel datosPanel = new JPanel();
		add(datosPanel, "cell 1 0,grow");
		datosPanel.setLayout(new MigLayout("", "[][grow][grow]", "[][][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("ID ");
		datosPanel.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		hintId = new JTextField();
		hintId.setEditable(false);
		datosPanel.add(hintId, "flowx,cell 1 0,growx");
		hintId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dni acusado");
		datosPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		hintDniAcusado = new JTextField();
		hintDniAcusado.setEditable(false);
		datosPanel.add(hintDniAcusado, "flowx,cell 1 1,growx");
		hintDniAcusado.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dni victima");
		datosPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		hintDniVictima = new JTextField();
		hintDniVictima.setEditable(false);
		datosPanel.add(hintDniVictima, "flowx,cell 1 2,growx");
		hintDniVictima.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		datosPanel.add(lblNewLabel_3, "cell 0 3");
		
		JTextArea hintComentario = new JTextArea();
		hintComentario.setEditable(false);
		datosPanel.add(hintComentario, "cell 1 3,grow");
		
		JTextArea nuevoComentario = new JTextArea();
		datosPanel.add(nuevoComentario, "cell 2 3,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha");
		datosPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		hintFecha = new JTextField();
		hintFecha.setEditable(false);
		datosPanel.add(hintFecha, "cell 1 4,growx");
		hintFecha.setColumns(10);
		
		nuevoDniAcusado = new JTextField();
		datosPanel.add(nuevoDniAcusado, "cell 1 1");
		nuevoDniAcusado.setColumns(10);
		
		nuevoDniVictima = new JTextField();
		datosPanel.add(nuevoDniVictima, "cell 1 2");
		nuevoDniVictima.setColumns(10);
		
		 nuevaFecha = new JCalendar();
		datosPanel.add(nuevaFecha, "cell 2 4,grow");
		add(btnModificarRegistroSeleccionado, "flowx,cell 0 1");
		
		JButton btnAceptarCambios = new JButton("Aceptar cambios");
		btnAceptarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doFinaly();
			}
		});
		add(btnAceptarCambios, "cell 0 1");
	}
	private void doFinaly() {
		String campo[] = null,dato[] = null;
		
		int i=0;
		if (!nuevoDniAcusado.getText().isEmpty()) {
			campo[i]="dniAcusado";
			dato[i]=nuevoDniAcusado.getText();
			i++;
			
		}else if (!nuevoDniVictima.getText().isEmpty()) {
			campo[i]="dniVictima";
			dato[i]=nuevoDniVictima.getText();
			i++;
			
		}else if(nuevaFecha.getDate()==null) {
			campo[i]="fechaFormalizacion";
			String date=nuevaFecha.getDate().toString();
			dato[i]=date;
		}
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(dato[4]);
	        } 
	        catch (ParseException ex) 
	        {
	            System.out.println(ex);
	        }
	        Denuncia denuncia=new Denuncia(datosAntiguos[3],datosAntiguos[1],datosAntiguos[2],Integer.parseInt(datosAntiguos[0]),fechaDate);
		GestionDenuncia.modificar(denuncia, campo, dato, "idDenuncia");
		
	}

	private void doAction() {
		// TODO Auto-generated method stub
		int i=lista.table.getSelectedRow();
		if (i==-1) {
			JOptionPane.showMessageDialog(null, "no ha seleccionado ningun registro");
		}else {
		String datosaux[]= {String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),0)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),1)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),2)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),3)),
				String.valueOf(lista.table.getValueAt(lista.table.getSelectedRow(),4))};
		datosAntiguos=datosaux;
		}
	}

}

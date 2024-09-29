package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorReporte;
import entidad.ReporteItem;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmReporte extends JFrame  implements ActionListener, ControladorReporte.View{

	private JPanel contentPane;
	private JTextField textFecha;
	private JButton btnEjecutar;
	private JButton btnNewButton_1;
	private JTable tablaReporte;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();
	ControladorReporte controlador;
	private JTextField textTotalDia;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporte frame = new FrmReporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmReporte() {
		setTitle("REPORTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFecha = new JTextField();
		textFecha.setBounds(31, 60, 195, 28);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		btnEjecutar = new JButton("CONSULTAR");
		btnEjecutar.setForeground(new Color(255, 255, 255));
		btnEjecutar.setIcon(new ImageIcon(FrmReporte.class.getResource("/img/consulta.png")));
		btnEjecutar.setBackground(new Color(0, 0, 255));
		btnEjecutar.addActionListener(this);
		btnEjecutar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjecutar.setBounds(305, 55, 160, 37);
		contentPane.add(btnEjecutar);
		
		btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.setIcon(new ImageIcon(FrmReporte.class.getResource("/img/imprimir.png")));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(179, 405, 160, 37);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 483, 233);
		contentPane.add(scrollPane);
		
		tablaReporte = new JTable();
		scrollPane.setViewportView(tablaReporte);
		model.addColumn("Código");
		model.addColumn(" Producto");
		model.addColumn("Cantidad");
		model.addColumn("Monto por Producto");
		
		tablaReporte.setModel(model);
		
		textTotalDia = new JTextField();
		textTotalDia.setEnabled(false);
		textTotalDia.setBounds(363, 103, 102, 28);
		contentPane.add(textTotalDia);
		textTotalDia.setColumns(10);
		
		lblNewLabel = new JLabel("Venta Total del Dia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(208, 108, 131, 21);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("INGRESAR LA FECHA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 35, 176, 14);
		contentPane.add(lblNewLabel_1);
		
		controlador = new ControladorReporte(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnEjecutar) {
			actionPerformedBtnEjecutar(e);
		}
	}

	@Override
	public void mostrarListaReporte(List<ReporteItem> items) {
		for (ReporteItem item : items) {
			model.addRow(new Object[] {
					item.getCodigoProducto(),
					item.getNombreProducto(),
					item.getCantidadProducto(),
					item.getTotal()
			});
		}
		tablaReporte.setModel(model);
	}

	@Override
	public void mostrarTotalReporte(String total) {
		textTotalDia.setText(total);
	}
	
	protected void actionPerformedBtnEjecutar(ActionEvent e) {
		controlador.generarReporte(textFecha.getText());
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		try {
			tablaReporte.print();
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}
	}
}

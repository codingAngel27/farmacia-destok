package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladores.ProductosDAO;
import entidad.Config;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEmpresa extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2516756026285411389L;
	private JPanel contentPane;
	private JTextField textRuc;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textMensaje;
	private JTextField textID;
	private JButton btnActualizar;
	Config conf = new Config();
    ProductosDAO proDao = new ProductosDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpresa frame = new FrmEmpresa();
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
	public FrmEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RUC");
		lblNewLabel.setBounds(49, 85, 92, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(49, 126, 92, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setBounds(49, 179, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONO");
		lblNewLabel_3.setBounds(49, 221, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MENSAJE");
		lblNewLabel_4.setBounds(49, 265, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		textRuc = new JTextField();
		textRuc.setBounds(151, 90, 122, 20);
		contentPane.add(textRuc);
		textRuc.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(151, 126, 122, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(151, 176, 122, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(151, 218, 122, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textMensaje = new JTextField();
		textMensaje.setBounds(151, 262, 122, 20);
		contentPane.add(textMensaje);
		textMensaje.setColumns(10);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(116, 306, 105, 23);
		contentPane.add(btnActualizar);
		
		textID = new JTextField();
		textID.setBounds(190, 11, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		Actualizar();
	}
	private void ListarConfig() {
        conf = proDao.BuscarDatos();
        textID.setText("" + conf.getId());
        textRuc.setText("" + conf.getRuc());
        textNombre.setText("" + conf.getNombre());
        textTelefono.setText("" + conf.getTelefono());
        textDireccion.setText("" + conf.getDireccion());
        textMensaje.setText("" + conf.getMensaje());
    }
	
	private void Actualizar() {
		 if (!"".equals(textRuc.getText()) || !"".equals(textNombre.getText()) || !"".equals(textTelefono.getText()) || !"".equals(textDireccion.getText())) {
	            conf.setRuc(textRuc.getText());
	            conf.setNombre(textNombre.getText());
	            conf.setTelefono(textTelefono.getText());
	            conf.setDireccion(textDireccion.getText());
	            conf.setMensaje(textMensaje.getText());
	            conf.setId(Integer.parseInt(textID.getText()));
	            proDao.ModificarDatos(conf);
	            JOptionPane.showMessageDialog(null, "Datos de la empresa modificado");
	            ListarConfig();
	        } else {
	            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
	        }
	}
}

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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RUC");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel.setBounds(59, 83, 92, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(61, 129, 109, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_2.setBounds(61, 176, 132, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONO");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(59, 223, 119, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MENSAJE");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_4.setBounds(61, 279, 117, 17);
		contentPane.add(lblNewLabel_4);
		
		textRuc = new JTextField();
		textRuc.setBounds(218, 86, 190, 28);
		contentPane.add(textRuc);
		textRuc.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(218, 132, 190, 28);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(218, 179, 190, 28);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(218, 223, 190, 28);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textMensaje = new JTextField();
		textMensaje.setBounds(218, 268, 190, 28);
		contentPane.add(textMensaje);
		textMensaje.setColumns(10);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon(FrmEmpresa.class.getResource("/img/nuevo.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(201, 341, 163, 38);
		contentPane.add(btnActualizar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ACTUALIZAR DATOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(10, 29, 496, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(400, 11, 86, 20);
		panel.add(textID);
		textID.setEditable(false);
		textID.setEnabled(false);
		textID.setText("10");
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
	private void Limpiar() {
	   textRuc.setText("");
	   textNombre.setText("");
	   textTelefono.setText("");
	   textDireccion.setText("");
	   textMensaje.setText("");
	   textRuc.requestFocus();
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
	            Limpiar();
	        } else {
	            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
	        }
	}
}

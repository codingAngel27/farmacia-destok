package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controlador.UsuarioDAO;
import entidad.Login;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class FrmUsuarios extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textNombre;
	private JPasswordField password;
	private JTable tblUsuarios;
	private JButton btnRegistrar;
    
	DefaultTableModel model = new DefaultTableModel();
	Login login = new Login();
	UsuarioDAO usuDao = new UsuarioDAO();
	private JComboBox<?> cbRoles;
	private JTextField texId;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuarios frame = new FrmUsuarios();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmUsuarios() {
		setTitle("Registro de usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NUEVO USUARIO", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 816, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMAIL");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 151, 100, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 88, 100, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 28, 100, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ROL");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 214, 100, 20);
		panel.add(lblNewLabel_3);
		
		textEmail = new JTextField();
		textEmail.setBackground(new Color(0, 206, 209));
		textEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textEmail.setBounds(10, 178, 210, 25);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(0, 206, 209));
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textNombre.setBounds(10, 52, 210, 25);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		password = new JPasswordField();
		password.setBackground(new Color(0, 206, 209));
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		password.setBounds(10, 115, 210, 25);
		panel.add(password);
		
		cbRoles = new JComboBox();
		cbRoles.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "CAJERA", "CAJERO"}));
		cbRoles.setBounds(10, 240, 190, 25);
		panel.add(cbRoles);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(44, 276, 125, 38);
		panel.add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 42, 576, 340);
		panel.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.setFillsViewportHeight(true);
		tblUsuarios.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblUsuarios);
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Correo");
		model.addColumn("Rol");		
		tblUsuarios.setModel(model);
		tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50); 
		tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(180); 
		tblUsuarios.getTableHeader().setReorderingAllowed(false);
		texId = new JTextField();
		texId.setVisible(false);
		texId.setEditable(false);
		texId.setEnabled(false);
		texId.setBounds(701, 11, 86, 20);
		panel.add(texId);
		texId.setColumns(10);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(44, 335, 125, 38);
		panel.add(btnEliminar);
		
		ListarUsuarios();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		btnRegistrar();
	}
	
	private void ListarUsuarios() {
		List<Login> listarUsuario = usuDao.ListarUsuarios();
		model.setRowCount(0);
		
		for(int i = 0; i < listarUsuario.size(); i++) {
			Object[]fila= {
					listarUsuario.get(i).getId(),
					listarUsuario.get(i).getNombre(),
					listarUsuario.get(i).getCorreo(),
					listarUsuario.get(i).getRol()
					
			};
			model.addRow(fila);
		}
		tblUsuarios.setModel(model);
	}
	private void Limpiar() {
		textEmail.setText("");
		textNombre.setText("");
		password.setText("");
		cbRoles.setSelectedIndex(0);
		texId.setText("");
		textEmail.requestFocus();
	}
	private void btnRegistrar() {
		if (textNombre.getText().equals("") || textEmail.getText().equals("") || password.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
        } else {
            String correo = textEmail.getText();
            String pass = String.valueOf(password.getPassword());
            String nom = textNombre.getText();
            String rol = cbRoles.getSelectedItem().toString();
            login.setNombre(nom);
            login.setCorreo(correo);
            login.setPass(pass);
            login.setRol(rol);
            usuDao.Registrar(login);
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            ListarUsuarios();
            Limpiar();
        }
	}
	
	
	
	
	
}

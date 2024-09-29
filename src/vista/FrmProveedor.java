package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controladores.ProveedorDAO;
import entidad.Proveedor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class FrmProveedor extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRuc;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTable tblProveedor;
	private JButton btnNuevo;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	DefaultTableModel model = new DefaultTableModel();
	
	Proveedor pro = new Proveedor();
	
	ProveedorDAO arrProvee = new ProveedorDAO();
	private JTextField textId;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedor frame = new FrmProveedor();
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
	public FrmProveedor() {
		setTitle("PROVEEDOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1092, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRAR DATOS DEL PROVEEDOR");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_1.setBackground(new Color(50, 205, 50));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 1, 1076, 32);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 59, 653, 411);
		contentPane.add(scrollPane);
		
		tblProveedor = new JTable();
		tblProveedor.setFillsViewportHeight(true);
		tblProveedor.addMouseListener(this);
		tblProveedor.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblProveedor);
		model.addColumn("ID");
		model.addColumn("RUC");
		model.addColumn("Nombre");
		model.addColumn("Telefono");
		model.addColumn("Dirección");
		tblProveedor.setModel(model);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setEnabled(false);
		textId.setBounds(969, 13, 97, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 32, 1076, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/editar.png")));
		btnModificar.setBounds(32, 349, 145, 38);
		panel.add(btnModificar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(224, 279, 145, 38);
		panel.add(btnNuevo);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/eliminar.png")));
		btnEliminar.setBounds(224, 349, 145, 38);
		panel.add(btnEliminar);
		
		btnAgregar = new JButton("GUARDAR");
		btnAgregar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/agregar.png")));
		btnAgregar.setBounds(32, 279, 145, 38);
		panel.add(btnAgregar);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(163, 214, 225, 30);
		panel.add(textDireccion);
		textDireccion.setBackground(new Color(0, 206, 209));
		textDireccion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textDireccion.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(163, 158, 225, 30);
		panel.add(textTelefono);
		textTelefono.setBackground(new Color(0, 206, 209));
		textTelefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textTelefono.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(163, 103, 225, 30);
		panel.add(textNombre);
		textNombre.setBackground(new Color(0, 206, 209));
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textNombre.setColumns(10);
		
		textRuc = new JTextField();
		textRuc.setBounds(163, 44, 225, 30);
		panel.add(textRuc);
		textRuc.setBackground(new Color(0, 206, 209));
		textRuc.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textRuc.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOMBRE  ");
		lblNewLabel.setBounds(21, 111, 118, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setBounds(20, 222, 145, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		
		JLabel lblContacto = new JLabel("CONTACTO");
		lblContacto.setBounds(21, 166, 118, 22);
		panel.add(lblContacto);
		lblContacto.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(20, 52, 86, 22);
		panel.add(lblRuc);
		lblRuc.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnAgregar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnNuevo.addActionListener(this);
		btnModificar.addActionListener(this);
		
		ListarProveedor();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificarJButton(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregarJButton(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevoJButton(e);
		}
	}
	protected void actionPerformedBtnNuevoJButton(ActionEvent e) {
		btnNuevo();
	}
	protected void actionPerformedBtnAgregarJButton(ActionEvent e) {
		btnGuardar();
	}
	protected void actionPerformedBtnModificarJButton(ActionEvent e) {
		btnModificar();
		btnNuevo();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
	}
	
	private void btnNuevo(){
		textId.setText("");
		textRuc.setText("");
		textNombre.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
		textRuc.requestFocus();
	}
	private void ListarProveedor() {
		List<Proveedor> listarProvee = arrProvee.ListarProveedor();
		model.setRowCount(0);
		
		for(int i = 0; i < listarProvee.size(); i++) {
			Object[]fila= {
					listarProvee.get(i).getId(),
					listarProvee.get(i).getRuc(),
					listarProvee.get(i).getNombre(),
					listarProvee.get(i).getTelefono(),
					listarProvee.get(i).getDireccion()
					
			};
			model.addRow(fila);
		}
		tblProveedor.setModel(model);
	}

	private void btnGuardar(){
		String ruc = textRuc.getText();
	    String nombres = textNombre.getText();
	    String telefono = textTelefono.getText();
	    String direccion = textDireccion.getText();

	    if (!ruc.isEmpty() && !nombres.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty()) {
	        if (arrProvee.existeProveedor(ruc)) {
	        	JOptionPane.showMessageDialog(null, "La empresa ya está registrado", "Aviso", JOptionPane.WARNING_MESSAGE);
	            btnNuevo();
	        } else {
	            pro.setRuc(ruc);
	            pro.setNombre(nombres);
	            pro.setTelefono(telefono);
	            pro.setDireccion(direccion);
	            arrProvee.RegistrarProveedor(pro);
	            ListarProveedor();
	            btnNuevo();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Los campos están vacíos","Error", JOptionPane.ERROR_MESSAGE);
	        btnNuevo();
	    }
	}
	
	private void btnModificar() {
		if ("".equals(textId.getText())) {
            JOptionPane.showMessageDialog(null, "Seleecione una fila");
        } else {
            if (!"".equals(textRuc.getText()) || !"".equals(textNombre.getText()) || !"".equals(textTelefono.getText()) || !"".equals(textDireccion.getText())) {
                pro.setRuc(textRuc.getText());
                pro.setNombre(textNombre.getText());
                pro.setTelefono(textTelefono.getText());
                pro.setDireccion(textDireccion.getText());
                pro.setId(Integer.parseInt(textId.getText()));
                arrProvee.ModificarProveedor(pro);
                JOptionPane.showMessageDialog(null, "Proveedor Modificado");
                ListarProveedor();
                
            }
        }
	}
	
	private void verDatos(int posFila) {
		if (posFila != -1) {
			String id, dni, nombre, telefono, direccion;

			id = tblProveedor.getValueAt(posFila, 0).toString();
			dni = tblProveedor.getValueAt(posFila, 1).toString();
			nombre = tblProveedor.getValueAt(posFila, 2).toString();
			telefono = tblProveedor.getValueAt(posFila, 3).toString();
			direccion = tblProveedor.getValueAt(posFila, 4).toString();
			textId.setText(id);
			textRuc.setText(dni);
			textNombre.setText(nombre);
			textTelefono.setText(telefono);
			textDireccion.setText(direccion);
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblProveedor) {
			mouseReleasedTblProveedorJTable(e);
		}
	}
	protected void mouseReleasedTblProveedorJTable(MouseEvent e) {
		int posFila;
		posFila = tblProveedor.getSelectedRow();
		verDatos(posFila);
	}
}

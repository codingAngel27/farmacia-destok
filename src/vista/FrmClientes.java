package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import controladores.ClienteDAO;
import entidad.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FrmClientes extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7285175769296104740L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTable tblClientes;
	private JTextField textNombres;
	private JTextField textTelefono;
	private JLabel lblNombres;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JTextField textId;
	private JTextField textDireccion;

	private JButton btnAgregar;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField textDni;
	MatteBorder borderBottom = new MatteBorder(0, 0, 2, 0, Color.BLACK);
	DefaultTableModel model = new DefaultTableModel();
	Cliente cl = new Cliente();
	ClienteDAO client = new ClienteDAO();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
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
	public FrmClientes() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1092, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRAR DATOS DEL CLIENTE");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(50, 205, 50));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1075, 35);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 54, 658, 427);
		contentPane.add(scrollPane);

		tblClientes = new JTable();
		tblClientes.addMouseListener(this);
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		model.addColumn("ID");
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("Telefono");
		model.addColumn("Dirección");

		tblClientes.setModel(model);

		textId = new JTextField();
		textId.setEnabled(false);
		textId.setEditable(false);
		textId.setBounds(942, 6, 119, 27);
		contentPane.add(textId);
		textId.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 35, 1075, 456);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDni = new JLabel("DNI/RUC");
		lblDni.setBounds(21, 30, 115, 25);
		panel.add(lblDni);
		lblDni.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		lblNombres = new JLabel("NOMBRES");
		lblNombres.setBounds(21, 80, 115, 25);
		panel.add(lblNombres);
		lblNombres.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(21, 135, 115, 20);
		panel.add(lblTelefono);
		lblTelefono.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(21, 183, 115, 25);
		panel.add(lblDireccion);
		lblDireccion.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		textNombres = new JTextField();
		textNombres.setBounds(147, 75, 232, 30);
		panel.add(textNombres);
		textNombres.setBackground(new Color(0, 206, 209));
		textNombres.setBorder(null);
		textNombres.setBorder(borderBottom);
		textNombres.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(147, 125, 232, 30);
		panel.add(textTelefono);
		textTelefono.setBackground(new Color(0, 206, 209));
		textTelefono.setBorder(null);
		textTelefono.setBorder(borderBottom);
		textTelefono.setColumns(10);

		textDireccion = new JTextField();
		textDireccion.setBounds(147, 178, 232, 30);
		panel.add(textDireccion);
		textDireccion.setBackground(new Color(0, 206, 209));
		textDireccion.setBorder(null);
		textDireccion.setBorder(borderBottom);
		textDireccion.setColumns(10);

		textDni = new JTextField();
		textDni.setBounds(147, 23, 232, 30);
		panel.add(textDni);
		textDni.setBackground(new Color(0, 206, 209));
		textDni.setBorder(null);
		textDni.setBorder(borderBottom);
		textDni.setColumns(10);
		
				btnAgregar = new JButton("AGREGAR");
				btnAgregar.setIcon(new ImageIcon(FrmClientes.class.getResource("/img/agregar.png")));
				btnAgregar.setBounds(21, 246, 145, 38);
				panel.add(btnAgregar);
				
						btnNuevo = new JButton("NUEVO");
						btnNuevo.setIcon(new ImageIcon(FrmClientes.class.getResource("/img/nuevo.png")));
						btnNuevo.setBounds(219, 246, 145, 38);
						panel.add(btnNuevo);
						
								btnModificar = new JButton("MODIFICAR");
								btnModificar.setIcon(new ImageIcon(FrmClientes.class.getResource("/img/editar.png")));
								btnModificar.setBounds(21, 324, 145, 38);
								panel.add(btnModificar);
								
										btnEliminar = new JButton("ELIMINAR");
										btnEliminar.setIcon(new ImageIcon(FrmClientes.class.getResource("/img/eliminar.png")));
										btnEliminar.setBounds(219, 324, 145, 38);
										panel.add(btnEliminar);
										btnEliminar.addActionListener(this);
								btnModificar.addActionListener(this);
						btnNuevo.addActionListener(this);
				btnAgregar.addActionListener(this);

		ListarCliente();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificarJButton(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevoJButton(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregarJButton(e);
		}
	}

	protected void actionPerformedBtnAgregarJButton(ActionEvent e) {
		btnAgregar();
	}

	protected void actionPerformedBtnNuevoJButton(ActionEvent e) {
		btnNuevo();
	}

	protected void actionPerformedBtnModificarJButton(ActionEvent e) {
		btnModificar();
		textId.setText("");
	}

	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		btnEliminar();
		textId.setText("");
	}
	///////////////////////METODOS DEL BOTON/////////////////////////////////
	public void ListarCliente() {
		List<Cliente> ListarCl = client.ListarCliente();
		model.setRowCount(0);
		Object[] ob = new Object[6];
		for (int i = 0; i < ListarCl.size(); i++) {
			ob[0] = ListarCl.get(i).getId();
			ob[1] = ListarCl.get(i).getDni();
			ob[2] = ListarCl.get(i).getNombre();
			ob[3] = ListarCl.get(i).getTelefono();
			ob[4] = ListarCl.get(i).getDireccion();
			model.addRow(ob);
		}
		tblClientes.setModel(model);
	}

	private void btnNuevo() {
		textDni.setText("");
		textNombres.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
		textDni.requestFocus();
	}
	
	private void btnAgregar() {
	    String dni = textDni.getText();
	    String nombres = textNombres.getText();
	    String telefono = textTelefono.getText();
	    String direccion = textDireccion.getText();

	    if (!dni.isEmpty() && !nombres.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty()) {
	        if (client.existeCliente(dni)) {
	        	JOptionPane.showMessageDialog(null, "El cliente con este DNI ya está registrado", "Aviso", JOptionPane.WARNING_MESSAGE);
	            btnNuevo();
	        } else {
	            cl.setDni(dni);
	            cl.setNombre(nombres);
	            cl.setTelefono(telefono);
	            cl.setDireccion(direccion);
	            client.RegistrarCliente(cl);
	            ListarCliente();
	            btnNuevo();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Los campos están vacíos","Error", JOptionPane.ERROR_MESSAGE);
	        btnNuevo();
	    }
	}
	private void btnModificar() {
		if ("".equals(textId.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(textDni.getText()) || !"".equals(textNombres.getText()) || !"".equals(textTelefono.getText())) {
                cl.setDni(textDni.getText());
                cl.setNombre(textNombres.getText());
                cl.setTelefono(textTelefono.getText());
                cl.setDireccion(textDireccion.getText());
                cl.setId(Integer.parseInt(textId.getText()));
                client.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                btnNuevo();
                ListarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
	}
	private void verDatos(int posFila) {
		if (posFila != -1) {
			String id, dni, nombre, telefono, direccion;

			id = tblClientes.getValueAt(posFila, 0).toString();
			dni = tblClientes.getValueAt(posFila, 1).toString();
			nombre = tblClientes.getValueAt(posFila, 2).toString();
			telefono = tblClientes.getValueAt(posFila, 3).toString();
			direccion = tblClientes.getValueAt(posFila, 4).toString();
		

			textId.setText(id);
			textDni.setText(dni);
			textNombres.setText(nombre);
			textTelefono.setText(telefono);
			textDireccion.setText(direccion);
			

		}
	}
	private void btnEliminar() {
    	if (!"".equals(textId.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(textId.getText());
                client.EliminarCliente(id);
                btnNuevo();
                ListarCliente();
            }
        }
    }
	// LimpiarTable();
	// LimpiarCliente();
	// ListarCliente();
	// btnEditarCliente.setEnabled(false);
	// btnEliminarCliente.setEnabled(false);
	// btnGuardarCliente.setEnabled(true);
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblClientes) {
			mouseReleasedTblClientesJTable(e);
		}
	}
	protected void mouseReleasedTblClientesJTable(MouseEvent e) {
		int posFila;
		posFila = tblClientes.getSelectedRow();
		verDatos(posFila);
	}
}

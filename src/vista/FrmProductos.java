package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controladores.ProductosDAO;
import controladores.ProveedorDAO;
import entidad.Combo;
import entidad.Productos;
import entidad.Proveedor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmProductos extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JTextField textStock;
	private JTextField textPrecio;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox<Combo> cbProveedor;

	Productos prod = new Productos();
	ProductosDAO arrPro = new ProductosDAO();

	ProveedorDAO arrProvee = new ProveedorDAO();

	DefaultTableModel model = new DefaultTableModel();
	private JTextField textIdPro;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductos frame = new FrmProductos();
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
	public FrmProductos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1093, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRAR PRODUCTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setBackground(new Color(50, 205, 50));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1077, 32);
		contentPane.add(lblNewLabel);

		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(0, 206, 209));
		textCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textCodigo.setBounds(167, 57, 225, 30);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblDescripcion.setBounds(26, 120, 124, 22);
		contentPane.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setBackground(new Color(0, 206, 209));
		textDescripcion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textDescripcion.setBounds(167, 112, 225, 30);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);

		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblStock.setBounds(26, 179, 124, 22);
		contentPane.add(lblStock);

		textStock = new JTextField();
		textStock.setBackground(new Color(0, 206, 209));
		textStock.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textStock.setBounds(167, 171, 225, 30);
		contentPane.add(textStock);
		textStock.setColumns(10);

		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblPrecio.setBounds(26, 235, 124, 22);
		contentPane.add(lblPrecio);

		textPrecio = new JTextField();
		textPrecio.setBackground(new Color(0, 206, 209));
		textPrecio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textPrecio.setBounds(167, 227, 225, 30);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		JLabel lblProveedor = new JLabel("PROVEEDOR");
		lblProveedor.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblProveedor.setBounds(26, 289, 131, 22);
		contentPane.add(lblProveedor);

		cbProveedor = new JComboBox<Combo>();
		cbProveedor.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		cbProveedor.setBounds(167, 281, 225, 30);
		contentPane.add(cbProveedor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(398, 57, 669, 424);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		model.addColumn("ID");
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Proveedor");
		model.addColumn("Stock");
		model.addColumn("Precio");
		table.setModel(model);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/nuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(211, 332, 145, 38);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/agregar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(33, 332, 145, 38);
		contentPane.add(btnGuardar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(26, 400, 145, 38);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(211, 400, 145, 38);
		contentPane.add(btnEliminar);
		
		textIdPro = new JTextField();
		textIdPro.setEditable(false);
		textIdPro.setEnabled(false);
		textIdPro.setBounds(951, 11, 116, 22);
		contentPane.add(textIdPro);
		textIdPro.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 31, 1077, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
				JLabel lblCodigo = new JLabel("CODIGO");
				lblCodigo.setBounds(26, 36, 124, 22);
				panel.add(lblCodigo);
				lblCodigo.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		llenarProveedor();
		ListarProductos();
		//verDatos(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificarJButton(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardarJButton(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevoJButton(e);
		}
	}

	protected void actionPerformedBtnNuevoJButton(ActionEvent e) {
		btnNuevo();
	}

	protected void actionPerformedBtnGuardarJButton(ActionEvent e) {
		btnGuardar();
	}

	protected void actionPerformedBtnModificarJButton(ActionEvent e) {
		btnModificar();
	}

	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		btnEliminar();
	}
    
	private void btnNuevo() {
		textCodigo.setText("");
		textDescripcion.setText("");
		textPrecio.setText("");
		textStock.setText("");
		cbProveedor.setSelectedIndex(0);
		textIdPro.setText("");
		textCodigo.requestFocus();
	}
	private void btnGuardar() {
	    String codigo = textCodigo.getText();
	    String nombre = textDescripcion.getText();
	    int proveedorId = -1; 
	    Combo itemP = (Combo) cbProveedor.getSelectedItem();
	    if (cbProveedor.getSelectedIndex() > 0) {
	        proveedorId = itemP.getId();
	    }else {
	    	JOptionPane.showMessageDialog(null, "Por favor, Seleccione un Proveedor");
	    }
	    try {
	        int stock = Integer.parseInt(textStock.getText());
	        double precio = Double.parseDouble(textPrecio.getText());

	        if (!codigo.isEmpty() && !nombre.isEmpty() && proveedorId >= 0 && stock > 0 && precio > 0) {
	            Productos prod = new Productos();
	            prod.setCodigo(codigo);
	            prod.setNombre(nombre);
	            prod.setProveedor(proveedorId);
	            prod.setStock(stock);
	            prod.setPrecio(precio);
	            arrPro.RegistrarProductos(prod);
	            JOptionPane.showMessageDialog(null, "Producto registrado");
	            ListarProductos();
	            cbProveedor.removeAllItems();
	            llenarProveedor();
	            btnNuevo();
	        } else {
	            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para Stock y Precio.");
	    }
	}
	private void llenarProveedor() {
	    List<Proveedor> lista = arrProvee.ListarProveedor();
	    cbProveedor.addItem(new Combo(-1, "SELECCIONAR"));
	    
	    for (int i = 0; i < lista.size(); i++) {
	        int id = lista.get(i).getId();
	        String nombre = lista.get(i).getNombre();
	        cbProveedor.addItem(new Combo(id, nombre));
	    }
	}

	private void ListarProductos() {
		List<Productos> listaPro = arrPro.ListarProductos();
		model.setRowCount(0);
		for (int i = 0; i < listaPro.size(); i++) {
			Object[] fila = { listaPro.get(i).getId(), listaPro.get(i).getCodigo(), listaPro.get(i).getNombre(),
					listaPro.get(i).getProveedorPro(), listaPro.get(i).getStock(), listaPro.get(i).getPrecio()
			};
			model.addRow(fila);
		}
		table.setModel(model);
	}
	private void btnModificar() {
		if (textIdPro.getText().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Seleccione una fila");
		} else {
	
	        if (cbProveedor.getSelectedIndex() >= 1) {
	            if (!textCodigo.getText().isEmpty() || !textDescripcion.getText().isEmpty() || !textStock.getText().isEmpty() || !textPrecio.getText().isEmpty()) {
	                Productos prod = new Productos();
	                prod.setCodigo(textCodigo.getText());
	                prod.setNombre(textDescripcion.getText());
	                Combo itemP = (Combo) cbProveedor.getSelectedItem();
	                prod.setProveedor(itemP.getId());
	                prod.setStock(Integer.parseInt(textStock.getText()));
	                prod.setPrecio(Double.parseDouble(textPrecio.getText()));
	                prod.setId(Integer.parseInt(textIdPro.getText()));
	                arrPro.ModificarProductos(prod);
	                JOptionPane.showMessageDialog(null, "Producto Modificado");
	                ListarProductos();
	                btnNuevo();
	                cbProveedor.removeAllItems();
	                llenarProveedor();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Seleccione un proveedor válido en el ComboBox.");
	        }
	    }
	}
	private void verDatos(int posFila) {
		if (posFila != -1) {
			String id, codigo, descr, stock, precio;
			String provee;

			id = table.getValueAt(posFila, 0).toString();
			codigo = table.getValueAt(posFila, 1).toString();
			descr = table.getValueAt(posFila, 2).toString();
			provee = table.getValueAt(posFila, 3).toString();
			stock = table.getValueAt(posFila, 4).toString();
			precio = table.getValueAt(posFila, 5).toString();
			textIdPro.setText(id);
			textCodigo.setText(codigo);
			textDescripcion.setText(descr);
			cbProveedor.setSelectedItem(provee);
			textStock.setText(stock);
			textPrecio.setText(precio);
		}
	}
	private void btnEliminar() {
		if (!"".equals(textIdPro.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(textIdPro.getText());
                arrPro.EliminarProductos(id);
                ListarProductos();
                btnNuevo();
                //btnEditarpro.setEnabled(false);
                //btnEliminarPro.setEnabled(false);
                //btnGuardarpro.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
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
		if (e.getSource() == table) {
			mouseReleasedTableJTable(e);
		}
	}
	protected void mouseReleasedTableJTable(MouseEvent e) {
		int posFila;
		posFila = table.getSelectedRow();
		verDatos(posFila);
	}
}

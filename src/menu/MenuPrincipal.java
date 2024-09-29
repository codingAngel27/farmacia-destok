package menu;

import java.awt.EventQueue;
import java.awt.Image;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import vista.FrmAyuda;
import vista.FrmClientes;
import vista.FrmEmpresa;
import vista.FrmProductos;
import vista.FrmProveedor;
import vista.FrmReporte;
import vista.FrmUsuarios;
import vista.FrmVenta;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class MenuPrincipal extends JFrame implements ActionListener, MenuListener{

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 2497379328327567253L;
	private JPanel contentPane;
	private JMenuItem menuClientes;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnVenta;
	private JMenu mnReporte;
	private JMenuItem menuGenerarVenta;
	private JMenuItem menuReportesDia;
	private JMenuItem menuAyuda;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/iconoFarmacia.png")));
		setResizable(false);
		setTitle("SISTEMA LA REMEDIOSA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (respuesta == JOptionPane.YES_OPTION) {
		            // Si el usuario selecciona "Sí", cerramos la ventana y salimos del sistema
		            dispose();
		            
		        } else {
		        	//System.exit(0);// Si el usuario selecciona "No", simplemente cerramos el cuadro de diálogo y la ventana seguirá abierta
		        }
		    }
		});
		setBounds(100, 100, 1300, 773);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("MENU");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/archivo.png")));
		menuBar_1.add(mnNewMenu);
		
		JMenu mnNewMenu_5 = new JMenu("CONFIGURACION");
		mnNewMenu_5.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/configuracion.png")));
		mnNewMenu.add(mnNewMenu_5);
		
		mntmNewMenuItem_4 = new JMenuItem("EMPRESA");
		mntmNewMenuItem_4.addActionListener(this);
		mntmNewMenuItem_4.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.TRAILING);
		mntmNewMenuItem_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/empresa.png")));
		mnNewMenu_5.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_3 = new JMenuItem("USUARIOS");
		mntmNewMenuItem_3.addActionListener(this);
		mntmNewMenuItem_3.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.TRAILING);
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/usuarios.png")));
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem = new JMenuItem("SALIR");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/salir.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu menuMantenimiento = new JMenu("REGISTRAR");
		menuMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar_1.add(menuMantenimiento);
		
		menuClientes = new JMenuItem("CLIENTES");
		menuClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Clientes.png")));
		menuClientes.addActionListener(this);
		menuMantenimiento.add(menuClientes);
		
		mntmNewMenuItem_1 = new JMenuItem("PROVEEDOR");
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/proveedor.png")));
		menuMantenimiento.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("PRODUCTOS");
		mntmNewMenuItem_2.addActionListener(this);
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/producto.png")));
		menuMantenimiento.add(mntmNewMenuItem_2);
		
		mnVenta = new JMenu("VENTAS");
		mnVenta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/venta.png")));
		mnVenta.addMenuListener(this);
		menuBar_1.add(mnVenta);
		
		menuGenerarVenta = new JMenuItem("GENERAR NUEVA VENTA");
		menuGenerarVenta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/generarventa.png")));
		menuGenerarVenta.addActionListener(this);
		mnVenta.add(menuGenerarVenta);
		
		mnReporte = new JMenu("REPORTES");
		mnReporte.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/reporte.png")));
		mnReporte.addMenuListener(this);
		menuBar_1.add(mnReporte);
		
		menuReportesDia = new JMenuItem("REPORTES DEL DIA");
		menuReportesDia.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/reporteDia.png")));
		menuReportesDia.addActionListener(this);
		mnReporte.add(menuReportesDia);
		
		JMenu mnNewMenu_4 = new JMenu("AYUDA");
		mnNewMenu_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/ayuda.png")));
		menuBar_1.add(mnNewMenu_4);
		
		menuAyuda = new JMenuItem("Sobre...");
		menuAyuda.addActionListener(this);
		mnNewMenu_4.add(menuAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/fondo-menu.jpg")));
		lblNewLabel.setBounds(0, 0, 1284, 696);
		contentPane.add(lblNewLabel);
		ImageIcon originalIcon = new ImageIcon(MenuPrincipal.class.getResource("/img/fondo-menu.jpg"));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(1284, 696, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblNewLabel.setIcon(resizedIcon);

	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItemJMenuItem(e);
		}
		if (e.getSource() == menuAyuda) {
			actionPerformedMenuAyudaJMenuItem(e);
		}
		if (e.getSource() == menuReportesDia) {
			actionPerformedMenuReportesDiaJMenuItem(e);
		}
		if (e.getSource() == menuGenerarVenta) {
			actionPerformedMenuGenerarVentaJMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_4) {
			actionPerformedMntmNewMenuItem_5JMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_6JMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_3JMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_2JMenuItem(e);
		}
		if (e.getSource() == menuClientes) {
			actionPerformedMenuClientesJMenuItem(e);
		}
	}
	protected void actionPerformedMenuClientesJMenuItem(ActionEvent e) {
		FrmClientes c = new FrmClientes();
		c.setVisible(true);
		c.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem_2JMenuItem(ActionEvent e) {
		FrmProveedor p = new FrmProveedor();
		p.setVisible(true);
		p.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem_3JMenuItem(ActionEvent e) {
		FrmProductos pro = new FrmProductos();
		pro.setVisible(true);
		pro.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem_6JMenuItem(ActionEvent e) {
		FrmUsuarios u = new FrmUsuarios();
		u.setVisible(true);
		u.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem_5JMenuItem(ActionEvent e) {
		FrmEmpresa e1 = new FrmEmpresa();
		e1.setVisible(true);
		e1.setLocationRelativeTo(this);
	}
	protected void actionPerformedMenuGenerarVentaJMenuItem(ActionEvent e) {
		FrmVenta v = new FrmVenta();
		v.setVisible(true);
		v.setLocationRelativeTo(this);
	}
	protected void actionPerformedMenuReportesDiaJMenuItem(ActionEvent e) {
		FrmReporte r = new FrmReporte();
		r.setVisible(true);
	    r.setLocationRelativeTo(this);	
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void actionPerformedMenuAyudaJMenuItem(ActionEvent e) {
		FrmAyuda a = new FrmAyuda();
		a.setVisible(true);
		a.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItemJMenuItem(ActionEvent e) {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que guardo todos los cambios?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
        	System.exit(0);
        } else {
        }
	}
}

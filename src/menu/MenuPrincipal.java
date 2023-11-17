package menu;

import java.awt.EventQueue;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.FrmClientes;
import vista.FrmEmpresa;
import vista.FrmProductos;
import vista.FrmProveedor;
import vista.FrmUsuarios;

import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame implements ActionListener {

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
		setResizable(false);
		setTitle("SISTEMA LA REMEDIOSA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("SALIR");
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
		
		JMenu mnNewMenu_2 = new JMenu("VENTAS");
		mnNewMenu_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/venta.png")));
		menuBar_1.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("REPORTES");
		mnNewMenu_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/reporte.png")));
		menuBar_1.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("AYUDA");
		mnNewMenu_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/ayuda.png")));
		menuBar_1.add(mnNewMenu_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1274, 685);
		contentPane.add(desktopPane);
		
		/*ImageIcon imageIcon = new ImageIcon(MenuPrincipal.class.getResource("/img/fondo-menu.jpg"));

		//Redimensionar la imagen xd
		Image image = imageIcon.getImage().getScaledInstance(1274, 696, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(image);*/
		///////////////////////////////	
	}
	

	public void actionPerformed(ActionEvent e) {
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
}

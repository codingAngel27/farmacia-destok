package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import controladores.LoginDAO;
import entidad.Login;
import menu.MenuPrincipal;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class FrmLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Login lg = new Login();
    LoginDAO login = new LoginDAO();
	
	private Timer tiempo;
    int contador;
    int segundos = 30;
    private JProgressBar barra;
    private JTextField textCorreo;
    private JPasswordField password;
    private JButton btnIngresar;
    private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setTitle("SISTEMA LA REMEDIOSA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/contraVale.png")));
		lblNewLabel_4.setBounds(386, 252, 46, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/usuarioVale.png")));
		lblNewLabel_3.setBounds(386, 122, 57, 61);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("CORREO ELECTRONICO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel.setBounds(162, 105, 227, 40);
		contentPane.add(lblNewLabel);
		
		password = new JPasswordField();
		password.setText("admin");
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		password.setBackground(new Color(0, 191, 255));
		password.setBounds(162, 243, 218, 40);
		contentPane.add(password);
		
		textCorreo = new JTextField();
		textCorreo.setText("admin@admin.com");
		textCorreo.setColumns(10);
		textCorreo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textCorreo.setBackground(new Color(0, 191, 255));
		textCorreo.setBounds(162, 139, 218, 40);
		contentPane.add(textCorreo);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel_1.setBounds(162, 210, 174, 40);
		contentPane.add(lblNewLabel_1);
		
		barra = new JProgressBar();
		barra.setForeground(new Color(0, 206, 209));
		barra.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		barra.setBackground(new Color(0, 191, 255));
		barra.setBounds(94, 457, 368, 40);
		contentPane.add(barra);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/salir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(212, 387, 158, 46);
		contentPane.add(btnSalir);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/ingresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(211, 315, 158, 46);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_5 = new JLabel("INICIAR SESION");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 191, 255));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_5.setBounds(0, 36, 569, 40);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 191, 255));
		lblNewLabel_2.setBounds(0, 0, 569, 538);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(76, 11, 46, 14);
		contentPane.add(label);
	}
	
	/*private void Limpiar(){
		textCorreo.setText("");
		password.setText("");
		textCorreo.requestFocus();
	}*/
	private class BarraProgreso implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            contador++;
            barra.setValue(contador);
            if (contador == 100) {
                tiempo.stop();
                if (barra.getValue() == 100) {
                    dispose();
                	JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Ingresaste", JOptionPane.INFORMATION_MESSAGE);
                	MenuPrincipal a = new MenuPrincipal();
    	            a.setVisible(true);
                }
            }
        }
    }
	public void Validar(){
        String correo = textCorreo.getText();
        String pass = String.valueOf(password.getPassword());
        if(!correo.isEmpty() && !pass.isEmpty())
        {
			
		
        if (!"".equals(correo) || !"".equals(pass)) {
            
            lg = login.log(correo, pass);
            if (lg.getCorreo()!= null && lg.getPass() != null) {
                barra.setVisible(true);
                contador = -1;
                barra.setValue(0);
                barra.setStringPainted(true);
                tiempo = new Timer(segundos, new BarraProgreso());
                tiempo.start();
            }else{
                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
                //Limpiar();
            }
            
        }
        } else  {
        	JOptionPane.showMessageDialog(null, "Los campos estan vacios");
		}
    }
	
	private void Salir() {
		 int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (respuesta == JOptionPane.YES_OPTION) {
	            // Si el usuario selecciona "Sí", cerramos la ventana y salimos del sistema
	        	System.exit(0);
 	}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalirJButton(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresarJButton(e);
		}
	}
	protected void actionPerformedBtnIngresarJButton(ActionEvent e) {
		Validar();
	}
	protected void actionPerformedBtnSalirJButton(ActionEvent e) {
		Salir();
	}
}


package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IFMetodoPago extends JInternalFrame implements ActionListener {
	private JRadioButton rdbtnVisa;
	private JRadioButton rdbtnEfectivo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JRadioButton rdbtYapePlim;
	private JLabel lblNewLabel_2;
	private Listener listener;

	/**
	 * Create the frame.
	 */
	public IFMetodoPago(Listener listener) {
		this.listener=listener;
			
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("FORMA DE PAGO");
		setClosable(true);
		setBounds(100, 100, 530, 308);
		getContentPane().setLayout(null);
		
		rdbtnVisa = new JRadioButton("TARJETA");
		rdbtnVisa.addActionListener(this);
		rdbtnVisa.setBackground(new Color(255, 255, 255));
		rdbtnVisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnVisa.setBounds(69, 127, 109, 23);
		getContentPane().add(rdbtnVisa);
		
		rdbtnEfectivo = new JRadioButton("EFECTIVO");
		rdbtnEfectivo.addActionListener(this);
		rdbtnEfectivo.setBackground(new Color(255, 255, 255));
		rdbtnEfectivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnEfectivo.setBounds(365, 127, 109, 23);
		getContentPane().add(rdbtnEfectivo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IFMetodoPago.class.getResource("/img/tarjeta.png")));
		lblNewLabel.setBounds(40, 71, 125, 39);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(IFMetodoPago.class.getResource("/img/money.png")));
		lblNewLabel_1.setBounds(395, 60, 79, 51);
		getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(168, 214, 247));
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(211, 187, 111, 45);
		getContentPane().add(btnNewButton);
		
		rdbtYapePlim = new JRadioButton("YAPE/PLIN");
		rdbtYapePlim.addActionListener(this);
		rdbtYapePlim.setBackground(new Color(255, 255, 255));
		rdbtYapePlim.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtYapePlim.setBounds(213, 128, 109, 23);
		getContentPane().add(rdbtYapePlim);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(IFMetodoPago.class.getResource("/img/yapePlim.png")));
		lblNewLabel_2.setBounds(228, 60, 120, 50);
		getContentPane().add(lblNewLabel_2);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtYapePlim) {
			actionPerformedRdbtnNewRadioButton(e);
		}
		if (e.getSource() == rdbtnEfectivo) {
			actionPerformedRdbtnEfectivo(e);
		}
		if (e.getSource() == rdbtnVisa) {
			actionPerformedRdbtnVisa(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		if(rdbtnEfectivo.isSelected()||rdbtnVisa.isSelected()||rdbtYapePlim.isSelected()) {
			JOptionPane.showMessageDialog(this, "Pago Exitoso \n Imprimiendo");
		}else {
			JOptionPane.showMessageDialog(this,"Selecciones un metodo de Pago","Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		listener.onPagarClick();
	}
	protected void actionPerformedRdbtnVisa(ActionEvent e) {
		if(rdbtnVisa.isSelected()) 
		{
			rdbtnEfectivo.setSelected(false);
			rdbtYapePlim.setSelected(false);
		}
	}
	protected void actionPerformedRdbtnEfectivo(ActionEvent e) {
		if(rdbtnEfectivo.isSelected()) 
		{
			rdbtnVisa.setSelected(false);
			rdbtYapePlim.setSelected(false);
		}
	}
	protected void actionPerformedRdbtnNewRadioButton(ActionEvent e) {
		if(rdbtYapePlim.isSelected()) {
			
			rdbtnEfectivo.setSelected(false);
			rdbtnVisa.setSelected(false);
		}
	}
	
	interface Listener {
		void onPagarClick();
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaCorporativo.Funcionario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDetalhesConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDetalhesConta frame = new TelaDetalhesConta();
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
	public TelaDetalhesConta() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 436);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAceitar = new JButton("Aprovar");
		btnAceitar.setBackground(Color.LIGHT_GRAY);
		btnAceitar.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/login.png")));
		btnAceitar.setBounds(79, 392, 116, 33);
		panel.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setBackground(Color.LIGHT_GRAY);
		btnRecusar.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/sair-menu.png")));
		btnRecusar.setBounds(232, 392, 129, 33);
		panel.add(btnRecusar);
		
		JLabel btnSair = new JLabel("");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/sair-menu-2.png")));
		btnSair.setBounds(412, 11, 22, 21);
		panel.add(btnSair);
		
		JLabel lblMsReferncia = new JLabel("M\u00EAs Refer\u00EAncia:");
		lblMsReferncia.setBounds(264, 175, 170, 14);
		panel.add(lblMsReferncia);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(264, 90, 46, 14);
		panel.add(lblData);
		
		JLabel lblValor = new JLabel("Valor Pago:");
		lblValor.setBounds(264, 129, 170, 14);
		panel.add(lblValor);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(25, 268, 63, 14);
		panel.add(lblCategoria);
		
		JLabel lblTipoDeSolicitao = new JLabel("Tipo de Solicita\u00E7\u00E3o:");
		lblTipoDeSolicitao.setBounds(25, 317, 140, 14);
		panel.add(lblTipoDeSolicitao);
		
		JLabel lblValorPago = new JLabel("Valor pago:");
		lblValorPago.setBounds(25, 360, 140, 14);
		panel.add(lblValorPago);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(25, 223, 140, 14);
		panel.add(lblDescrio);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(25, 175, 140, 14);
		panel.add(lblCargo);
		
		JLabel lblMatrculaDoFuncionrio = new JLabel("Matr\u00EDcula Do Funcion\u00E1rio: ");
		lblMatrculaDoFuncionrio.setBounds(25, 129, 170, 14);
		panel.add(lblMatrculaDoFuncionrio);
		
		JLabel lblNome = new JLabel("Nome funcion\u00E1rio:");
		lblNome.setBounds(25, 90, 113, 14);
		panel.add(lblNome);
		
		JLabel icone = new JLabel("");
		icone.setEnabled(false);
		icone.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/user.png")));
		icone.setBounds(184, 11, 113, 83);
		panel.add(icone);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/bg2.jpg")));
		background.setBounds(0, 0, 444, 436);
		panel.add(background);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
	}
}

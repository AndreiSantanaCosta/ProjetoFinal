package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.contaDAO;
import SistemaCorporativo.Funcionario;
import SistemaCorporativo.PrestarContas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDetalhesConta extends JFrame {

	private JPanel contentPane;
	private String tipoConta;
	private String msg = "";
	private contaDAO contaD = new contaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TelaDetalhesConta frame = new TelaDetalhesConta();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDetalhesConta(PrestarContas conta) {
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
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msg = contaD.setAlteracaoStatusConta(conta.getCodigoConta(), 1);
				JOptionPane.showMessageDialog(null, msg);
				dispose();
			}
		});
		
		btnAceitar.setBackground(Color.LIGHT_GRAY);
		btnAceitar.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/login.png")));
		btnAceitar.setBounds(79, 392, 116, 33);
		panel.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msg = contaD.setAlteracaoStatusConta(conta.getCodigoConta(), 2);
				JOptionPane.showMessageDialog(null, msg);
				dispose();
			}
		});
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
		
		JLabel lblMsReferncia = new JLabel("M\u00EAs Refer\u00EAncia: " + conta.getContaDoMes());
		lblMsReferncia.setBounds(25, 264, 336, 14);
		panel.add(lblMsReferncia);
		
		if(conta.getContaTipo() == 1) {
			tipoConta = "Prestação de Conta";
		}else {
			tipoConta = "Reembolso";
		}
		
		JLabel lblTipoDeSolicitao = new JLabel("Tipo de Solicita\u00E7\u00E3o: " + tipoConta);
		lblTipoDeSolicitao.setBounds(25, 304, 336, 14);
		panel.add(lblTipoDeSolicitao);
		
		JLabel lblValorPago = new JLabel("Valor pago: " + conta.getDespesa().getDespesaValor());
		lblValorPago.setBounds(25, 343, 336, 14);
		panel.add(lblValorPago);
	
		JLabel lblCargo = new JLabel("Cargo: " + conta.getPerfilDescricao());
		lblCargo.setBounds(25, 196, 336, 14);
		panel.add(lblCargo);
		
		JLabel lblMatrculaDoFuncionrio = new JLabel("Matr\u00EDcula Do Funcion\u00E1rio: " + conta.getFuncionario().getCodigoFuncionario());
		lblMatrculaDoFuncionrio.setBounds(25, 152, 336, 14);
		panel.add(lblMatrculaDoFuncionrio);
		
		JLabel lblNome = new JLabel("Nome funcion\u00E1rio:" + conta.getFuncionario().getNome());
		lblNome.setBounds(25, 125, 361, 14);
		panel.add(lblNome);
		
		JLabel icone = new JLabel("");
		icone.setEnabled(false);
		icone.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/Icones/user.png")));
		icone.setBounds(205, 11, 113, 83);
		panel.add(icone);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TelaDetalhesConta.class.getResource("/bg2.jpg")));
		background.setBounds(0, 0, 444, 436);
		panel.add(background);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
	}
}

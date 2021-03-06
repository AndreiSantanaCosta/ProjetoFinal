package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexao.Conexao;
import DAO.funcionarioDAO;
import SistemaCorporativo.Funcionario;
//import SistemaCorporativo.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaLoginPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField inputLogin;
	private JPasswordField inputSenha;
	private funcionarioDAO funcionarioD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginPrincipal frame = new TelaLoginPrincipal();
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
	public void configuracoesTela() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
	}
	
	public JPanel criaPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 444, 79);
		contentPane.add(panel);
		return panel;
	}
	
	public TelaLoginPrincipal() {
		
		configuracoesTela();
		
		JPanel panel = criaPanel();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/Icones/user.png")));
		panel.add(label);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setEnabled(false);
		lblLogin.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/Icones/login.png")));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBackground(Color.DARK_GRAY);
		lblLogin.setBounds(112, 90, 81, 29);
		contentPane.add(lblLogin);
		
		JButton button = new JButton("");
		button.setToolTipText("Ajuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Problemas ao logar?\n Lembre-se sua senha foi definida pelo "
						+ "administrador do sistema.\n Seu login e composto por seu nome sem espa�amento em jun��o com os 2 primeiros digitos do CPF");
			}
		});
		button.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/icons 1/help.png")));
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(247, 229, 33, 23);
		contentPane.add(button);
		
		inputLogin = new JTextField();
		inputLogin.setBounds(150, 120, 120, 20);
		contentPane.add(inputLogin);
		inputLogin.setColumns(10);
			
		inputSenha = new JPasswordField();
		inputSenha.setBounds(150, 191, 120, 20);
		contentPane.add(inputSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			int contador = 0;
			public void actionPerformed(ActionEvent arg0) {
				if(inputLogin.getText() != null && inputSenha.getPassword() != null) {
					try {
						Funcionario funcionario = new Funcionario();
						String senha = String.valueOf(inputSenha.getPassword());
						funcionario.setLogin(inputLogin.getText());
						funcionario.setSenha(senha);
						
						funcionarioD = new funcionarioDAO();
						funcionarioD.loginFuncionario(funcionario);
						
						if(funcionario.getVerificaLogin() == true) {
							TelaLoginMDI frame = new TelaLoginMDI(funcionario);
							frame.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null, "Usuario n�o cadastrado. Contate o Administrador do sistema");
							TelaLoginPrincipal framePrincipal = new TelaLoginPrincipal();
							framePrincipal.setVisible(true);
						}
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "" + e);
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					dispose();
				}else {
					contador++;
					if(contador >= 5) {
						JOptionPane.showMessageDialog(null, "Ops! parece que voce est� errando muito tente usar a op��o 'Esqueci minha senha'");
					}else {
						JOptionPane.showMessageDialog(null, "Login ou senha inv�lidos");
					}
				}
			}
		});
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setEnabled(false);
		lblSenha.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/Icones/login.png")));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBackground(Color.DARK_GRAY);
		lblSenha.setBounds(112, 151, 81, 29);
		contentPane.add(lblSenha);
		btnLogin.setForeground(Color.LIGHT_GRAY);
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(150, 229, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel background = new JLabel("");
		background.setBackground(Color.DARK_GRAY);
		background.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/bg2.jpg")));
		background.setBounds(0, 78, 444, 193);
		contentPane.add(background);
		
	}
}

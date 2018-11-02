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
	public TelaLoginPrincipal() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 444, 79);
		contentPane.add(panel);
		
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
		
		inputLogin = new JTextField();
		inputLogin.setBounds(150, 120, 120, 20);
		contentPane.add(inputLogin);
		inputLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setEnabled(false);
		lblSenha.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/Icones/login.png")));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBackground(Color.DARK_GRAY);
		lblSenha.setBounds(112, 151, 81, 29);
		contentPane.add(lblSenha);
		
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
							TelaLoginMDI frame = new TelaLoginMDI(/*funcionario*/);
							frame.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null, "Usuario não cadastrado. Contate o Administrador do sistema");
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
						JOptionPane.showMessageDialog(null, "Ops! parece que voce está errando muito tente usar a opção 'Esqueci minha senha'");
					}else {
						JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
					}
				}
			}
		});
		btnLogin.setForeground(Color.LIGHT_GRAY);
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(112, 226, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnEsqueciMinhaSenha = new JButton("Ajuda");
		btnEsqueciMinhaSenha.setForeground(Color.LIGHT_GRAY);
		btnEsqueciMinhaSenha.setFont(new Font("Arial", Font.BOLD, 12));
		btnEsqueciMinhaSenha.setBackground(Color.DARK_GRAY);
		btnEsqueciMinhaSenha.setBounds(211, 226, 89, 23);
		contentPane.add(btnEsqueciMinhaSenha);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setIcon(new ImageIcon(TelaLoginPrincipal.class.getResource("/bg2.jpg")));
		label_1.setBounds(0, 78, 444, 193);
		contentPane.add(label_1);
	}
}

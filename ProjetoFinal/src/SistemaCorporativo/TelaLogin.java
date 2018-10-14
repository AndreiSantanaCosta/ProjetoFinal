package SistemaCorporativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTelaDeLogin = new JLabel("Tela De Login");
		lblTelaDeLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelaDeLogin.setBounds(149, 11, 146, 22);
		contentPane.add(lblTelaDeLogin);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(135, 64, 48, 17);
		contentPane.add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(159, 88, 109, 22);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(135, 115, 48, 17);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(159, 136, 109, 22);
		contentPane.add(txtSenha);

		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contador = 0;
				if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("admin")) {
					new TelaPosLogin().setVisible(true);
					dispose();
				} else{
					JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
				}
			}
		});
		btnLogin.setBounds(117, 205, 89, 23);
		contentPane.add(btnLogin);

		JButton btnEsqueciMinhaSenha = new JButton("Esqueci minha senha");
		btnEsqueciMinhaSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEsqueciMinhaSenha.setBounds(216, 205, 178, 23);
		contentPane.add(btnEsqueciMinhaSenha);
	}
}

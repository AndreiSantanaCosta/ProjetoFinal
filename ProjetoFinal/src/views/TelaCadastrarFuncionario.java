package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarFuncionario frame = new TelaCadastrarFuncionario();
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
	public TelaCadastrarFuncionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(219, 0, 275, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Icones/user.png")));
		label.setBounds(115, 136, 64, 72);
		panel.add(label);
		
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCadastro.setForeground(Color.LIGHT_GRAY);
		lblCadastro.setBounds(115, 205, 70, 14);
		panel.add(lblCadastro);
		
		JLabel lblFuncionarios = new JLabel("FUNCIONARIOS");
		lblFuncionarios.setForeground(Color.LIGHT_GRAY);
		lblFuncionarios.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFuncionarios.setBounds(105, 219, 91, 14);
		panel.add(lblFuncionarios);
		
		JButton btnLimpar = new JButton("Limpar \r\nCampos");
		btnLimpar.setForeground(Color.LIGHT_GRAY);
		btnLimpar.setBackground(Color.DARK_GRAY);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(133, 327, 132, 33);
		panel.add(btnLimpar);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_1.setIcon(new ImageIcon(TelaCadastrarFuncionario.class.getResource("/Icones/sair-menu-2.png")));
		label_1.setBounds(243, 11, 22, 21);
		panel.add(label_1);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setForeground(Color.LIGHT_GRAY);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(Color.DARK_GRAY);
		btnRegistrar.setBounds(21, 327, 102, 33);
		panel.add(btnRegistrar);
		
		JLabel lblLogin = new JLabel("Nome:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLogin.setBounds(20, 11, 55, 14);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(30, 28, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdade.setBounds(140, 11, 55, 14);
		contentPane.add(lblIdade);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 28, 30, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(30, 75, 100, 20);
		contentPane.add(textField_2);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(20, 58, 55, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(20, 103, 55, 14);
		contentPane.add(lblRg);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(30, 120, 100, 20);
		contentPane.add(textField_3);
		
		JLabel lblPerfilFuncionrio = new JLabel("Perfil Funcion\u00E1rio:");
		lblPerfilFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPerfilFuncionrio.setBounds(20, 154, 86, 14);
		contentPane.add(lblPerfilFuncionrio);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(30, 171, 100, 20);
		contentPane.add(textField_4);
		
		JLabel lblResponsavel = new JLabel("Responsavel:");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResponsavel.setBounds(20, 202, 86, 14);
		contentPane.add(lblResponsavel);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(30, 219, 100, 20);
		contentPane.add(textField_5);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(20, 250, 55, 14);
		contentPane.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(30, 267, 150, 20);
		contentPane.add(textField_6);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenha.setBounds(20, 298, 55, 14);
		contentPane.add(lblSenha);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(30, 315, 100, 20);
		contentPane.add(textField_7);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaCorporativo.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaInformacoes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInformacoes frame = new TelaInformacoes();
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
	public TelaInformacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 292, 332);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/Icones/eleitor.png")));
		label.setBounds(107, 108, 64, 79);
		panel.add(label);
		
		JLabel lblInformaes = new JLabel("INFORMA\u00C7\u00D5ES");
		lblInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Arial", Font.BOLD, 18));
		lblInformaes.setBounds(63, 184, 149, 33);
		panel.add(lblInformaes);
		
		JLabel lblDoFuncionario = new JLabel("DO FUNCION\u00C1RIO");
		lblDoFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoFuncionario.setForeground(Color.WHITE);
		lblDoFuncionario.setFont(new Font("Arial", Font.BOLD, 18));
		lblDoFuncionario.setBounds(26, 210, 233, 27);
		panel.add(lblDoFuncionario);
		
		Funcionario funcionario = new Funcionario();
		JLabel label_1 = new JLabel("Nome: " + funcionario.getNome());
		label_1.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/icons/email.ico")));
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(301, 100, 249, 14);
		contentPane.add(label_1);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		label_7.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/Icones/sair-menu-2.png")));
		label_7.setBounds(529, 11, 22, 21);
		contentPane.add(label_7);
		
		JLabel label_2 = new JLabel("CPF: " + funcionario.getCpf());
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(301, 140, 249, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("RG: " + funcionario.getRg());
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(301, 180, 249, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("E-MAIL: " + funcionario.getEmail());
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(301, 220, 249, 17);
		contentPane.add(label_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TelaInformacoes.class.getResource("/bg2.jpg")));
		label_6.setBounds(291, 0, 270, 332);
		contentPane.add(label_6);
	}
}

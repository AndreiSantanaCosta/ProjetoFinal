package SistemaCorporativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPosLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPosLogin frame = new TelaPosLogin();
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
	// CadastrarFuncionarios funcionario = new CadastrarFuncionarios();
	public TelaPosLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbBemVindo = new JLabel("Bem Vindo(a)"/* + funcionario.getNome() */);
		lbBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbBemVindo.setBounds(26, 11, 189, 14);
		contentPane.add(lbBemVindo);

		JLabel lblVocDeseja = new JLabel("Voc\u00EA deseja:");
		lblVocDeseja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVocDeseja.setBounds(56, 69, 89, 14);
		contentPane.add(lblVocDeseja);

		JButton btnPrestarContas = new JButton("Prestar Contas");
		btnPrestarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrestacaoDeContas().setVisible(true);
				dispose();
			}
		});
		btnPrestarContas.setBounds(133, 106, 163, 23);
		contentPane.add(btnPrestarContas);

		JButton btnSolicitarReembolso = new JButton("Solicitar Reembolso");
		btnSolicitarReembolso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSolicitarReembolso.setBounds(133, 154, 163, 23);
		contentPane.add(btnSolicitarReembolso);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLogin().setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(335, 9, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAnalisarSolicitacoes = new JButton("Analisar Solicita\u00E7\u00F5es");
		btnAnalisarSolicitacoes.setBounds(133, 201, 163, 23);
		contentPane.add(btnAnalisarSolicitacoes);
	}
}

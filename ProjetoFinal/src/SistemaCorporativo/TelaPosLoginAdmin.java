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

public class TelaPosLoginAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPosLoginAdmin frame = new TelaPosLoginAdmin();
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
	
	public TelaPosLoginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bem Vindo(a)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(26, 13, 189, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Voc\u00EA deseja:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(56, 71, 89, 14);
		contentPane.add(label_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLogin().setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(335, 11, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnPrestarContas = new JButton("Prestar Contas");
		btnPrestarContas.setBounds(133, 130, 163, 23);
		contentPane.add(btnPrestarContas);
		
		JButton btnSolicitarReembolso = new JButton("Solicitar Reembolso");
		btnSolicitarReembolso.setBounds(133, 164, 163, 23);
		contentPane.add(btnSolicitarReembolso);
		
		JButton btnAnalisarSolicitacoes = new JButton("Analisar Solicita\u00E7\u00F5es");
		btnAnalisarSolicitacoes.setBounds(133, 198, 163, 23);
		contentPane.add(btnAnalisarSolicitacoes);
		
		JButton btnCadastrarFuncionrios = new JButton("Cadastrar Funcion\u00E1rios");
		btnCadastrarFuncionrios.setBounds(133, 96, 163, 23);
		contentPane.add(btnCadastrarFuncionrios);
	}

}

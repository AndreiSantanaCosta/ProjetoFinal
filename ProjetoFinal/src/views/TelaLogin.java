package views;
import SistemaCorporativo.CadastrarFuncionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaLogin extends JFrame {

	private JPanel contentPane;

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
		setSize(700, 350); /*EU QUE COLOQUEI*/
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		this.setLocationRelativeTo(null); /*EU QUE COLOQUEI*/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(51, 51, 51));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnLogin = new JMenu("Login");
		mnLogin.setForeground(new Color(204, 204, 204));
		menuBar.add(mnLogin);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnLogin.add(mntmLogin);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnLogin.add(mntmSair);
		
		JMenu mnAes = new JMenu("A\u00E7\u00F5es");
		mnAes.setForeground(new Color(204, 204, 204));
		menuBar.add(mnAes);
		
		JMenuItem mntmPrestarContas = new JMenuItem("Prestar Contas");
		mnAes.add(mntmPrestarContas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pedir Reembolso");
		mnAes.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Analisar Solicitações");
		mnAes.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CadastrarFuncionarios funcionario = new CadastrarFuncionarios(1,"Juriscleiton",29,"492301","54025","ativo","Sim","Juriscleiton@gmail.com","123");
		JMenuItem mntmBemVindoa = new JMenuItem("Bem Vindo(a) " + funcionario.getNome());
		mntmBemVindoa.setSelected(true);
		mntmBemVindoa.setBackground(new Color(51, 51, 51));
		mntmBemVindoa.setForeground(new Color(204, 204, 204));
		mntmBemVindoa.setBounds(527, 228, 168, 22);
		contentPane.add(mntmBemVindoa);
		
		JMenuBar menuBarBemVindo = new JMenuBar();
		menuBarBemVindo.setBackground(new Color(51, 51, 51));
		menuBarBemVindo.setBorderPainted(false);
		menuBarBemVindo.setBounds(970, 913, 97, 21);
		contentPane.add(menuBarBemVindo);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TelaLogin.class.getResource("/bg.png")));
		background.setBounds(0, -23, 694, 273);
		contentPane.add(background);
	}
}

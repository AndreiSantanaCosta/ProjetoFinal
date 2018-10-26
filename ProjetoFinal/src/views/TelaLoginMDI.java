package views;
import SistemaCorporativo.Funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;

public class TelaLoginMDI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginMDI frame = new TelaLoginMDI();
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
	public Object funcaoDesktop() {
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 117, 694, 333);
		contentPane.add(desktop);
		return desktop;
	}
	
	public TelaLoginMDI() {
		setTitle("Gerenciamento de Solicita\u00E7\u00F5es");
		setResizable(false);
		setSize(700, 500); /*SETA O TAMANHO DO CONTAINER*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(51, 51, 51));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnAes = new JMenu("A\u00E7\u00F5es");
		mnAes.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/paste_plain.png")));
		mnAes.setForeground(new Color(204, 204, 204));
		menuBar.add(mnAes);
		
		
		JMenuItem mntmPrestarContas = new JMenuItem("Prestar Contas");
		mntmPrestarContas.setBackground(Color.WHITE);
		mntmPrestarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmPrestarContas.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/book_open.png")));
		mnAes.add(mntmPrestarContas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pedir Reembolso");
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/money.png")));
		mnAes.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Analisar Solicitações");
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/magnifier.png")));
		mnAes.add(mntmNewMenuItem_1);
		
		JMenuItem mntmCadastrarFuncionrios = new JMenuItem("Cadastrar Funcion\u00E1rios");
		mntmCadastrarFuncionrios.setBackground(Color.WHITE);
		mntmCadastrarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrarFuncionario().setVisible(true);
			}
		});
		mntmCadastrarFuncionrios.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/vcard_add.png")));
		mnAes.add(mntmCadastrarFuncionrios);
		
		JMenu mnUsurio = new JMenu("Usu\u00E1rio");
		mnUsurio.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/user.png")));
		mnUsurio.setForeground(new Color(204, 204, 204));
		menuBar.add(mnUsurio);
		
		JMenuItem mntmInformaes = new JMenuItem("Informa\u00E7\u00F5es");
		mntmInformaes.setBackground(Color.WHITE);
		mntmInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaInformacoes().setVisible(true);;
			}
		});
		mntmInformaes.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/application_view_list.png")));
		mnUsurio.add(mntmInformaes);
		
		JMenu mnLogin = new JMenu("Finalizar");
		mnLogin.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/delete.png")));
		mnLogin.setForeground(new Color(204, 204, 204));
		menuBar.add(mnLogin);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setBackground(Color.WHITE);
		mntmSair.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/Icones/sair-menu-2.png")));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnLogin.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Funcionario funcionario = new Funcionario("aaaaa","aaaaa","aaaaaa", 1, 1, "aaaaaaa", "aaaaaa");
		
		JMenuBar menuBarBemVindo = new JMenuBar();
		menuBarBemVindo.setBackground(new Color(51, 51, 51));
		menuBarBemVindo.setBorderPainted(false);
		menuBarBemVindo.setBounds(970, 913, 97, 21);
		contentPane.add(menuBarBemVindo);
		
		JLabel iconeAcessoRapido = new JLabel("");
		iconeAcessoRapido.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/Icones/acesso-rapido.png")));
		iconeAcessoRapido.setHorizontalAlignment(SwingConstants.CENTER);
		iconeAcessoRapido.setBackground(new Color(0, 0, 0));
		iconeAcessoRapido.setBounds(0, -23, 694, 140);
		contentPane.add(iconeAcessoRapido);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 694, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		JMenuItem mntmBemVindoa = new JMenuItem("Bem Vindo(a) " + funcionario.getNome());
		mntmBemVindoa.setSelected(true);
		mntmBemVindoa.setBounds(477, 0, 217, 22);
		panel.add(mntmBemVindoa);
		mntmBemVindoa.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/user_suit.png")));
		mntmBemVindoa.setBackground(new Color(51, 51, 51));
		mntmBemVindoa.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 116, 694, 334);
		contentPane.add(panel_1);
		
		
	}
}

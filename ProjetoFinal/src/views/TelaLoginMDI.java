package views;
import SistemaCorporativo.Funcionario;
import SistemaCorporativo.PrestarContas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import DAO.contaDAO;

import javax.swing.JScrollPane;
import java.awt.Font;

public class TelaLoginMDI extends JFrame {

	private JPanel conteudoPrincipal;
	private Funcionario funcionario;
	private JTable tabela;
	private Object[][] FuncionarosContas;
	private contaDAO conta;
	int contador;
	private String[] colunas = {"Nome do funcionario", "Matricula do Funcionário", "Cargo", "Tipo da Conta", "Valor", "Status"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TelaLoginMDI frame = new TelaLoginMDI();
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
	public Object funcaoDesktop() {
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 117, 694, 333);
		conteudoPrincipal.add(desktop);
		return desktop;
	}
	
	/*public TelaLoginMDI() {
		
	}*/
	public void configuracoesTela() {
		this.funcionario = funcionario;
		setTitle("Gerenciamento de Solicita\u00E7\u00F5es");
		setResizable(false);
		setSize(700, 500); /*SETA O TAMANHO DO CONTAINER*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
	}
	
	public TelaLoginMDI(Funcionario funcionario) {
		configuracoesTela();
		
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
				new TelaPrestarContas(funcionario).setVisible(true);
			}
		});
		mntmPrestarContas.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/book_open.png")));
		mnAes.add(mntmPrestarContas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pedir Reembolso");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaReembolso().setVisible(true);;
			}
		});
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
				TelaLoginPrincipal telalogin = new TelaLoginPrincipal();
				dispose();
				telalogin.setVisible(true);
				//System.exit(0);
			}
		});
		mnLogin.add(mntmSair);
		conteudoPrincipal = new JPanel();
		conteudoPrincipal.setBackground(Color.WHITE);
		conteudoPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(conteudoPrincipal);
		conteudoPrincipal.setLayout(null);
	
		JMenuBar menuBarBemVindo = new JMenuBar();
		menuBarBemVindo.setBackground(new Color(51, 51, 51));
		menuBarBemVindo.setBorderPainted(false);
		menuBarBemVindo.setBounds(970, 913, 97, 21);
		conteudoPrincipal.add(menuBarBemVindo);
		
		JLabel iconeAcessoRapido = new JLabel("");
		iconeAcessoRapido.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/Icones/acesso-rapido.png")));
		iconeAcessoRapido.setHorizontalAlignment(SwingConstants.CENTER);
		iconeAcessoRapido.setBackground(new Color(0, 0, 0));
		iconeAcessoRapido.setBounds(0, -23, 694, 140);
		conteudoPrincipal.add(iconeAcessoRapido);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 694, 117);
		conteudoPrincipal.add(panel);
		panel.setLayout(null);
		JMenuItem mntmBemVindoa = new JMenuItem("Bem Vindo(a) " + funcionario.getNome());
		mntmBemVindoa.setBounds(477, 0, 217, 22);
		panel.add(mntmBemVindoa);
		mntmBemVindoa.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/icons 1/user_suit.png")));
		mntmBemVindoa.setBackground(new Color(51, 51, 51));
		mntmBemVindoa.setForeground(Color.WHITE);
		
		JPanel subPanel = new JPanel();
		subPanel.setBounds(0, 116, 694, 334);
		conteudoPrincipal.add(subPanel);
		subPanel.setLayout(null);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(38, 27, 615, 283);
		subPanel.add(scroll);
		
		String[] colunas = {"Nome do funcionario", "Matricula do Funcionário", "Cargo", "Tipo da Conta", "Valor", "Status"};
		Object[][] contas = carregarContas();
		tabela = new JTable(contas, colunas);
		tabela.setFont(new Font("Arial", Font.PLAIN, 13));
		scroll.setViewportView(tabela);
		tabela.setForeground(Color.WHITE);
		tabela.setBackground(Color.DARK_GRAY);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/bg2.jpg")));
		background.setBounds(0, 0, 631, 334);
		subPanel.add(background);
		
		JLabel background2 = new JLabel("");
		background2.setIcon(new ImageIcon(TelaLoginMDI.class.getResource("/bg2.jpg")));
		background2.setBounds(350, 0, 344, 334);
		subPanel.add(background2);
	}
		
	public String[][] carregarContas() {
		ArrayList<PrestarContas> listaContas = new ArrayList<PrestarContas>();
		conta = new contaDAO();
		listaContas = conta.selectContas();

		String[][] contas = new String[listaContas.size()][colunas.length];
		
		PrestarContas contaDetalhe;
		for(int i = 0; i < listaContas.size(); i++) {
			contaDetalhe = listaContas.get(i);
		
			contas[i][0] = contaDetalhe.getFuncionario().getCodigoFuncionario() +"";
			contas[i][1] = contaDetalhe.getFuncionario().getNome();
			contas[i][2] = contaDetalhe.getPerfilDescricao();
			contas[i][3] = "";
			contas[i][4] = contaDetalhe.getDespesa().getDespesaValor()+"";
			contas[i][5] = contaDetalhe.getStatusDescricao();
		}
//		
		return contas;
	}
	
	
	
	
	
	
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import DAO.contaDAO;
import DAO.despesaDAO;
import SistemaCorporativo.ContaDespesa;
import SistemaCorporativo.Funcionario;
import SistemaCorporativo.PrestarContas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Scrollbar;
import javax.swing.JRadioButton;

public class TelaPrestarContas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroDoCartao;
	private JTextField txtValorPago;
	private despesaDAO despesaD = new despesaDAO();;
	private contaDAO contaDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TelaPrestarContas frame = new TelaPrestarContas();
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
	/*public TelaPrestarContas() {
		
	}*/
	
	public TelaPrestarContas(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 575, 381);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setForeground(Color.WHITE);
		String data = calendar.getDate().toString();

		JLabel label_4 = new JLabel("Data:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(210, 11, 43, 14);
		panel_1.add(label_4);

		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem" }));
		comboCategoria.setBackground(Color.WHITE);
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboCategoria.setBounds(461, 52, 104, 20);
		panel_1.add(comboCategoria);

		JTextArea textDecricao = new JTextArea();
		textDecricao.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		textDecricao.setTabSize(6);
		textDecricao.setForeground(Color.WHITE);
		textDecricao.setBackground(Color.DARK_GRAY);
		textDecricao.setBounds(413, 115, 152, 59);
		panel_1.add(textDecricao);

		JTextArea txtDespesasLançadas = new JTextArea();
		txtDespesasLançadas.setForeground(Color.WHITE);
		txtDespesasLançadas.setBackground(Color.DARK_GRAY);
		txtDespesasLançadas.setEditable(false);
		txtDespesasLançadas.setBounds(195, 220, 370, 145);
		panel_1.add(txtDespesasLançadas);

		calendar.getYearChooser().getSpinner().setBackground(Color.DARK_GRAY);
		calendar.getMonthChooser().getComboBox().setForeground(SystemColor.windowText);
		calendar.getMonthChooser().getComboBox().setBackground(SystemColor.menu);
		calendar.getDayChooser().setBackground(Color.DARK_GRAY);
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.menu);
		calendar.setBounds(200, 36, 178, 145);
		panel_1.add(calendar);

		txtValorPago = new JTextField();
		txtValorPago.setColumns(16);
		txtValorPago.setBounds(460, 11, 105, 20);
		panel_1.add(txtValorPago);

		JLabel label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContaDespesa Cdespesa = new ContaDespesa("2018-01-01", Double.parseDouble(txtValorPago.getText()), textDecricao.getText(), (comboCategoria.getSelectedIndex()+1));
				despesaD.saveDespesaArrayList(Cdespesa);
				
				String quebraLinha = "------------FIM DO PEDIDO------------";
				txtDespesasLançadas.setText("Data: " + data + "\n Valor Pago: " + txtValorPago.getText()
						+ "\n Categoria: " + comboCategoria.getSelectedIndex() + "\n Descrição: " + Cdespesa.getDespesaDescricao() + "\n" + quebraLinha);
			}
		});
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setToolTipText("Enviar");
		label_12.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/script_add.png")));
		label_12.setBounds(479, 180, 23, 16);
		panel_1.add(label_12);

		JLabel label_10 = new JLabel("");
		label_10.setToolTipText("Limpar Campos");
		label_10.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/cancel.png")));
		label_10.setBounds(509, 182, 23, 14);
		panel_1.add(label_10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, -41, 186, 423);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Presta\u00E7\u00E3o de Contas");
		label.setBounds(10, 70, 194, 23);
		panel_2.add(label);
		label.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/book_open.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel label_1 = new JLabel("M\u00EAs de Refer\u00EAncia:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 140, 120, 14);
		panel_2.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox comboMesReferencia = new JComboBox();
		comboMesReferencia.setBounds(29, 161, 130, 20);
		panel_2.add(comboMesReferencia);
		comboMesReferencia.setBackground(Color.WHITE);
		comboMesReferencia.setModel(new DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Mar\u00E7o",
				"Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
		comboMesReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_2 = new JLabel("Numero do Cart\u00E3o:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 210, 120, 14);
		panel_2.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtNumeroDoCartao = new JTextField();
		txtNumeroDoCartao.setBounds(29, 232, 130, 20);
		panel_2.add(txtNumeroDoCartao);
		txtNumeroDoCartao.setColumns(16);
		
		JLabel lblCadastrarConta = new JLabel("Cadastrar Conta");
		lblCadastrarConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String cartao = txtNumeroDoCartao.getText();
				String contaMes = "2018-01-01";
				int codigoFunc = funcionario.getCodigoFuncionario();
				//Status da conta e nao aprovado
				int status = 2;
				//Tipo da conta e prestar conta
				int contaTipo = 1;
				PrestarContas conta = new PrestarContas(cartao, contaMes, status, codigoFunc, contaTipo);
				contaDAO = new contaDAO();
				if(contaDAO.cadastrarConta(conta) == true){
					despesaD = new despesaDAO();
					despesaD.inserirDespesa();
				}
			}
		});
		lblCadastrarConta.setForeground(Color.WHITE);
		lblCadastrarConta.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/layout_add.png")));
		lblCadastrarConta.setToolTipText("Cadastrar Conta");
		lblCadastrarConta.setBounds(29, 332, 120, 23);
		panel_2.add(lblCadastrarConta);
		
		JRadioButton rdbtnNoTenhoCarto = new JRadioButton("N\u00E3o tenho Cart\u00E3o");
		rdbtnNoTenhoCarto.setForeground(Color.WHITE);
		rdbtnNoTenhoCarto.setBackground(Color.DARK_GRAY);
		rdbtnNoTenhoCarto.setBounds(29, 259, 130, 23);
		panel_2.add(rdbtnNoTenhoCarto);

		JLabel label_5 = new JLabel("Valor Pago:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(386, 11, 76, 17);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("Categoria:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(386, 52, 76, 17);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Descri\u00E7\u00E3o:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(386, 87, 76, 17);
		panel_1.add(label_7);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/bg2.jpg")));
		label_9.setBounds(20, 0, 578, 381);
		panel_1.add(label_9);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 186, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_11 = new JLabel("");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_11.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/Icones/sair-menu-2.png")));
		label_11.setBounds(10, 11, 22, 21);
		panel.add(label_11);

		JLabel label_3 = new JLabel("Despesas");
		label_3.setBounds(320, 11, 89, 23);
		contentPane.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/bg2.jpg")));
		label_8.setBounds(186, 0, 389, 40);
		contentPane.add(label_8);
		this.setLocationRelativeTo(null); /* CENTRALIZA O CONTAINER */
	}
}

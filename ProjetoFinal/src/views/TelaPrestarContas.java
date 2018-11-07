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
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollBar;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 694, 421);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_4 = new JLabel("Data:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(235, 78, 43, 14);
		panel_1.add(label_4);

		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem" }));
		comboCategoria.setBackground(Color.WHITE);
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboCategoria.setBounds(230, 176, 130, 23);
		panel_1.add(comboCategoria);

		JTextArea textDecricao = new JTextArea();
		textDecricao.setLineWrap(true);
		textDecricao.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		textDecricao.setTabSize(6);
		textDecricao.setForeground(Color.DARK_GRAY);
		textDecricao.setBackground(Color.WHITE);
		textDecricao.setBounds(410, 103, 152, 59);
		panel_1.add(textDecricao);

		JTextArea txtDespesasLançadas = new JTextArea();
		txtDespesasLançadas.setForeground(Color.DARK_GRAY);
		txtDespesasLançadas.setBackground(Color.WHITE);
		txtDespesasLançadas.setEditable(false);
		txtDespesasLançadas.setBounds(60, 289, 502, 112);
		panel_1.add(txtDespesasLançadas);

		txtValorPago = new JTextField();
		txtValorPago.setColumns(16);
		txtValorPago.setBounds(416, 206, 146, 23);
		panel_1.add(txtValorPago);

		JLabel label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContaDespesa Cdespesa = new ContaDespesa("2018-01-01", Double.parseDouble(txtValorPago.getText()), textDecricao.getText(), (comboCategoria.getSelectedIndex()+1));
				despesaD.saveDespesaArrayList(Cdespesa);
				
				String quebraLinha = "------------FIM DO PEDIDO------------";
				txtDespesasLançadas.setText("Data: " + /*data +*/ "\n Valor Pago: " + txtValorPago.getText()
						+ "\n Categoria: " + comboCategoria.getSelectedIndex() + "\n Descrição: " + Cdespesa.getDespesaDescricao() + "\n" + quebraLinha);
			}
		});
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setToolTipText("Enviar");
		label_12.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/script_add.png")));
		label_12.setBounds(300, 228, 23, 16);
		panel_1.add(label_12);

		JLabel label_10 = new JLabel("");
		label_10.setToolTipText("Limpar Campos");
		label_10.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/cancel.png")));
		label_10.setBounds(333, 230, 23, 14);
		panel_1.add(label_10);
		
				JLabel label_1 = new JLabel("M\u00EAs de Refer\u00EAncia:");
				label_1.setBounds(50, 78, 120, 14);
				panel_1.add(label_1);
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				JComboBox comboMesReferencia = new JComboBox();
				comboMesReferencia.setBounds(60, 103, 130, 23);
				panel_1.add(comboMesReferencia);
				comboMesReferencia.setBackground(Color.WHITE);
				comboMesReferencia.setModel(new DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Mar\u00E7o",
						"Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
				comboMesReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				JLabel label_2 = new JLabel("Numero do Cart\u00E3o:");
				label_2.setBounds(50, 151, 120, 14);
				panel_1.add(label_2);
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				txtNumeroDoCartao = new JTextField();
				txtNumeroDoCartao.setBounds(60, 176, 130, 23);
				panel_1.add(txtNumeroDoCartao);
				txtNumeroDoCartao.setColumns(16);
		
		JLabel lblCadastrarConta = new JLabel("Cadastrar Conta");
		lblCadastrarConta.setBounds(267, 255, 120, 23);
		panel_1.add(lblCadastrarConta);
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
					despesaD.inserirDespesa();
				}
			}
		});
		lblCadastrarConta.setForeground(Color.WHITE);
		lblCadastrarConta.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/layout_add.png")));
		lblCadastrarConta.setToolTipText("Cadastrar Conta");
		
		JRadioButton rdbtnNaoTenhoCartao = new JRadioButton("N\u00E3o tenho Cart\u00E3o");
		rdbtnNaoTenhoCartao.setBounds(60, 206, 130, 23);
		panel_1.add(rdbtnNaoTenhoCartao);
		rdbtnNaoTenhoCartao.setForeground(Color.WHITE);
		rdbtnNaoTenhoCartao.setBackground(Color.DARK_GRAY);

		JLabel label_5 = new JLabel("Valor Pago:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(410, 179, 76, 17);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("Categoria:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(235, 148, 76, 17);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Descri\u00E7\u00E3o:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(410, 78, 76, 17);
		panel_1.add(label_7);
		
		JLabel btnSair = new JLabel("");
		btnSair.setBounds(20, 22, 22, 21);
		panel_1.add(btnSair);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/Icones/sair-menu-2.png")));
		
		JLabel icone_usuario = new JLabel("");
		icone_usuario.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/Icones/user.png")));
		icone_usuario.setBounds(300, 11, 93, 71);
		panel_1.add(icone_usuario);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(230, 103, 130, 23);
		panel_1.add(dateChooser);
		this.setLocationRelativeTo(null); /* CENTRALIZA O CONTAINER */
	}
}

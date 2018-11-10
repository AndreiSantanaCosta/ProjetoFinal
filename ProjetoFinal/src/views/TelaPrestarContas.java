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
import java.text.SimpleDateFormat;
import java.awt.SystemColor;
import java.awt.Scrollbar;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

public class TelaPrestarContas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroDoCartao;
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
		this.setLocationRelativeTo(null); /* CENTRALIZA O CONTAINER */
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 654, 421);
		contentPane.add(panel_1);

		JFormattedTextField txtValorPago = new JFormattedTextField();
		txtValorPago.setBounds(410, 206, 152, 23);
		try {
            txtValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		panel_1.setLayout(null);
		panel_1.add(txtValorPago);
		
		JLabel label_4 = new JLabel("Data:");
		label_4.setBounds(235, 78, 43, 14);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(label_4);

		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setBounds(230, 176, 130, 23);
		comboCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem" }));
		comboCategoria.setBackground(Color.WHITE);
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(comboCategoria);
		
		JScrollPane scrollPaneDados = new JScrollPane();
		scrollPaneDados.setBounds(60, 289, 502, 112);
		panel_1.add(scrollPaneDados);

		JTextArea txtDespesasLan�adas = new JTextArea();
		txtDespesasLan�adas.setRows(40);
		scrollPaneDados.setViewportView(txtDespesasLan�adas);
		txtDespesasLan�adas.setForeground(Color.DARK_GRAY);
		txtDespesasLan�adas.setBackground(Color.WHITE);
		txtDespesasLan�adas.setEditable(false);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		scrollPaneDescricao.setBounds(410, 103, 152, 59);
		panel_1.add(scrollPaneDescricao);
				
		JTextArea textDescricao = new JTextArea();
		scrollPaneDescricao.setViewportView(textDescricao);
		textDescricao.setLineWrap(true);
		textDescricao.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		textDescricao.setTabSize(6);
		textDescricao.setForeground(Color.DARK_GRAY);
		textDescricao.setBackground(Color.WHITE);
		
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
		
		JRadioButton rdbtnNaoTenhoCartao = new JRadioButton("N\u00E3o tenho Cart\u00E3o");
		rdbtnNaoTenhoCartao.setBounds(60, 206, 130, 23);
		panel_1.add(rdbtnNaoTenhoCartao);
		rdbtnNaoTenhoCartao.setForeground(Color.WHITE);
		rdbtnNaoTenhoCartao.setBackground(Color.DARK_GRAY);

		JLabel label_5 = new JLabel("Valor Pago:");
		label_5.setBounds(410, 179, 76, 17);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("Categoria:");
		label_6.setBounds(235, 148, 76, 17);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Descri\u00E7\u00E3o:");
		label_7.setBounds(410, 78, 76, 17);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		
		JDateChooser calendario = new JDateChooser();
		calendario.setBounds(230, 103, 130, 23);
		panel_1.add(calendario);
		
		JLabel icone_usuario = new JLabel("");
		icone_usuario.setBounds(300, 11, 93, 71);
		icone_usuario.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/Icones/user.png")));
		panel_1.add(icone_usuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(3, 5, 645, 412);
		panel.setBackground(Color.DARK_GRAY);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblR = new JLabel("R$");
		lblR.setBounds(562, 197, 46, 28);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblR.setForeground(Color.WHITE);
		panel.add(lblR);
		
				JLabel btnEnviar = new JLabel("");
				btnEnviar.setBounds(274, 223, 23, 16);
				panel.add(btnEnviar);
				btnEnviar.addMouseListener(new MouseAdapter() {
					String pedidos = "";
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ContaDespesa Cdespesa = new ContaDespesa("2018-01-01", Double.parseDouble(txtValorPago.getText().replace(".","")),
								textDescricao.getText(), (comboCategoria.getSelectedIndex() + 1));
						despesaD.saveDespesaArrayList(Cdespesa);
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						String data = dateFormat.format(calendario.getCalendar().getTime());
						
						String quebraLinha = "------------FIM DO PEDIDO------------";
								pedidos += ("Data: " + data + "\n Valor Pago: " + txtValorPago.getText() + "R$"
								+ "\n Categoria: " + comboCategoria.getSelectedIndex() + 1 + "\n Descri��o: "
								+ Cdespesa.getDespesaDescricao() + "\n" + quebraLinha + "\n");
								
								txtDespesasLan�adas.setText(pedidos);
						///LIMPA CAMPOS txtValorPago.setText(""); textDescricao.setText(""); txtNumeroDoCartao.setText("");
						
					}
				});
				btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnEnviar.setToolTipText("Enviar");
				btnEnviar.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/script_add.png")));
				
						JLabel btnLimparCampos = new JLabel("");
						btnLimparCampos.setBounds(303, 224, 23, 14);
						panel.add(btnLimparCampos);
						btnLimparCampos.setToolTipText("Limpar Campos");
						btnLimparCampos.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/cancel.png")));
						
								JLabel btnCadastrarConta = new JLabel("Cadastrar Conta");
								btnCadastrarConta.setBounds(235, 255, 120, 23);
								panel.add(btnCadastrarConta);
								btnCadastrarConta.setFont(new Font("Tahoma", Font.BOLD, 11));
								btnCadastrarConta.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										String cartao = txtNumeroDoCartao.getText();
										String contaMes = "2018-01-01";
										int codigoFunc = funcionario.getCodigoFuncionario();
										// Status da conta e nao aprovado
										int status = 2;
										// Tipo da conta e prestar conta
										int contaTipo = 1;
										PrestarContas conta = new PrestarContas(cartao, contaMes, status, codigoFunc, contaTipo);
										contaDAO = new contaDAO();
										if (contaDAO.cadastrarConta(conta) == true) {
											despesaD.inserirDespesa();
										}
									}
								});
								btnCadastrarConta.setForeground(Color.WHITE);
								btnCadastrarConta.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/layout_add.png")));
								btnCadastrarConta.setToolTipText("Cadastrar Conta");
		
		
	}
}

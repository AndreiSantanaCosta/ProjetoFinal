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
import javax.swing.JFormattedTextField;

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
	public void configuracoesTela(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); /* CENTRALIZA O CONTAINER */
	}
	
	public void verificaNulos(int valorPago, Object data, int numeroDoCartao, String descricao) {
		if(valorPago != 0 || data != null || numeroDoCartao != 0 || descricao != null) {
			JOptionPane.showMessageDialog(null,"nao tem nulos");
		}else if(valorPago == 0){
			
		}else if(numeroDoCartao == 0) {
			txtNumeroDoCartao.grabFocus();
		}else if(data == null) {
			
		}else if(descricao == null) {
			
		}
	}
	
	public TelaPrestarContas(Funcionario funcionario) {
		configuracoesTela();
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 694, 421);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JFormattedTextField txtValorPago = new JFormattedTextField();
		txtValorPago.setBounds(410, 206, 152, 23);
		try {
            txtValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###R$")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		int valorPago = Integer.parseInt(txtValorPago.getText().replace(".","").replace("R$",""));
		panel_1.add(txtValorPago);
		
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

		JTextArea txtDespesasLançadas = new JTextArea();
		txtDespesasLançadas.setForeground(Color.DARK_GRAY);
		txtDespesasLançadas.setBackground(Color.WHITE);
		txtDespesasLançadas.setEditable(false);
		txtDespesasLançadas.setBounds(60, 289, 502, 112);
		panel_1.add(txtDespesasLançadas);
				
		JTextArea textDescricao = new JTextArea();
		textDescricao.setLineWrap(true);
		textDescricao.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		textDescricao.setTabSize(6);
		textDescricao.setForeground(Color.DARK_GRAY);
		textDescricao.setBackground(Color.WHITE);
		textDescricao.setBounds(410, 103, 152, 59);
		panel_1.add(textDescricao);
		
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
		
		JDateChooser calendario = new JDateChooser();
		calendario.setBounds(230, 103, 130, 23);
		panel_1.add(calendario);
		
		JLabel icone_usuario = new JLabel("");
		icone_usuario.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/Icones/user.png")));
		icone_usuario.setBounds(300, 11, 93, 71);
		panel_1.add(icone_usuario);

		JLabel btnEnviar = new JLabel("");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContaDespesa Cdespesa = new ContaDespesa("2018-01-01", Double.parseDouble(txtValorPago.getText()),
						textDescricao.getText(), (comboCategoria.getSelectedIndex() + 1));
				despesaD.saveDespesaArrayList(Cdespesa);

				int valorPago = Integer.parseInt(txtValorPago.getText());
				Object data = calendario.getDate();
				int numeroDoCartao = Integer.parseInt(txtNumeroDoCartao.getText());
				String descricao = textDescricao.getText();
				
				//verificaNulos(valorPago, data, numeroDoCartao, descricao);
				
				String quebraLinha = "------------FIM DO PEDIDO------------";
				txtDespesasLançadas.setText("Data: " + data + "\n Valor Pago: " + valorPago
						+ "\n Categoria: " + comboCategoria.getSelectedIndex() + "\n Descrição: "
						+ Cdespesa.getDespesaDescricao() + "\n" + quebraLinha);
				
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviar.setToolTipText("Enviar");
		btnEnviar.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/script_add.png")));
		btnEnviar.setBounds(300, 228, 23, 16);
		panel_1.add(btnEnviar);

		JLabel btnLimparCampos = new JLabel("");
		btnLimparCampos.setToolTipText("Limpar Campos");
		btnLimparCampos.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/cancel.png")));
		btnLimparCampos.setBounds(333, 230, 23, 14);
		panel_1.add(btnLimparCampos);

		JLabel btnCadastrarConta = new JLabel("Cadastrar Conta");
		btnCadastrarConta.setBounds(267, 255, 120, 23);
		panel_1.add(btnCadastrarConta);
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

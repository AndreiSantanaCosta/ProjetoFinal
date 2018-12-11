package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import DAO.contaDAO;
import DAO.despesaDAO;
import SistemaCorporativo.ContaDespesa;
import SistemaCorporativo.Funcionario;
import SistemaCorporativo.PrestarContas;

import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class TelaReembolso extends JFrame {

	private JPanel contentPane;
	private despesaDAO despesaD = new despesaDAO();;
	private contaDAO contaDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TelaReembolso frame = new TelaReembolso();
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
	
	public TelaReembolso(Funcionario funcionario) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); /* CENTRALIZA O CONTAINER */
		
		
		JPanel background = new JPanel();
		background.setLayout(null);
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 638, 421);
		contentPane.add(background);
		
		JLabel label = new JLabel("Data:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(235, 78, 43, 14);
		background.add(label);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem"}));
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboCategoria.setBackground(Color.WHITE);
		comboCategoria.setBounds(60, 186, 130, 23);
		background.add(comboCategoria);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		scrollPaneDescricao.setBounds(410, 103, 152, 59);
		background.add(scrollPaneDescricao);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPaneDescricao.setViewportView(txtDescricao);
		txtDescricao.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		txtDescricao.setTabSize(6);
		txtDescricao.setLineWrap(true);
		txtDescricao.setForeground(Color.DARK_GRAY);
		txtDescricao.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 103, 152, 59);
		background.add(scrollPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 289, 502, 112);
		background.add(scrollPane_2);
		
		
		
		JTextArea txtContas = new JTextArea();
		scrollPane_2.setViewportView(txtContas);
		txtContas.setRows(40);
		txtContas.setForeground(Color.DARK_GRAY);
		txtContas.setEditable(false);
		txtContas.setBackground(Color.WHITE);
		
		JLabel label_3 = new JLabel("M\u00EAs de Refer\u00EAncia:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(50, 78, 120, 14);
		background.add(label_3);
		
		JComboBox comboMesReferencia = new JComboBox();
		comboMesReferencia.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMesReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboMesReferencia.setBackground(Color.WHITE);
		comboMesReferencia.setBounds(60, 103, 130, 23);
		background.add(comboMesReferencia);
		
		JLabel label_5 = new JLabel("Cadastrar Conta");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idMesReferencia = comboMesReferencia.getSelectedIndex() + 1;
				int codigoFunc = funcionario.getCodigoFuncionario();
				// Status da conta e nao aprovado
				int status = 3;
				// Tipo da conta e prestar conta
				int contaTipo = 2;
				PrestarContas conta = new PrestarContas("",idMesReferencia, status, codigoFunc, contaTipo);
				contaDAO = new contaDAO();
				if (contaDAO.cadastrarConta(conta) == true) {
					despesaD.inserirDespesa();
				}
			}
		});
		label_5.setIcon(new ImageIcon(TelaReembolso.class.getResource("/icons 1/layout_add.png")));
		label_5.setToolTipText("Cadastrar Conta");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(267, 255, 120, 23);
		background.add(label_5);
		
		JLabel label_6 = new JLabel("Valor Pago:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(230, 159, 76, 17);
		background.add(label_6);
		
		JLabel label_7 = new JLabel("Categoria:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(65, 158, 76, 17);
		background.add(label_7);
		
		JLabel label_8 = new JLabel("Descri\u00E7\u00E3o:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(410, 78, 76, 17);
		background.add(label_8);
		
		JLabel icone_sair = new JLabel("");
		icone_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		icone_sair.setIcon(new ImageIcon(TelaReembolso.class.getResource("/Icones/sair-menu-2.png")));
		icone_sair.setBounds(20, 22, 22, 21);
		background.add(icone_sair);
		
		JLabel icone_usuario = new JLabel("");
		icone_usuario.setIcon(new ImageIcon(TelaReembolso.class.getResource("/Icones/user.png")));
		icone_usuario.setBounds(300, 11, 93, 71);
		background.add(icone_usuario);
		
		JDateChooser calendario = new JDateChooser();
		calendario.setBounds(230, 103, 130, 23);
		background.add(calendario);
		
		JFormattedTextField txtValorPago = new JFormattedTextField();
		txtValorPago.setBounds(235, 186, 125, 23);
		try {
            txtValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		background.add(txtValorPago);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(4, 6, 629, 411);
		background.add(panel);
		panel.setLayout(null);
		
		JLabel lblR = new JLabel("R$");
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblR.setBounds(362, 189, 43, 14);
		panel.add(lblR);
		
		JLabel enviar = new JLabel("");
		enviar.addMouseListener(new MouseAdapter() {
			String pedidos = "";
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				String date = dt.format(calendario.getCalendar().getTime());
				ContaDespesa Cdespesa = new ContaDespesa(date, Double.parseDouble(txtValorPago.getText().replace(".","")),
						txtDescricao.getText(), (comboCategoria.getSelectedIndex() + 1));
				despesaD.saveDespesaArrayList(Cdespesa);
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String data = dateFormat.format(calendario.getCalendar().getTime());
				
				String quebraLinha = "------------FIM DO PEDIDO------------";
						pedidos += ("Data: " + data + "\n Valor Pago: " + txtValorPago.getText() + "R$"
						+ "\n Categoria: " + comboCategoria.getSelectedIndex() + 1 + "\n Descrição: "
						+ Cdespesa.getDespesaDescricao() + "\n" + quebraLinha + "\n");
						
						txtContas.setText(pedidos);
			}
		});
		enviar.setBounds(311, 224, 23, 16);
		panel.add(enviar);
		enviar.setIcon(new ImageIcon(TelaReembolso.class.getResource("/icons 1/page_add.png")));
		enviar.setToolTipText("Enviar");
		enviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
	}
}

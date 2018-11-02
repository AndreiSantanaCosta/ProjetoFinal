package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class TelaReembolso extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReembolso frame = new TelaReembolso();
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
	public TelaReembolso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, -13, 575, 421);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 40, 575, 381);
		panel.add(panel_1);
		
		JLabel btnEnviar = new JLabel("");
		btnEnviar.setIcon(new ImageIcon(TelaReembolso.class.getResource("/icons 1/script_add.png")));
		btnEnviar.setToolTipText("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviar.setBounds(463, 185, 23, 16);
		panel_1.add(btnEnviar);
		
		JLabel btnLimparCampo = new JLabel("");
		btnLimparCampo.setIcon(new ImageIcon(TelaReembolso.class.getResource("/Icones/sair-menu-2.png")));
		btnLimparCampo.setToolTipText("Limpar Campos");
		btnLimparCampo.setBounds(493, 187, 23, 14);
		panel_1.add(btnLimparCampo);
		
		JLabel label = new JLabel("Data:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(210, 11, 43, 14);
		panel_1.add(label);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem"}));
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboCategoria.setBackground(Color.WHITE);
		comboCategoria.setBounds(461, 52, 104, 20);
		panel_1.add(comboCategoria);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("Fa\u00E7a uma descri\u00E7\u00E3o sucinta.");
		textArea.setTabSize(6);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(413, 115, 152, 59);
		panel_1.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.DARK_GRAY);
		textArea_1.setBounds(195, 220, 370, 145);
		panel_1.add(textArea_1);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.menu);
		calendar.getDayChooser().setBackground(Color.DARK_GRAY);
		calendar.getYearChooser().getSpinner().setForeground(Color.WHITE);
		calendar.getYearChooser().getSpinner().setBackground(Color.DARK_GRAY);
		calendar.getMonthChooser().getComboBox().setForeground(Color.BLACK);
		calendar.getMonthChooser().getComboBox().setBackground(SystemColor.menu);
		calendar.setBounds(200, 36, 178, 145);
		panel_1.add(calendar);
		
		txtValor = new JTextField();
		txtValor.setColumns(16);
		txtValor.setBounds(460, 11, 105, 20);
		panel_1.add(txtValor);
		
		JLabel label_1 = new JLabel("");
		label_1.setToolTipText("Enviar");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(479, 180, 23, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setToolTipText("Limpar Campos");
		label_2.setBounds(509, 182, 23, 14);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, -41, 186, 423);
		panel_1.add(panel_2);
		
		JLabel lblReembolso = new JLabel("Pedido de Reembolso");
		lblReembolso.setIcon(new ImageIcon(TelaReembolso.class.getResource("/icons 1/money_add.png")));
		lblReembolso.setForeground(Color.WHITE);
		lblReembolso.setFont(new Font("Arial", Font.BOLD, 14));
		lblReembolso.setBounds(10, 70, 194, 23);
		panel_2.add(lblReembolso);
		
		JLabel label_4 = new JLabel("M\u00EAs de Refer\u00EAncia:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 140, 120, 14);
		panel_2.add(label_4);
		
		JComboBox comboMesDeReferencia = new JComboBox();
		comboMesDeReferencia.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMesDeReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboMesDeReferencia.setBackground(Color.WHITE);
		comboMesDeReferencia.setBounds(29, 161, 130, 20);
		panel_2.add(comboMesDeReferencia);
		
		JLabel lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		lblCadastrarPedido.setIcon(new ImageIcon(TelaReembolso.class.getResource("/icons 1/layout_add.png")));
		lblCadastrarPedido.setToolTipText("Cadastrar Pedido");
		lblCadastrarPedido.setForeground(Color.WHITE);
		lblCadastrarPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarPedido.setBounds(29, 332, 120, 23);
		panel_2.add(lblCadastrarPedido);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(413, 14, 43, 17);
		panel_1.add(lblValor);
		
		JLabel label_8 = new JLabel("Categoria:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(386, 52, 76, 17);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Descri\u00E7\u00E3o:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(386, 87, 76, 17);
		panel_1.add(label_9);
		
		JLabel txtDescricao = new JLabel("");
		txtDescricao.setIcon(new ImageIcon(TelaReembolso.class.getResource("/bg2.jpg")));
		txtDescricao.setBounds(20, 0, 578, 382);
		panel_1.add(txtDescricao);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 186, 40);
		panel.add(panel_3);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(10, 11, 22, 21);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Despesas");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(320, 11, 89, 23);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(TelaReembolso.class.getResource("/bg2.jpg")));
		label_13.setBounds(186, 0, 389, 40);
		panel.add(label_13);
		
	}
}

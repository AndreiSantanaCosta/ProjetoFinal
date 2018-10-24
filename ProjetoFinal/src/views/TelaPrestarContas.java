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

public class TelaPrestarContas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroDoCartao;
	private JTextField txtValorPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrestarContas frame = new TelaPrestarContas();
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
	public TelaPrestarContas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 546, 253);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_4 = new JLabel("Data:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(210, 11, 43, 14);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, -41, 186, 294);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Presta\u00E7\u00E3o de Contas");
		label.setBounds(10, 44, 194, 23);
		panel_2.add(label);
		label.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/book_open.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel label_1 = new JLabel("M\u00EAs de Refer\u00EAncia:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 110, 120, 14);
		panel_2.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboMesReferencia = new JComboBox();
		comboMesReferencia.setBounds(29, 131, 130, 20);
		panel_2.add(comboMesReferencia);
		comboMesReferencia.setBackground(Color.WHITE);
		comboMesReferencia.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMesReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("Numero do Cart\u00E3o:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 175, 120, 14);
		panel_2.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtNumeroDoCartao = new JTextField();
		txtNumeroDoCartao.setBounds(29, 197, 130, 20);
		panel_2.add(txtNumeroDoCartao);
		txtNumeroDoCartao.setColumns(16);
		
		JLabel label_12 = new JLabel("");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setToolTipText("Enviar");
		label_12.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/script_add.png")));
		label_12.setBounds(450, 180, 23, 16);
		panel_1.add(label_12);
		
		JLabel label_10 = new JLabel("");
		label_10.setToolTipText("Cancelar");
		label_10.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/icons 1/cancel.png")));
		label_10.setBounds(480, 182, 23, 14);
		panel_1.add(label_10);
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(16);
		txtValorPago.setBounds(431, 11, 105, 20);
		panel_1.add(txtValorPago);
		
		JLabel label_5 = new JLabel("Valor Pago:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(357, 11, 76, 17);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Categoria:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(357, 52, 76, 17);
		panel_1.add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem"}));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(432, 52, 104, 20);
		panel_1.add(comboBox_1);
		
		JLabel label_7 = new JLabel("Descri\u00E7\u00E3o:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(357, 87, 76, 17);
		panel_1.add(label_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(384, 115, 152, 59);
		panel_1.add(textArea);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/bg2.jpg")));
		label_9.setBounds(186, 0, 360, 253);
		panel_1.add(label_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 186, 40);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("Despesas");
		label_3.setBounds(320, 11, 89, 23);
		contentPane.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(TelaPrestarContas.class.getResource("/bg2.jpg")));
		label_8.setBounds(186, 0, 360, 40);
		contentPane.add(label_8);
		this.setLocationRelativeTo(null); /*CENTRALIZA O CONTAINER*/
	}
}

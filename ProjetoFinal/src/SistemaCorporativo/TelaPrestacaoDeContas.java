package SistemaCorporativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaPrestacaoDeContas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroDoCartao;
	private JTextField txtValorPago;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrestacaoDeContas frame = new TelaPrestacaoDeContas();
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
	public TelaPrestacaoDeContas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bem Vindo(a)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 13, 189, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLogin().setVisible(true);
				dispose();
			}
		});
		button.setBounds(319, 11, 89, 23);
		contentPane.add(button);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPosLogin().setVisible(true);
				dispose();
			}
		});
		btnRetornar.setBounds(220, 11, 89, 23);
		contentPane.add(btnRetornar);
		
		JLabel lblPrestaoDeContas = new JLabel("Presta\u00E7\u00E3o de Contas");
		lblPrestaoDeContas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrestaoDeContas.setBounds(137, 38, 138, 23);
		contentPane.add(lblPrestaoDeContas);
		
		JLabel lblMsDeReferncia = new JLabel("M\u00EAs de Refer\u00EAncia:");
		lblMsDeReferncia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsDeReferncia.setBounds(53, 73, 120, 14);
		contentPane.add(lblMsDeReferncia);
		
		JComboBox mesDeReferencia = new JComboBox();
		mesDeReferencia.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		mesDeReferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mesDeReferencia.setBounds(171, 72, 104, 20);
		contentPane.add(mesDeReferencia);
		
		JLabel lblNumeroDoCarto = new JLabel("Numero do Cart\u00E3o:");
		lblNumeroDoCarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDoCarto.setBounds(53, 110, 120, 14);
		contentPane.add(lblNumeroDoCarto);
		
		txtNumeroDoCartao = new JTextField();
		txtNumeroDoCartao.setBounds(181, 109, 130, 20);
		contentPane.add(txtNumeroDoCartao);
		txtNumeroDoCartao.setColumns(16);
		
		JLabel lblDespesas = new JLabel("Despesas");
		lblDespesas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDespesas.setBounds(171, 140, 89, 23);
		contentPane.add(lblDespesas);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 177, 43, 14);
		contentPane.add(lblData);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(46, 177, 189, 136);
		contentPane.add(calendar);
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorPago.setBounds(245, 174, 76, 17);
		contentPane.add(lblValorPago);
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(16);
		txtValorPago.setBounds(319, 174, 105, 20);
		contentPane.add(txtValorPago);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(245, 211, 76, 17);
		contentPane.add(lblCategoria);
		
		JComboBox categoria = new JComboBox();
		categoria.setModel(new DefaultComboBoxModel(new String[] {"Refei\u00E7\u00E3o", "Taxi", "Estacionamento", "Brinde", "Passagens", "Hospedagem"}));
		categoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoria.setBounds(320, 211, 104, 20);
		contentPane.add(categoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(245, 259, 76, 17);
		contentPane.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(16);
		txtDescricao.setBounds(245, 287, 179, 70);
		contentPane.add(txtDescricao);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(171, 381, 89, 23);
		contentPane.add(btnEnviar);
	}
}

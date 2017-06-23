package univel.br;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDolar = new JLabel("Dolar");
		GridBagConstraints gbc_lblDolar = new GridBagConstraints();
		gbc_lblDolar.insets = new Insets(0, 0, 5, 5);
		gbc_lblDolar.gridx = 0;
		gbc_lblDolar.gridy = 0;
		contentPane.add(lblDolar, gbc_lblDolar);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregar();
				
			}
		});
		GridBagConstraints gbc_btnCarregar = new GridBagConstraints();
		gbc_btnCarregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCarregar.gridx = 2;
		gbc_btnCarregar.gridy = 0;
		contentPane.add(btnCarregar, gbc_btnCarregar);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		table = new JTable();
		panel.add(table);
	}

	protected void carregar() {
		
		
		try {
			String url = "http://www.master10.com.py/lista-txt/download";
			LeitorProdutoUrl lpu = new LeitorProdutoUrl();
			List<Produto> lista;
			lista = lpu.lerProdutos(url);
			lista.forEach((e)-> System.out.println(e.toString()));
			
			String strDolar = textField.getText().trim();
			BigDecimal dolar= new BigDecimal (strDolar.replaceAll(",", "."));
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		modelo = new ProdutoModel(lista,dolar);
	}

}

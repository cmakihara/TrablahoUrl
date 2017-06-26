package univel.br;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;


import java.awt.Insets;
import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Tela extends JFrame {

	private JPanel contentPane;
	protected JTextField txfDolar;
	private JPanel panel;
	private ProdutoModel modelo;
	private JScrollPane scrollPane;
	protected JTable table;
	protected JButton btnCarregar;
	private JLabel lblCodigo;
	protected JTextField txfCodigo;
	private JLabel lbDesc;
	protected JTextField txfDesc;
	private JLabel lblValorD;
	protected JTextField txfPrecoD;
	private JLabel lblValorR;
	protected JTextField txfPrecoR;
	protected JButton btnAdicionar;


	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDolar = new JLabel("Cotacao do dolar");
		GridBagConstraints gbc_lblDolar = new GridBagConstraints();
		gbc_lblDolar.insets = new Insets(0, 0, 5, 5);
		gbc_lblDolar.gridx = 0;
		gbc_lblDolar.gridy = 0;
		contentPane.add(lblDolar, gbc_lblDolar);
		
		txfDolar = new JTextField();
		GridBagConstraints gbc_txfDolar = new GridBagConstraints();
		gbc_txfDolar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDolar.insets = new Insets(0, 0, 5, 5);
		gbc_txfDolar.gridx = 1;
		gbc_txfDolar.gridy = 0;
		contentPane.add(txfDolar, gbc_txfDolar);
		txfDolar.setColumns(10);
		
		btnCarregar = new JButton("Carregar");			
		GridBagConstraints gbc_btnCarregar = new GridBagConstraints();
		gbc_btnCarregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCarregar.gridx = 2;
		gbc_btnCarregar.gridy = 0;
		contentPane.add(btnCarregar, gbc_btnCarregar);
		
		btnAdicionar = new JButton("Adicionar no carrinho");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionar.gridx = 3;
		gbc_btnAdicionar.gridy = 0;
		contentPane.add(btnAdicionar, gbc_btnAdicionar);
		
		lblCodigo = new JLabel("Codigo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 1;
		contentPane.add(lblCodigo, gbc_lblCodigo);
		
		lbDesc = new JLabel("Descricao");
		GridBagConstraints gbc_lbDesc = new GridBagConstraints();
		gbc_lbDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lbDesc.gridx = 1;
		gbc_lbDesc.gridy = 1;
		contentPane.add(lbDesc, gbc_lbDesc);
		
		lblValorD = new JLabel("Valor em dolar");
		GridBagConstraints gbc_lblValorD = new GridBagConstraints();
		gbc_lblValorD.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorD.gridx = 2;
		gbc_lblValorD.gridy = 1;
		contentPane.add(lblValorD, gbc_lblValorD);
		
		lblValorR = new JLabel("Valor em real");
		GridBagConstraints gbc_lblValorR = new GridBagConstraints();
		gbc_lblValorR.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorR.gridx = 3;
		gbc_lblValorR.gridy = 1;
		contentPane.add(lblValorR, gbc_lblValorR);
		
		txfCodigo = new JTextField();
		GridBagConstraints gbc_txfCodigo = new GridBagConstraints();
		gbc_txfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCodigo.gridx = 0;
		gbc_txfCodigo.gridy = 2;
		contentPane.add(txfCodigo, gbc_txfCodigo);
		txfCodigo.setColumns(10);
		
		txfDesc = new JTextField();
		GridBagConstraints gbc_txfDesc = new GridBagConstraints();
		gbc_txfDesc.anchor = GridBagConstraints.NORTH;
		gbc_txfDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDesc.gridx = 1;
		gbc_txfDesc.gridy = 2;
		contentPane.add(txfDesc, gbc_txfDesc);
		txfDesc.setColumns(10);
		
		txfPrecoD = new JTextField();
		GridBagConstraints gbc_txfPrecoD = new GridBagConstraints();
		gbc_txfPrecoD.insets = new Insets(0, 0, 5, 5);
		gbc_txfPrecoD.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPrecoD.gridx = 2;
		gbc_txfPrecoD.gridy = 2;
		contentPane.add(txfPrecoD, gbc_txfPrecoD);
		txfPrecoD.setColumns(10);
		
		txfPrecoR = new JTextField();
		GridBagConstraints gbc_txfPrecoR = new GridBagConstraints();
		gbc_txfPrecoR.insets = new Insets(0, 0, 5, 0);
		gbc_txfPrecoR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPrecoR.gridx = 3;
		gbc_txfPrecoR.gridy = 2;
		contentPane.add(txfPrecoR, gbc_txfPrecoR);
		txfPrecoR.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}

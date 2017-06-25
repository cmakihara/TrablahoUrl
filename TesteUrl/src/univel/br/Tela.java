package univel.br;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;
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

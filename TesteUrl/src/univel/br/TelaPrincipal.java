package univel.br;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;





public class TelaPrincipal extends Tela{
	
	private Produto produtoSelecionado;
	private ProdutoModel modelo;
	public TelaPrincipal() {
		
		super();		
		carregarBotao();		
		
	}	
	
	
	
	
	
	private void carregarBotao() {
		super.btnCarregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregar();
				
			}
		});
		
	}

	
		protected void carregar() {
			
			String url = "http://www.master10.com.py/lista-txt/download";
			LeitorProdutoUrl lpu = new LeitorProdutoUrl();
			try {
				
				List<Produto> lista;
				lista = lpu.lerProdutos(url);			
				String strDolar = txfDolar.getText().trim();
				BigDecimal dolar= new BigDecimal (strDolar);
				modelo = new ProdutoModel(lista,dolar);
				super.table.setModel(modelo);
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			super.table.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						int idx = table.getSelectedRow();
						if (idx < 0) {
							System.out.println("Não há linha selecionada");
						} else {
							System.out.println("Linha " + idx);
							carregarLinha(idx);
						}
					}
				}
			});
		
		
	}



	protected void carregarLinha(int idx) {
		Produto p = this.modelo.getProduto(idx);
		this.produtoSelecionado = p;		
		String strDolar = txfDolar.getText().trim();
		BigDecimal big1 = new BigDecimal(strDolar);
		super.txfCodigo.setText(String.valueOf(p.getId()));
		super.txfDesc.setText(p.getDescricao());
		super.txfPrecoD.setText(String.valueOf(p.getValorDolar()));
		super.txfPrecoR.setText(String.valueOf(p.getValorDolar().multiply(big1)));
		
			
		}




	public static void main(String[] args) {
		try {
			
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

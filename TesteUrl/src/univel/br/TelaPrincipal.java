package univel.br;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;



public class TelaPrincipal extends Tela{
	
	private Produto selecionado;
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

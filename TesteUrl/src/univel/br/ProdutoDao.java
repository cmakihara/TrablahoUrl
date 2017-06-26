package univel.br;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class ProdutoDao {
	
	private static final String SQL_SELECT = "select * from produto;";
	private static final String SQL_INSERT = "insert into orcamento(codigo, descricao,valord,valorr)values(?, ?, ?, ?)";
	private static final String SQL_DELETE = "delete from produto where id = ?;";
	private Connection con;
	
	public ProdutoDao() {
		ConexaoDB conexao = ConexaoDB.getInstace();
		con = conexao.getConexao();
	}


	public void inserir(Produto p) {
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setLong(1, p.getId());
			ps.setString(2, p.getDescricao());
			ps.setBigDecimal(3, p.getValorDolar());
			ps.setBigDecimal(4, p.getValorDolar());
			
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

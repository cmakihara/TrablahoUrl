package univel.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoDB {
	private static ConexaoDB self;
	private Connection con;

	private ConexaoDB() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/master10", "orcamento", "sa");
			
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				
				public void run() {
					try {
						ConexaoDB.this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static synchronized ConexaoDB getInstace() {
		if (self == null) {
			self = new ConexaoDB();
		}
		
		return self;
	}
	
	public Connection getConexao() {
		return con;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Haver s� um");
	}

}

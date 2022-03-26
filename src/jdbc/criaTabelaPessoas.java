package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class criaTabelaPessoas {

	public static void main(String[] args) throws SQLException{
		Connection conexao = Conexao.getConexao();
		
		String sql = "CREATE TABLE pessoas ("
				+"codigo INT AUTO_INCREMENT PRIMARY KEY, "
				+ "nome VARCHAR(80) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Sucesso!");
		conexao.close();
	}

}

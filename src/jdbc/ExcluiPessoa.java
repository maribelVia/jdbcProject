package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluiPessoa {

	public static void main(String[] args) throws SQLException{
		Scanner sc = new Scanner(System.in);
		Connection conexao = Conexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		System.out.println("informe o Id da pessoa :");
		int id = sc.nextInt();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		
		System.out.println("Sucesso!");
		sc.close();
	}
}

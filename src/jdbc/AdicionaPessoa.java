package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdicionaPessoa {

	public static void main(String[] args) throws SQLException{
		Connection conexao = Conexao.getConexao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome : ");
		String nome = sc.nextLine();
		
		String sql = "INSERT INTO pessoas(nome) VALUES (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1,nome);
		stmt.execute();
		System.out.println("Sucesso!");
		
		sc.close();
	}

}

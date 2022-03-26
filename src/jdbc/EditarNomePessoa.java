package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
// Esta classe edita o campo nome efetuando a busca pelo id
public class EditarNomePessoa {

	public static void main(String[] args) throws SQLException{
		Scanner sc = new Scanner(System.in);
		Connection conexao = Conexao.getConexao();
		String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		System.out.println("Novo nome :");
		String novoNome = sc.nextLine();
		System.out.println("informe o Id da pessoa :");
		int id = sc.nextInt();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1,novoNome);
		stmt.setInt(2, id);
		stmt.execute();
		
		System.out.println("Sucesso!");
		
		stmt.close();
		conexao.close();
		sc.close();
	}

}

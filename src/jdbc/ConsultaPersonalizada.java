package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Esta classe verifica se a letra(s) digitada consta em algum registro do banco de dados
public class ConsultaPersonalizada {

	public static void main(String[] args) throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT * FROM pessoas where nome like ?";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Pesquisar : ");
		String busca = sc.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1,"%" + busca + "%");
		stmt.execute();
		ResultSet resultado = stmt.executeQuery();
		
		System.out.println("Sucesso!");
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p : pessoas) {
			System.out.println(p.getCodigo()+" "+ p.getNome());
		}
		
		stmt.close();
		conexao.close();
		sc.close();
	}

}

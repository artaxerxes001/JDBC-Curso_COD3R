package inserir;

import model.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Connection conexao = FabricaConexao.getConexao();

        String sql ="INSERT INTO pessoas (nome) VALUES(?)";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, nome);
        preparedStatement.execute();

        System.out.println("model.Pessoa incluida com sucesso!");
        scanner.close();


    }

}

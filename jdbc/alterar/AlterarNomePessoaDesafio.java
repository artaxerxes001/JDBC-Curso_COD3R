package alterar;

import model.FabricaConexao;
import model.Pessoa;

import java.sql.*;
import java.util.Scanner;

public class AlterarNomePessoaDesafio {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
        String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo= ?";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            Pessoa pessoa = new Pessoa(rs.getInt(1), rs.getString(2));
            scanner.nextLine();
            System.out.println("Nome atual: " + pessoa.getNome());
            System.out.print("Digite o Nome a atualizar: ");
            String nome = scanner.nextLine();

            preparedStatement = conexao.prepareStatement(updateSQL);
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

            System.out.println("Atualização feita com sucesso");

        }else {
            System.out.println("model.Pessoa não existe");
        }
        conexao.close();

    }
}

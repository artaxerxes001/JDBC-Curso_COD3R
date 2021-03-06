package consulta;

import model.FabricaConexao;
import model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CosultarPessoasDesafio {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Buscar: ");
        String busca = scanner.nextLine();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        preparedStatement.setString(1,"%"+ busca+"%");
        Statement st = conexao.createStatement();
        ResultSet resultado = preparedStatement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        preparedStatement.close();
        conexao.close();
    }
}

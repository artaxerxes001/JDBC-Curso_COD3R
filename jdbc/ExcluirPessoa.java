import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID: ");
        int codigo = scanner.nextInt();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1,codigo);

//        executeUpdate() mostra o numero de linhas afetadas
        int contador = preparedStatement.executeUpdate();

        if (contador > 0){
            System.out.println("Pessoa excluida com sucesso!");
        }else {
            System.out.println("Nada feito!");
        }

        System.out.println("linhas afetadas: " +contador);

        scanner.close();
        conexao.close();
    }
}

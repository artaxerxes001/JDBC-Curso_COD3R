import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
    public static Connection getConexao() {
        try {
            Properties properties = getProperties();
            final String url = properties.getProperty("banco.url");
            final String usuario = properties.getProperty("banco.usuario");
            final String senha = properties.getProperty("banco.senha");

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String caminho = "/conexao.properties";
        properties.load(FabricaConexao.class.getResourceAsStream(caminho));
        return properties;
    }
}

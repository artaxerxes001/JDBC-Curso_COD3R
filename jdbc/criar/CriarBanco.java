package criar;

import model.FabricaConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {


/*
        final String url = "jdbc:mysql://localhost?verifyServerCertificste=false&useSSL=true";
        final String usuario = "root";
        final String senha = "Capricornioesmeralda#1";

*/
        Connection conexao = FabricaConexao.getConexao();

        Statement st = conexao.createStatement();
        st.execute("CREATE DATABASE IF NOT EXISTS curso_java");
        System.out.println("Banco criado com sucesso!!!");

        conexao.close();
    }
}

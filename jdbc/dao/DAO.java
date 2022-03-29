package dao;

import model.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private Connection conexao;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement preparedStatement = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            adicionarAtributos(preparedStatement, atributos);

            if ( preparedStatement.executeUpdate() > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    return  rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void adicionarAtributos(PreparedStatement preparedStatement, Object[] atributos) throws SQLException {
        int indece = 1;
        for (Object atributo :
                atributos) {
            if (atributo instanceof String) {
                preparedStatement.setString(indece, (String) atributo);
            } else if (atributo instanceof Integer) {
                preparedStatement.setInt(indece, (Integer) atributo);
            }
        }
    }

    private Connection getConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {

        }
        conexao = FabricaConexao.getConexao();
        return conexao;
    }
}

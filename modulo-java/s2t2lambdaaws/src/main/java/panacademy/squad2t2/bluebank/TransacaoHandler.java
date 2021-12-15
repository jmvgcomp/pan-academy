package panacademy.squad2t2.bluebank;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import panacademy.squad2t2.bluebank.model.Transacao;
import panacademy.squad2t2.bluebank.s3.UploadS3;

import java.sql.*;

import static panacademy.squad2t2.bluebank.config.DbConfig.*;


public class TransacaoHandler implements RequestHandler<Integer, Transacao> {

    UploadS3 UploadS3 = new UploadS3();

    @Override
    public Transacao handleRequest(Integer id, Context context) {
        Transacao transacao = getDetalhesTransacao(id);
        if (transacao != null) {
            return UploadS3.carregamentoS3(transacao);
        }
        return null;
    }

    public Transacao getDetalhesTransacao(Integer id) {
        try {
            Connection connection = conexaoMySQL();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_transacao " +
                    "INNER JOIN tb_usuario ON tb_transacao.conta_id = tb_usuario.conta_id " +
                    "WHERE tb_transacao.id =" + id);

            ResultSet resultSet = statement.executeQuery();
            Transacao transacao = new Transacao();
            while (resultSet.next()) {
                transacao.setId(resultSet.getLong(1));
                transacao.setTipoTransacao(resultSet.getString(2));
                transacao.setDataTransacao(resultSet.getTimestamp(3));
                transacao.setDescricao(resultSet.getString(4));
                transacao.setValor(resultSet.getDouble(5));
                transacao.setContaOrigem(resultSet.getLong(6));
                transacao.setContaDestino(resultSet.getLong(7));
                transacao.setClienteOrigem(resultSet.getString(10) + " " + resultSet.getString(11));
            }
            return transacao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection conexaoMySQL() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

    }

}

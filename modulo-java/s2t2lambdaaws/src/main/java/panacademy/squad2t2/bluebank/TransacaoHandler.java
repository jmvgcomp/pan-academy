package panacademy.squad2t2.bluebank;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import panacademy.squad2t2.bluebank.model.Transacao;
import panacademy.squad2t2.bluebank.s3.UploadS3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TransacaoHandler implements RequestHandler<Integer, Transacao> {

    private static final String DB_URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    UploadS3 UploadS3 = new UploadS3();

    @Override
    public Transacao handleRequest(Integer id, Context context) {
        Transacao transacao = getDetalhesTransacao(id);
        if (transacao != null) {
            UploadS3.carregamentoS3(transacao);
        }
        return transacao;
    }


    public Transacao getDetalhesTransacao(Integer id) {
        try {
            Connection connection = conexaoMySQL();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_transacao " +
                    "INNER JOIN tb_cliente ON tb_transacao.conta_id = tb_cliente.conta_id " +
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
                transacao.setClienteOrigem(resultSet.getString(9) + " " + resultSet.getString(10));
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

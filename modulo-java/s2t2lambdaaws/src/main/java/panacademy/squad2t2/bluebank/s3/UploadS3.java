package panacademy.squad2t2.bluebank.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import panacademy.squad2t2.bluebank.model.Transacao;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

import static panacademy.squad2t2.bluebank.config.S3Config.*;

public class UploadS3 {

    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(REGION).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

    public Transacao carregamentoS3(Transacao transacao){
        try{
            String fileName = "comprovante-"+Instant.now()+".txt";

            StringBuilder stringBuilder = new StringBuilder();
            NumberFormat realFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            stringBuilder.append("========COMPROVANTE========\n");
            stringBuilder.append("BLUEBANK\n");
            stringBuilder.append("ID: ").append(transacao.getId()).append("\n");
            stringBuilder.append("Cliente: ").append(transacao.getClienteOrigem()).append("\n");
            stringBuilder.append("Conta: ").append(transacao.getContaOrigem()).append("\n");
            stringBuilder.append("Transação: ").append(transacao.getTipoTransacao()).append("\n");
            stringBuilder.append("Data: ").append(transacao.getDataTransacao()).append("\n");
            if(transacao.getContaDestino() != 0){
                stringBuilder.append("Conta de destino: ").append(transacao.getContaDestino()).append("\n");
            }
            stringBuilder.append("Valor: ").append(realFormat.format(transacao.getValor())).append("\n");
            stringBuilder.append("====").append(UUID.randomUUID()).append("====");

            ByteArrayInputStream inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            s3client.putObject(BUCKET_NAME, fileName, inputStream, new ObjectMetadata());
            transacao.setUrl(s3client.getUrl(BUCKET_NAME, fileName).toString());
            return transacao;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

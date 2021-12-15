package panacademy.squad2t2.bluebank.model;

import java.util.Date;
import java.util.Objects;

public class Transacao {
    private Long id;
    private String tipoTransacao;
    private Date dataTransacao;
    private String descricao;
    private Double valor;
    private Long contaOrigem;
    private Long contaDestino;
    private String clienteOrigem;
    private String url;


    public Transacao() {
    }

    public Transacao(Long id, String tipoTransacao, Date dataTransacao, String descricao, Double valor, Long contaOrigem, Long contaDestino, String clienteOrigem, String url) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.clienteOrigem = clienteOrigem;
        this.url = url;
    }

    public Transacao(Long id, String tipoTransacao, Date dataTransacao, String descricao, Double valor, Long contaOrigem, Long contaDestino, String clienteOrigem) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.clienteOrigem = clienteOrigem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return id.equals(transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getClienteOrigem() {
        return clienteOrigem;
    }

    public void setClienteOrigem(String clienteOrigem) {
        this.clienteOrigem = clienteOrigem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {

        return "Transacao{" +
                "id=" + id +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", dataTransacao=" + dataTransacao +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", clienteOrigem='" + clienteOrigem + '\'' +
                '}';
    }
}

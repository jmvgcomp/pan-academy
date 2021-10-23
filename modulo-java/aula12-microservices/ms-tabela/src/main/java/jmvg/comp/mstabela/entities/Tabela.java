package jmvg.comp.mstabela.entities;

import javax.persistence.*;

@Entity
@Table(name = "mstabela")
public class Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pessoa;
    private Double preco;

    public Tabela() {
    }

    public Tabela(Long id, String pessoa, Double preco) {
        this.id = id;
        this.pessoa = pessoa;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

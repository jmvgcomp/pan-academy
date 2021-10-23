package exercicio1;

import javax.swing.*;

public class Livro extends Produto{

    public Livro(int codigo, double preco, String descricao) {
        super(codigo, preco, descricao);
    }

    public void exibirDados(){
       JOptionPane.showMessageDialog(null, super.toString());
    }
}

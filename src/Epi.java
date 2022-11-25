import javax.swing.*;
import java.time.LocalDate;



public class Epi implements Comparable<Epi> {

    public String categoria;
    public int ca;
    public String descricao;
    public LocalDate validadeCa;
    public float quantidade;
    private JTextField recebeDescricaoEpi;
    private JTextField recebeCA;
    private JTextField recebeCategoria;
    private JTextField recebeQuantidade;


    public Epi(String categoria, int ca, String descricao, int quantidadeInicial, LocalDate validadeCa) {
        setCategoria(categoria);
        setCa(ca);
        setQuantidade(quantidadeInicial);
        setDescricao(descricao);
        setValidadeCa(validadeCa);
    }

    @Override
    public String toString() {
        return "Categoria: " + getCategoria() + ", Descrição: " + getDescricao() +
                ", C.A: " + getCa() + ", Quantidade atual em estoque: " + getQuantidade() +
                ", Validade C.A.: " + getValidadeCa();
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getValidadeCa() {
        return validadeCa;
    }

    public void setValidadeCa(LocalDate validadeCa) {
        this.validadeCa = validadeCa;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    //Definindo a ordem natural da Classe EPI
    @Override
    public int compareTo(Epi outra) {
        return Integer.compare(this.ca, outra.ca);
    }
}

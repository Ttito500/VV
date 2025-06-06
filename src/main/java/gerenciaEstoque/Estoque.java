package gerenciaEstoque;

public interface Estoque {
    public boolean temProdutoNoEstoque(String nomeProduto, int quantidade);
    public void removerProduto(String nome, int quantidade);
}

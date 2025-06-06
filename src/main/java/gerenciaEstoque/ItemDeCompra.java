package gerenciaEstoque;

public class ItemDeCompra {
    String nomeProduto;
    int quantidade;
    Estoque estoque;

    public ItemDeCompra(String nomeProduto, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public void defineEstoqueDeCompra(Estoque estoque){
        this.estoque = estoque;
    }

    public boolean estaAtendida(){
        if (estoque.temProdutoNoEstoque(this.nomeProduto, this.quantidade)){
            estoque.removerProduto(this.nomeProduto, this.quantidade);
            return true;
        }
        return false;
    }
}

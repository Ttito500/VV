import gerenciaEstoque.Estoque;
import gerenciaEstoque.ItemDeCompra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class ItemDeCompraTest {
    Estoque estoque;
    private ItemDeCompra itemDeCompra;

    @BeforeEach
    void setUp(){
        //stub
        estoque = Mockito.mock(Estoque.class);
        //configuara conta com saldo 50
        Mockito.when(estoque.temProdutoNoEstoque(Mockito.anyString(), Mockito.anyInt())).thenReturn(true);

        itemDeCompra = new ItemDeCompra("arroz", 5);
    }

/*    @Test
    void testaAtendidaSTUB() {
        boolean resultado = itemDeCompra.estaAtendida();

        assertTrue(resultado);
    }*/

    @Test
    void testaAtendidaSTUB(){
        int quantidadeEstoque = 5;
        int quantidadeAComprar = 10;
        estoque = Mockito.mock(Estoque.class);
        Mockito.when(estoque.temProdutoNoEstoque(Mockito.anyString(), Mockito.anyInt())).thenReturn((quantidadeEstoque-quantidadeAComprar)>=0);


        itemDeCompra = new ItemDeCompra("arroz", 5);

        boolean resultado = itemDeCompra.estaAtendida();

        assertTrue(resultado);
    }

    @Test
    void testaAtendidaMOCK(){
        int quantidadeEstoque = 10;
        int quantidadeDeCompra = 5;

        Mockito.when(estoque.temProdutoNoEstoque(Mockito.anyString(), Mockito.anyInt())).thenReturn((quantidadeEstoque - quantidadeDeCompra) >= 0);

        ArgumentCaptor<String> nomeProduto = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> quantidade = ArgumentCaptor.forClass(Integer.class);

        Mockito.doNothing().when(estoque).removerProduto(nomeProduto.capture(), quantidade.capture());

        ItemDeCompra item = new ItemDeCompra("arroz", quantidadeDeCompra);
        item.defineEstoqueDeCompra(estoque);


        item.estaAtendida(); //poderia guardar para dar o assert, mas esse n é o foco do mock
        assertEquals("arroz", nomeProduto);
        assertEquals(quantidadeDeCompra, quantidade.getValue().intValue());
        verify(estoque, Mockito.times(1)).removerProduto(Mockito.anyString(), Mockito.anyInt());
    }

}

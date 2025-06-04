//feito para teste de stubs, SUT = Transacao
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TransacaoTest {

    private Transacao transacao;
    private Conta conta;

    @BeforeEach
    void setUp(){
        transacao = new Transacao();
        //stub
        conta = Mockito.mock(Conta.class);
        //configuara conta com saldo 50
        Mockito.when(conta.leSaldo()).thenReturn(50);
    }

    @Test
    @DisplayName("Teste de saque: não pode tirar mais que tem")
    void testeSaque(){
        boolean resultadoEncontrado = transacao.saca(conta, 10);

        assertTrue(resultadoEncontrado);
    }

    @Test
    @DisplayName("Teste de saque: não pode tirar mais que tem")
    void testeSaqueComSaldoInsuficiente(){
        boolean resultadoEncontrado = transacao.saca(conta, 60);

        assertFalse(resultadoEncontrado);
    }

    @Test
    @DisplayName("Teste mock de saque")
    void testeSaqueComSaldoSuficienteMock(){
        ArgumentCaptor<Integer> valorSaque = ArgumentCaptor.forClass(Integer.class);
        Mockito.doNothing().when(conta).removeSaldo(valorSaque.capture());

        transacao.saca(conta, 50);

        assertEquals(50, valorSaque.getValue().intValue());
    }

    @Test
    @DisplayName("Teste de depósito: não pode depositar um valor negativo")
    void testeDeposito(){
        boolean resultadoEncontrado = transacao.deposita(conta, 20);

        assertTrue(resultadoEncontrado);
    }



}

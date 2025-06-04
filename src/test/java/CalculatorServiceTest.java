import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach // Este método é executado antes de cada teste
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test // Marca um método como um teste
    @DisplayName("Teste de soma: deve retornar a soma correta de dois números") // Nome descritivo para o teste
    void testAdd() {
        // Given (Dado)
        int a = 5;
        int b = 3;

        // When (Quando)
        int result = calculatorService.add(a, b);

        // Then (Então)
        assertEquals(8, result); // Verifica se o resultado é o esperado
    }

    @Test
    @DisplayName("Teste de subtração: deve retornar a diferença correta de dois números")
    void testSubtract() {
        // Given
        int a = 10;
        int b = 4;

        // When
        int result = calculatorService.subtract(a, b);

        // Then
        assertEquals(6, result);
    }
}
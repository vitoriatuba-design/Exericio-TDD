import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervaloTest {

    @Test
    void deveCriarIntervaloComHorasMinutosESegundos() {
        Intervalo intervalo = new Intervalo(1, 30, 20);

        assertEquals(1, intervalo.getHoras());
    }

    @Test
    void deveRetornarOsMinutosDoIntervalo() {
        Intervalo intervalo = new Intervalo(2, 40, 10);

        assertEquals(40, intervalo.getMinutos());
    }
    @Test
    void deveRetornarOsSegundosDoIntervalo() {
        Intervalo intervalo = new Intervalo(2, 40, 10);

        assertEquals(10, intervalo.getSegundos());
    }
    @Test
    void deveRetornarTotalDeMinutos() {
        Intervalo intervalo = new Intervalo(2, 40, 10);

        assertEquals(160, intervalo.getTotalMinutos());
    }
    @Test
    void deveRetornarTotalDeSegundos() {
        Intervalo intervalo = new Intervalo(2, 40, 10);

        assertEquals(9610, intervalo.getTotalSegundos());
    }
}
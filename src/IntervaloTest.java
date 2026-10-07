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
    @Test
    void deveAceitarMinutosESegundosAcimaDe59() {
        Intervalo intervalo = new Intervalo(1, 70, 80);

        assertEquals(2, intervalo.getHoras());
        assertEquals(11, intervalo.getMinutos());
        assertEquals(20, intervalo.getSegundos());
    }
    @Test
    void deveSomarDoisIntervalos() {
        Intervalo intervalo1 = new Intervalo(0, 0, 10);
        Intervalo intervalo2 = new Intervalo(0, 0, 15);

        Intervalo resultado = intervalo1.somar(intervalo2);

        assertEquals(25, resultado.getTotalSegundos());
    }
}
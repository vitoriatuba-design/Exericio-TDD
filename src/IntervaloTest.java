import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervaloTest {

    @Test
    void deveCriarIntervaloComHorasMinutosESegundos() {
        Intervalo intervalo = new Intervalo(1, 30, 20);

        assertEquals(1, intervalo.getHoras());
    }
}
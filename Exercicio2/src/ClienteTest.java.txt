import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteTest {

    @Test
    void deveCriarClienteComNomeCpfEDataNascimento() {

        LocalDate dataNascimento = LocalDate.of(2000, 5, 10);

        Cliente cliente = new Cliente(
                "Joao",
                "529.982.247-25",
                dataNascimento
        );

        assertEquals("Joao", cliente.getNome());
        assertEquals("529.982.247-25", cliente.getCpf());
        assertEquals(dataNascimento, cliente.getDataNascimento());
    }

    @Test
    void deveRejeitarCpfComFormatoInvalido() {

        assertThrows(
                ClienteException.class,
                () -> new Cliente(
                        "Joao",
                        "52998224725",
                        LocalDate.of(2000, 5, 10)
                )
        );
    }

    @Test
    void deveRejeitarNomeComCaracteresNaoAlfabeticos() {

        assertThrows(
                ClienteException.class,
                () -> new Cliente(
                        "Joao123",
                        "529.982.247-25",
                        LocalDate.of(2000, 5, 10)
                )
        );
    }

    @Test
    void deveRejeitarCpfInvalido() {

        assertThrows(
                ClienteException.class,
                () -> new Cliente(
                        "Joao",
                        "111.111.111-11",
                        LocalDate.of(2000, 5, 10)
                )
        );
    }

    @Test
    void deveRejeitarDataAnteriorOuIgualA1900() {

        assertThrows(
                ClienteException.class,
                () -> new Cliente(
                        "Joao",
                        "529.982.247-25",
                        LocalDate.of(1900, 1, 1)
                )
        );
    }

    @Test
    void deveRejeitarDataFutura() {

        assertThrows(
                ClienteException.class,
                () -> new Cliente(
                        "Joao",
                        "529.982.247-25",
                        LocalDate.now().plusDays(1)
                )
        );
    }
}
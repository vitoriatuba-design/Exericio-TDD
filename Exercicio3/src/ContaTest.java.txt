import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaTest {

    @Test
    void deveCriarConta() {

        Conta conta = new Conta(100, 50);

        assertEquals(100, conta.getSaldo());
        assertEquals(50, conta.getLimite());
    }

    @Test
    void deveSacarValorDaConta() {

        Conta conta = new Conta(100, 50);

        double valorSacado = conta.sacar(30);

        assertEquals(30, valorSacado);
        assertEquals(70, conta.getSaldo());
    }

    @Test
    void naoDevePermitirSaqueNegativo() {

        Conta conta = new Conta(100, 50);

        assertThrows(
                ContaException.class,
                () -> conta.sacar(-10)
        );
    }

    @Test
    void deveRetornarZeroQuandoSaqueExcederSaldoMaisLimite() {

        Conta conta = new Conta(100, 50);

        assertEquals(0, conta.sacar(151));
        assertEquals(100, conta.getSaldo());
    }

    @Test
    void deveDepositarValorPositivo() {

        Conta conta = new Conta(100, 50);

        double saldoFinal = conta.depositar(30);

        assertEquals(130, saldoFinal);
        assertEquals(130, conta.getSaldo());
    }

    @Test
    void naoDevePermitirDepositoNegativo() {

        Conta conta = new Conta(100, 50);

        assertThrows(
                ContaException.class,
                () -> conta.depositar(-10)
        );
    }

    @Test
    void deveAlterarLimite() {

        Conta conta = new Conta(100, 50);

        conta.alterarLimite(200);

        assertEquals(200, conta.getLimite());
    }

    @Test
    void naoDevePermitirLimiteNegativo() {

        Conta conta = new Conta(100, 50);

        assertThrows(
                ContaException.class,
                () -> conta.alterarLimite(-1)
        );
    }

    @Test
    void deveTransferirValorParaOutraConta() {

        Conta origem = new Conta(100, 50);
        Conta destino = new Conta(50, 20);

        origem.transferir(30, destino);

        assertEquals(70, origem.getSaldo());
        assertEquals(80, destino.getSaldo());
    }

    @Test
    void naoDeveTransferirValorNegativo() {

        Conta origem = new Conta(100, 50);
        Conta destino = new Conta(50, 20);

        assertThrows(
                ContaException.class,
                () -> origem.transferir(-10, destino)
        );
    }

    @Test
    void naoDeveTransferirParaContaNula() {

        Conta origem = new Conta(100, 50);

        assertThrows(
                ContaException.class,
                () -> origem.transferir(10, null)
        );
    }

    @Test
    void naoDeveTransferirQuandoValorForMaiorQueSaldoMaisLimite() {

        Conta origem = new Conta(100, 50);
        Conta destino = new Conta(50, 20);

        assertThrows(
                ContaException.class,
                () -> origem.transferir(151, destino)
        );
    }
}
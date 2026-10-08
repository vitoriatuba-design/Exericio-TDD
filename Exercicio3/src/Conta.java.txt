public class Conta {

    private double saldo;
    private double limite;

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    public double sacar(double valor) {

        if (valor <= 0) {
            throw new ContaException(
                    "O valor do saque deve ser positivo."
            );
        }

        if (valor > saldo + limite) {
            return 0;
        }

        saldo -= valor;

        return valor;
    }

    public double depositar(double valor) {

        if (valor <= 0) {
            throw new ContaException(
                    "O valor do depósito deve ser positivo."
            );
        }

        saldo += valor;

        return saldo;
    }

    public void alterarLimite(double novoLimite) {

        if (novoLimite < 0) {
            throw new ContaException(
                    "O limite não pode ser negativo."
            );
        }

        limite = novoLimite;
    }

    public void transferir(double valor, Conta destino) {

        if (valor <= 0) {
            throw new ContaException(
                    "O valor da transferência deve ser positivo."
            );
        }

        if (destino == null) {
            throw new ContaException(
                    "A conta de destino não pode ser nula."
            );
        }

        if (valor > saldo + limite) {
            throw new ContaException(
                    "Saldo e limite insuficientes."
            );
        }

        sacar(valor);
        destino.depositar(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }
}
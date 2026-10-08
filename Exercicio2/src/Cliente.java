import java.time.LocalDate;

public class Cliente {

    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;

    public Cliente(
            String nome,
            String cpf,
            LocalDate dataNascimento) {

        if (!nome.matches("[\\p{L} ]+")) {
            throw new ClienteException(
                    "Nome deve possuir somente caracteres alfabéticos."
            );
        }

        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new ClienteException(
                    "CPF com formato inválido."
            );
        }

        if (!cpfValido(cpf)) {
            throw new ClienteException(
                    "CPF inválido."
            );
        }

        LocalDate limite = LocalDate.of(1900, 1, 1);

        if (!dataNascimento.isAfter(limite)
                || !dataNascimento.isBefore(LocalDate.now())) {

            throw new ClienteException(
                    "Data de nascimento inválida."
            );
        }

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    private boolean cpfValido(String cpf) {

        String numeros = cpf.replaceAll("\\D", "");

        if (numeros.length() != 11) {
            return false;
        }

        if (numeros.chars().distinct().count() == 1) {
            return false;
        }

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(numeros.charAt(i))
                    * (10 - i);
        }

        int primeiroDigito = (soma * 10) % 11;

        if (primeiroDigito == 10) {
            primeiroDigito = 0;
        }

        if (primeiroDigito
                != Character.getNumericValue(numeros.charAt(9))) {
            return false;
        }

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(numeros.charAt(i))
                    * (11 - i);
        }

        int segundoDigito = (soma * 10) % 11;

        if (segundoDigito == 10) {
            segundoDigito = 0;
        }

        return segundoDigito
                == Character.getNumericValue(numeros.charAt(10));
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
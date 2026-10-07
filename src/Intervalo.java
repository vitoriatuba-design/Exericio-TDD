public class Intervalo {

    private int totalSegundos;

    public Intervalo(int horas, int minutos, int segundos) {
        this.totalSegundos =
                horas * 60 * 60 +
                        minutos * 60 +
                        segundos;
    }

    public int getHoras() {
        return totalSegundos / 3600;
    }

    public int getMinutos() {
        return (totalSegundos % 3600) / 60;
    }

    public int getSegundos() {
        return totalSegundos % 60;
    }

    public int getTotalMinutos() {
        return totalSegundos / 60;
    }

    public int getTotalSegundos() {
        return totalSegundos;
    }
    public Intervalo somar(Intervalo outro) {
        return new Intervalo(
                this.totalSegundos + outro.totalSegundos
        );
    }
    private Intervalo(int totalSegundos) {
        this.totalSegundos = totalSegundos;
    }
    public Intervalo subtrair(Intervalo outro) {

        if (outro.totalSegundos > this.totalSegundos) {
            throw new IntervaloException(
                    "O intervalo não pode ser negativo."
            );
        }

        return new Intervalo(
                this.totalSegundos - outro.totalSegundos
        );
    }
    public class IntervaloException extends RuntimeException {

        public IntervaloException(String mensagem) {
            super(mensagem);
        }
    }

}
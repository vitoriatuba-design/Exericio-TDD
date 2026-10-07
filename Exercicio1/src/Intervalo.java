public class Intervalo {

    private final int totalSegundos;

    public Intervalo(int horas, int minutos, int segundos) {
        this.totalSegundos =
                horas * 3600 +
                        minutos * 60 +
                        segundos;
    }

    private Intervalo(int totalSegundos) {
        this.totalSegundos = totalSegundos;
    }

    public int getHoras() {
        return totalSegundos / 3600;
    }

    public int getMinutos() {
        return (totalSegundos % 3600) / 60;
    }

    public int getTotalMinutos() {
        return totalSegundos / 60;
    }

    public int getSegundos() {
        return totalSegundos % 60;
    }

    public int getTotalSegundos() {
        return totalSegundos;
    }

    public Intervalo somar(Intervalo outro) {
        return new Intervalo(
                this.totalSegundos + outro.totalSegundos
        );
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

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Intervalo)) {
            return false;
        }

        Intervalo outro = (Intervalo) objeto;

        return this.totalSegundos == outro.totalSegundos;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(totalSegundos);
    }

    @Override
    public String toString() {
        return String.format(
                "%02d:%02d:%02d",
                getHoras(),
                getMinutos(),
                getSegundos()
        );
    }
}

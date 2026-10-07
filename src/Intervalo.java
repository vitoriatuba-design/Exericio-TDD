public class Intervalo {

    private int horas;
    private int minutos;
    private int segundos;

    public Intervalo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    public int getTotalMinutos() {
    return horas * 60 + minutos;
}
}
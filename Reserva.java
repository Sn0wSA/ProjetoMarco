import java.time.LocalDate;

public class Reserva {
    private String nomeHotel;
    private int numeroQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(int codigoReserva, String nomeHotel, int numeroQuarto, String checkIn, String checkOut) {
        this.nomeHotel = nomeHotel;
        this.numeroQuarto = numeroQuarto;
        this.checkIn = parseData(checkIn);
        this.checkOut = parseData(checkOut);
    }

    private LocalDate parseData(String data) {
        String[] partes = data.split("-");
        int ano = Integer.parseInt(partes[0]);
        int mes = partes.length > 1 ? Integer.parseInt(partes[1]) : 1; // Preenche com 1 se o mês não for fornecido
        int dia = partes.length > 2 ? Integer.parseInt(partes[2]) : 1; // Preenche com 1 se o dia não for fornecido
        return LocalDate.of(ano, mes, dia);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nomeHotel='" + nomeHotel + '\'' +
                ", numeroQuarto=" + numeroQuarto +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}

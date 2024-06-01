import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Hotel {
    public static void main(String[] args) {
        MeuHashMap<Integer, Reserva> sistemaReservas = new MeuHashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Loop para inserir, visualizar, remover e procurar reservas até que o usuário decida sair
        while (true) {
            System.out.println("Opções:");
            System.out.println("1. Inserir nova reserva");
            System.out.println("2. Ver todas as reservas");
            System.out.println("3. Procurar reserva pelo código");
            System.out.println("4. Remover reserva");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    inserirReserva(sistemaReservas, scanner);
                    break;
                case 2:
                    verTodasReservas(sistemaReservas);
                    break;
                case 3:
                    procurarReserva(sistemaReservas, scanner);
                    break;
                case 4:
                    removerReserva(sistemaReservas, scanner);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void inserirReserva(MeuHashMap<Integer, Reserva> sistemaReservas, Scanner scanner) {
        System.out.println("Inserir nova reserva:");
        System.out.print("Nome do hotel: ");
        String nomeHotel = scanner.nextLine();
        System.out.print("Número do quarto: ");
        int numeroQuarto = Integer.parseInt(scanner.nextLine());

        String checkIn;
        do {
            System.out.print("Data de check-in (yyyy-mm-dd): ");
            checkIn = scanner.nextLine();
            if (!validarData(checkIn)) {
                System.out.println("Data de check-in inválida. Por favor, insira novamente.");
            }
        } while (!validarData(checkIn));

        String checkOut;
        do {
            System.out.print("Data de check-out (yyyy-mm-dd): ");
            checkOut = scanner.nextLine();
            if (!validarData(checkOut)) {
                System.out.println("Data de check-out inválida. Por favor, insira novamente.");
            }
        } while (!validarData(checkOut));

        // Gerar código único baseado nos atributos da reserva
        int codigoReserva = gerarCodigoReserva(nomeHotel, numeroQuarto, checkIn, checkOut);
        Reserva novaReserva = new Reserva(codigoReserva, nomeHotel, numeroQuarto, checkIn, checkOut);
        sistemaReservas.inserir(codigoReserva, novaReserva);
        System.out.println("Reserva inserida com sucesso! Código da reserva: " + codigoReserva);
    }

    private static boolean validarData(String data) {
        try {
            LocalDate.parse(data, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static void verTodasReservas(MeuHashMap<Integer, Reserva> sistemaReservas) {
        if (sistemaReservas.tamanho() == 0) {
            System.out.println("Não há reservas registradas.");
        } else {
            System.out.println("Todas as reservas:");
            for (int chave : sistemaReservas.chaves()) {
                Reserva reserva = sistemaReservas.recuperar(chave);
                System.out.println(reserva);
            }
        }
    }

    private static void procurarReserva(MeuHashMap<Integer, Reserva> sistemaReservas, Scanner scanner) {
        System.out.print("Digite o código da reserva: ");
        int codigoReserva = Integer.parseInt(scanner.nextLine());
        Reserva reserva = sistemaReservas.recuperar(codigoReserva);
        if (reserva != null) {
            System.out.println("Reserva encontrada:");
            System.out.println(reserva);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    private static void removerReserva(MeuHashMap<Integer, Reserva> sistemaReservas, Scanner scanner) {
        System.out.print("Digite o código da reserva a ser removida: ");
        int codigoReserva = Integer.parseInt(scanner.nextLine());
        sistemaReservas.remover(codigoReserva);
        System.out.println("Reserva removida com sucesso!");
    }

    // Método para gerar código único de reserva baseado nos atributos da reserva
    private static int gerarCodigoReserva(String nomeHotel, int numeroQuarto, String checkIn, String checkOut) {
        String dadosReserva = nomeHotel + numeroQuarto + checkIn + checkOut;
        return dadosReserva.hashCode() & Integer.MAX_VALUE; // Garantir que o código seja positivo
    }
}

import java.util.Scanner;

public class ConversioneOra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Inserisci il tempo in secondi (0-86400) o 'esci' per terminare: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("esci")) break;

            try {
                int secondi = Integer.parseInt(input);
                if (secondi < 0 || secondi > 86400) {
                    System.out.println("Valore non valido. Riprova.");
                } else {
                    convertiSecondi(secondi);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero intero o 'esci'.");
            }
        }
    }

    public static void convertiSecondi(int secondi) {
        int ore = secondi / 3600;
        int minuti = (secondi % 3600) / 60;
        int sec = secondi % 60;
        System.out.println(secondi + " secondi corrispondono a " + ore + " h, " + minuti + " m e " + sec + " s");
    }
}
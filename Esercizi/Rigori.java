import java.util.Random;
import java.util.Scanner;

public class Rigori {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Inserisci il nome della Squadra 1: ");
        String squadra1 = scanner.nextLine();
        System.out.print("Inserisci il nome della Squadra 2: ");
        String squadra2 = scanner.nextLine();

        int goalSquadra1 = 0, goalSquadra2 = 0;
        int tiriSquadra1 = 0, tiriSquadra2 = 0;

        for (int i = 0; i < 5; i++) {
            tiriSquadra1++;
            boolean squadra1Segna = simulaTiro(scanner, random, squadra1);
            if (squadra1Segna) {
                goalSquadra1++;
                System.out.println(ANSI_GREEN + squadra1 + " ha segnato! Goal: " + goalSquadra1 + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + squadra1 + " ha sbagliato!" + ANSI_RESET);
            }

            tiriSquadra2++;
            boolean squadra2Segna = simulaTiro(scanner, random, squadra2);
            if (squadra2Segna) {
                goalSquadra2++;
                System.out.println(ANSI_GREEN + squadra2 + " ha segnato! Goal: " + goalSquadra2 + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + squadra2 + " ha sbagliato!" + ANSI_RESET);
            }

            System.out.println("Risultato momentaneo [" + goalSquadra1 + " - " + goalSquadra2 + "]");

            if (i == 4 && goalSquadra1 != goalSquadra2) break;
        }

        while (goalSquadra1 == goalSquadra2) {
            tiriSquadra1++;
            boolean squadra1Segna = simulaTiro(scanner, random, squadra1);
            if (squadra1Segna) {
                goalSquadra1++;
                System.out.println(ANSI_GREEN + squadra1 + " ha segnato! Goal: " + goalSquadra1 + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + squadra1 + " ha sbagliato!" + ANSI_RESET);
            }

            tiriSquadra2++;
            boolean squadra2Segna = simulaTiro(scanner, random, squadra2);
            if (squadra2Segna) {
                goalSquadra2++;
                System.out.println(ANSI_GREEN + squadra2 + " ha segnato! Goal: " + goalSquadra2 + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + squadra2 + " ha sbagliato!" + ANSI_RESET);
            }

            System.out.println("Risultato momentaneo [" + goalSquadra1 + " - " + goalSquadra2 + "]");
        }

        String vincitore = goalSquadra1 > goalSquadra2 ? squadra1 : squadra2;
        System.out.println(ANSI_YELLOW + "La squadra vincente è " + vincitore + "!" + ANSI_RESET);
        System.out.println("Tiri totali: " + (tiriSquadra1 + tiriSquadra2));
        System.out.println(squadra1 + " Goal: " + goalSquadra1);
        System.out.println(squadra2 + " Goal: " + goalSquadra2);
    }

    private static boolean simulaTiro(Scanner scanner, Random random, String squadra) {
        System.out.print(squadra + ", premi Invio per tirare il rigore...");
        scanner.nextLine();
        int risultato = random.nextInt(8) + 1; // 1: parato, 2: palo, 3: fuori, 4-8: segnato
        switch (risultato) {
            case 1:
                System.out.println(ANSI_RED + "Parato!" + ANSI_RESET);
                return false;
            case 2:
                System.out.println(ANSI_RED + "Palo!" + ANSI_RESET);
                return false;
            case 3:
                System.out.println(ANSI_RED + "Fuori!" + ANSI_RESET);
                return false;
            default:
                return true;
        }
    }
}
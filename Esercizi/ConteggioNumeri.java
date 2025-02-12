import java.util.Scanner;


public class ConteggioNumeri {
    public static void stampaSequenza(int n) {
        if (n % 2 == 0) {
            System.out.print(n + ": ");
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        } else {
            System.out.print(n + ": ");
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Inserisci un numero intero non negativo (0 per terminare): ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                break;
            }
            stampaSequenza(numero);
        }
        scanner.close();
    }
}

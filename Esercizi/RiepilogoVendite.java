import java.util.Scanner;

public class RiepilogoVendite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] categorie = {"Televisori", "Frigoriferi", "Lavatrici", "Altro"};
        int[] quantita = new int[categorie.length];
        double[] guadagni = new double[categorie.length];
        double guadagnoTotale = 0;
        
        for (int i = 0; i < categorie.length; i++) {
            quantita[i] = chiediQuantita(scanner, categorie[i]);
            guadagni[i] = calcolaGuadagno(scanner, quantita[i], categorie[i]);
            guadagnoTotale += guadagni[i];
        }
        
        scanner.close();
        
        stampaResoconto(categorie, quantita, guadagni, guadagnoTotale);
    }
    
    private static int chiediQuantita(Scanner scanner, String categoria) {
        System.out.print("Quanti " + categoria.toLowerCase() + " sono stati venduti? ");
        return scanner.nextInt();
    }
    
    private static double calcolaGuadagno(Scanner scanner, int quantita, String categoria) {
        double guadagno = 0;
        for (int i = 0; i < quantita; i++) {
            System.out.print("Inserisci il prezzo del " + categoria.toLowerCase().substring(0, categoria.length() - 1) + ": ");
            guadagno += scanner.nextDouble();
        }
        return guadagno;
    }
    
    private static void stampaResoconto(String[] categorie, int[] quantita, double[] guadagni, double guadagnoTotale) {
        final String RESET = "\u001B[0m";
        final String[] COLORI = {"\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m"};
        
        System.out.println("Riepilogo delle vendite:");
        System.out.println("Guadagno totale: " + guadagnoTotale);
        
        int quantitaTotale = 0;
        for (int q : quantita) {
            quantitaTotale += q;
        }
        
        for (int i = 0; i < categorie.length; i++) {
            double percentualeQuantita = (quantita[i] / (double) quantitaTotale) * 100;
            double percentualeGuadagno = (guadagni[i] / guadagnoTotale) * 100;
            String colore = COLORI[i % COLORI.length];
            System.out.println(colore + categorie[i] + ":" + RESET);
            System.out.println(colore + "  Numero di prodotti venduti: " + quantita[i] + " (" + percentualeQuantita + "%)" + RESET);
            System.out.println(colore + "  Guadagno: " + guadagni[i] + " (" + percentualeGuadagno + "%)" + RESET);
        }
    }
}


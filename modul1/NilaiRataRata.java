package modul1;

import java.util.Scanner;

public class NilaiRataRata {
    public static void main(String[] args) {
        int jumlahDeretAngka;
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah deret angka: ");
        jumlahDeretAngka = input.nextInt();

        double jumlahAngka = 0;
        for (int i = 1; i <= jumlahDeretAngka; i++) {
            System.out.print("Angka ke-" + i + ": ");
            jumlahAngka += input.nextDouble();
        }

        double rataRata = jumlahAngka / jumlahDeretAngka;
        System.out.println("Jadi, nilai rata-ratanya adalah " + rataRata);
        input.close();
    }

}

package modul3;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class DataSearch {
    static String[] produk = { "Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford",
            "Hyundai", "Mitsubishi" };
    static long[] harga = { 1340000000, 34500000000L, 350000000, 2000000000, 245000000, 500000000, 169000000, 789000000,
            122900000, 278100000 };
    static boolean isRunning = true;
    static Scanner input = new Scanner(System.in);

    static void daftarMobil() {
        System.out.println("=====================================");
        System.out.println("------------ Daftar Mobil -----------");
        System.out.println("=====================================");
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat df = (DecimalFormat) currencyFormatter;
        DecimalFormatSymbols dfs = new DecimalFormat().getDecimalFormatSymbols();

        dfs.setCurrency(df.getCurrency());
        dfs.setCurrencySymbol("Rp");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setMonetaryGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        for (int i = 0; i < produk.length; i++) {
            System.out.format("%d. %s %s \n", i + 1, produk[i], df.format(harga[i]));
        }
        System.out.println("=================================");
    }

    static void cariMobil() {
        int i;
        String value = input.nextLine();
        boolean ada = false;

        for (i = 0; i < produk.length; i++) {
            if (produk[i].equals(value)) {
                ada = true;
                break;
            }
        }
        if (ada) {
            System.out.println("");
            System.out.println("Nama Brand Mobil " + produk[i] + " Ditemukan Pada Index Ke - " + i);
            System.out.println("Mobil Seharga : " + "Rp. " + harga[i]);
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Data Mobil " + produk[i] + " Tidak Ditemukan!");
        }
    }

    static void mengurutkanMobil() {
        System.out.println("");
        long tmp;
        for (int c = 1; c < 10; c++) {
            for (int d = 0; d < 10 - c; d++) {
                if (harga[d] > harga[d + 1]) {
                    tmp = harga[d];
                    harga[d] = harga[d + 1];
                    harga[d + 1] = tmp;
                }
            }
        }
        System.out.println("Urutan Termurah Hingga Termahal");
        for (int i = 0; i < 10; i++) {
            System.out.println("Produk Mobil " + produk[i] + " Seharga Rp. " + harga[i]);
        }
    }

    static void menunjukMobil() {
        Long search = 169_000_000L;
        int i;
        boolean find = false;

        for (i = 0; i < harga.length; i++) {
            if (harga[i] == search) {
                find = true;
                break;
            }
        }
        if (find) {
            System.out.println("");
            System.out.println("Harga Mobil Termurah Ke-2");
            System.out.println("Brand Mobil " + produk[i] + " Seharga" + search);
        } else {
            System.out.println("Data Tidak DItemukan!");
        }
    }

    static void mainMenu() {
        int menu;
        daftarMobil();
        System.out.println("=============== MENU ===============");
        System.out.println("1. Cari Data Mobil\n2. Urutkan Harga Mobil\n3. Mobil Termurah Ke 2\n4. Keluar");
        System.out.print("Pilih Menu : ");
        menu = input.nextInt();
        switch (menu) {
            case 1:
                cariMobil();
                break;
            case 2:
                mengurutkanMobil();
                break;
            case 3:
                menunjukMobil();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Input Salah!");
        }

    }

    public static void main(String[] args) throws IOException {
        do {
            mainMenu();
        } while (isRunning);

    }

}
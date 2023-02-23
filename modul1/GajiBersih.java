import java.text.NumberFormat;
import java.util.Scanner;

public class GajiBersih {
    public static void main(String[] args) {
        double pajak = 0.05, gaji_pokok;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan gaji pokok: ");
        gaji_pokok = input.nextDouble();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String gaji_bersih = formatter.format(gaji_pokok - (gaji_pokok * pajak));
        System.out.println("Jadi, gaji bersih setelah kena pajak 5% adalah " + gaji_bersih);
        input.close();
    }
}

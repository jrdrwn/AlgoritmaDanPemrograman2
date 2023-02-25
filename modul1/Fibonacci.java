package modul1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        ClearScreen();

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nilai n: ");
        int n = input.nextInt();

        System.out.printf("Bilangan fibonacci ke-%d adalah %d\n", n, solve(n));

        input.close();
    }

    private static int solve(int n) {
        // Conditional (ternary)
        return (n == 1 || n == 2) ? 1 : solve(n - 1) + solve(n - 2);
    }

    private static void ClearScreen() {
        // \033[H : memindahkan cursor ke kiri atas konsole
        // \033[2J : menghapus output di layar
        System.out.print("\033[H\033[2J");

        // mengatur ulang posisi cursor
        System.out.flush();
    }
}

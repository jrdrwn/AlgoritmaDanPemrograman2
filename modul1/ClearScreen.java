package modul1;

public class ClearScreen {
    public static void main(String[] args) {
        // sampel output
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }

        clearScreen();
    }

    public static void clearScreen() {
        // \033[H : memindahkan cursor ke kiri atas konsole
        // \033[2J : menghapus output di layar
        System.out.print("\033[H\033[2J");

        // mengatur ulang posisi cursor
        System.out.flush();
    }
}

package modul1;

public class ClearScreen {
    public static void main(String[] args) {
        // \033[H : memindahkan cursor ke kiri atas konsole
        // \033[2J : menghapus output di layar
        System.out.print("\033[H\033[2J");

        // mengatur ulang posisi cursor
        System.out.flush();
    }
}

package modul1;

public class PengulanganSederhana {
    public static int n = 15;

    public static void main(String[] args) {
        _for();
        _doWhile();
        _while();
    }

    public static void _for() {
        System.out.print("for: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void _doWhile() {
        System.out.print("do-while: ");
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= n);
        System.out.println();
    }

    public static void _while() {
        System.out.print("while: ");
        int i = 1;
        while (i <= n) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }
}

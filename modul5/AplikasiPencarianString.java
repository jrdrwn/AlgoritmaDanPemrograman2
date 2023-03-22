package modul5;

import java.util.Scanner;

public class AplikasiPencarianString {
    static Scanner input;

    static class Naive {
        public static void search(String str, String pattern) {
            int n = str.length();
            int m = pattern.length();

            for (int s = 0; s <= n - m; s++) {
                int j;
                for (j = 0; j < m; j++)
                    if (str.charAt(s + j) != pattern.charAt(j))
                        break;
                if (j == m)
                    System.out.println("Teks ditemukan pada indeks ke-" + s);
            }
        }
    }

    static class RabinKarp {
        private final static int d = 10;

        static void search(String pattern, String txt, int q) {
            int m = pattern.length();
            int n = txt.length();
            int i, j;
            int p = 0;
            int t = 0;
            int h = 1;

            for (i = 0; i < m - 1; i++)
                h = (h * d) % q;

            // hitung nilai hash untuk pattern and text
            for (i = 0; i < m; i++) {
                p = (d * p + pattern.charAt(i)) % q;
                t = (d * t + txt.charAt(i)) % q;
            }

            // Cari kecocokan
            for (i = 0; i <= n - m; i++) {
                if (p == t) {
                    for (j = 0; j < m; j++) {
                        if (txt.charAt(i + j) != pattern.charAt(j))
                            break;
                    }
                    if (j == m)
                        System.out.println("Teks ditemukan pada indeks ke-" + i);
                }
                if (i < n - m) {
                    t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                    if (t < 0)
                        t = (t + q);
                }
            }
        }
    }

    public class FSA {
        private static int NO_OF_CHARS = 256;

        private static int getNextState(char[] pat, int M, int state, int x) {
            // Jika karakter c sama dengan karakter berikutnya di dalam pattern maka
            // increment state
            if (state < M && x == pat[state])
                return state + 1;

            // ns adalah variabel yang menyimpan hasil state berikutnya (next state)
            int ns, i;

            // berikutnya ns berisi awalan terpanjang
            // yang juga merupakan akhiran dalam "pat [0..state-1] c"
            // Mulai dari kemungkinan nilai terbesar
            // dan berhenti ketika Anda menemukan awalan yang akhiran

            for (ns = state; ns > 0; ns--) {
                if (pat[ns - 1] == x) {
                    for (i = 0; i < ns - 1; i++)
                        if (pat[i] != pat[state - ns + 1 + i])
                            break;
                    if (i == ns - 1)
                        return ns;
                }
            }
            return 0;
        }

        /* membangun tabel untuk merepresentasikikan fungsi automata dari suatu pola */
        private static void computeTF(char[] pat, int M, int TF[][]) {
            int state, x;
            for (state = 0; state <= M; ++state)
                for (x = 0; x < NO_OF_CHARS; ++x)
                    TF[state][x] = getNextState(pat, M, state, x);
        }

        /* Mencetak kemunculan pola dalam text */
        static void search(char[] pat, char[] txt) {
            int M = pat.length;
            int N = txt.length;

            int[][] TF = new int[M + 1][NO_OF_CHARS];

            computeTF(pat, M, TF);

            // process pencocokan teks ke pola.
            int i, state = 0;
            for (i = 0; i < N; i++) {
                state = TF[state][txt[i]];
                if (state == M)
                    System.out.println("Teks ditemukan pada indeks ke-" + (i - M + 1));
            }
        }
    }

    static class KMP {
        static void search(String pat, String txt) {
            int M = pat.length();
            int N = txt.length();

            // buat variabel lps[] untuk menangani
            // nilai awalan dan akhiran terpanjang untuk pattern/pola
            int lps[] = new int[M];
            int j = 0;

            // pra pemrosesan pattern (kalkulasi array lps[])
            computeLPSArray(pat, M, lps);

            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    System.out.println("Teks ditemukan pada indeks ke-" + (i - j));
                    j = lps[j - 1];
                }

                // ketidakcocokan pada pencocokan indeks J pattern
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
        }

        private static void computeLPSArray(String pat, int M, int lps[]) {

            // panjang dari awalan(prefix) dan akhiran (suffix)
            // terpanjang sebelumnya
            int len = 0;

            int i = 1;
            lps[0] = 0;

            // Looping untuk kalkulasi lps[i] = 1 sampai M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {

                    if (len != 0) {
                        len = lps[len - 1];

                    } else {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        do {
            long startTime = System.nanoTime();
            input = new Scanner(System.in);
            System.out.print("Masukkan Teks : ");
            String text = input.nextLine();
            System.out.print("Masukkan Teks yang dicari : ");
            String pattern = input.nextLine();
            System.out.print("""
                    Pilih metode Pencarian:
                     1.  Naive
                     2.  Rabin Karp
                     3.  Infinite State Automata
                     4.  Knuth Morris Pratt
                    Metode yang dipilih :""");
            int method = input.nextInt();
            System.out.println("\nHasil Pencarian:\n");
            switch (method) {
                case 1 -> Naive.search(text, pattern);
                case 2 -> RabinKarp.search(pattern, text, 13);
                case 3 -> FSA.search(pattern.toCharArray(), text.toCharArray());
                case 4 -> KMP.search(pattern, text);
                default -> System.out.println("Gagal!");
            }
            long stopTime = System.nanoTime();
            System.out.println("\nWaktu Eksekusi: " + (stopTime - startTime) + " milidetik");
            System.out.print("\nLanjut?[y/n] ");
            String next = input.next().toLowerCase();
            if (next.equals("n")) {
                System.exit(0);
            }
        } while (true);
    }

}

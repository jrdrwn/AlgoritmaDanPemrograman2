package modul4;

public class PrimV2 {

    public static void main(String[] args) {
        // Inisialisasi graf
        int[][] graph = { { 0, 1, 4, 3 }, { 1, 0, 0, 2 }, { 4, 0, 0, 5 }, { 3, 2, 5, 0 } };
        // Panggil fungsi primMST dan berikan graf sebagai argumen
        primMST(graph);
    }

    public static void primMST(int[][] graph) {
        int vertices = graph.length;
        int[] parent = new int[vertices]; // Array untuk menyimpan simpul-simpul dalam MST
        int[] key = new int[vertices]; // Array untuk menyimpan nilai kunci setiap simpul
        boolean[] visited = new boolean[vertices]; // Array untuk menyimpan status kunjungan setiap simpul

        // Inisialisasi semua nilai kunci dengan nilai maksimum dan semua simpul belum
        // dikunjungi
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        key[0] = 0; // Nilai kunci simpul awal di-set sebagai 0
        parent[0] = -1; // Simpul awal tidak memiliki parent

        // Ulangi sebanyak (jumlah simpul - 1) kali, karena MST memiliki (jumlah simpul
        // - 1) sisi
        for (int i = 0; i < vertices - 1; i++) {
            int u = getMinimumKey(key, visited); // Ambil simpul dengan nilai kunci terkecil yang belum dikunjungi
            visited[u] = true; // Tandai simpul sebagai telah dikunjungi

            // Ulangi untuk setiap simpul tujuan yang belum dikunjungi dan memiliki sisi
            // yang menghubungkannya dengan simpul sumber
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u; // Tetapkan simpul sumber sebagai parent simpul tujuan
                    key[v] = graph[u][v]; // Perbarui nilai kunci simpul tujuan dengan bobot sisi yang lebih kecil
                }
            }
        }

        printMST(parent, graph); // Cetak MST pada output
    }

    public static int getMinimumKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        // Loop untuk mencari simpul dengan nilai kunci terkecil yang belum dikunjungi
        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex; // Kembalikan indeks simpul dengan nilai kunci terkecil
    }

    public static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        // Loop untuk mencetak setiap sisi dalam MST
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
}
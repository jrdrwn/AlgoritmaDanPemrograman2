import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        // Inisialisasi graf
        int graph[][] = new int[][] {
                { 0, 17, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 17, 0, 11, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 16, 11, 0, 0, 0, 12, 17, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 20, 0, 0, 5, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 5, 0, 10, 0, 0, 12, 0, 0, 0, 0, 8 },
                { 0, 0, 12, 9, 10, 0, 9, 6, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 17, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 6, 0, 0, 6, 10, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 12, 0, 0, 6, 0, 10, 0, 10, 17, 16 },
                { 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 9, 0, 17, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 9, 17, 0, 12 },
                { 0, 0, 0, 0, 8, 0, 0, 0, 16, 0, 0, 0, 12, 0 },
        };
        // Panggil fungsi kruskalMST dan berikan graf sebagai argumen
        kruskalMST(graph);
    }

    public static void kruskalMST(int[][] graph) {
        int vertices = graph.length;
        List<Edge> edges = new ArrayList<>(); // List untuk menyimpan semua sisi
        List<Edge> mst = new ArrayList<>(); // List untuk menyimpan MST

        // Loop untuk menambahkan setiap sisi ke dalam List edges
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // Urutkan List edges berdasarkan bobotnya dari kecil ke besar
        Collections.sort(edges);

        int[] parent = new int[vertices]; // Array untuk menyimpan simpul-simpul dalam MST

        // Inisialisasi setiap simpul dengan dirinya sendiri sebagai parent
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        // Loop untuk memproses setiap sisi dalam List edges
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int uParent = findParent(parent, u);
            int vParent = findParent(parent, v);

            // Jika sisi tidak membentuk siklus, tambahkan sisi tersebut ke dalam MST dan
            // gabungkan dua simpul yang berbeda
            if (uParent != vParent) {
                mst.add(edge);
                parent[uParent] = vParent;
            }
        }

        // Cetak MST pada output
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }

    public static int findParent(int[] parent, int node) {
        // Loop untuk mencari parent dari simpul
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge otherEdge) {
            return Integer.compare(this.weight, otherEdge.weight);
        }
    }
}

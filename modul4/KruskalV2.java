package modul4;

import java.util.*;

public class KruskalV2 {

    public static void main(String[] args) {
        // Inisialisasi graf
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
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

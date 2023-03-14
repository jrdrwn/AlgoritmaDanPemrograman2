package modul4;

import java.util.*;

public class BellmanFordV2 {

    public static void main(String[] args) {
        // Inisialisasi graf
        int[][] graph = {
                { 0, 6, 0, 0, 0, 0 },
                { 0, 0, 3, 5, 0, 0 },
                { 0, 0, 0, 2, 4, 0 },
                { 0, -1, 0, 0, 2, 3 },
                { 0, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 0, 0, 0 }
        };
        int sourceNode = 0;
        // Panggil fungsi bellmanFord dan berikan graf dan simpul sumber sebagai argumen
        bellmanFord(graph, sourceNode);
    }

    public static void bellmanFord(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices]; // Array untuk menyimpan jarak terpendek ke setiap simpul
        Arrays.fill(distance, Integer.MAX_VALUE); // Inisialisasi jarak awal dengan nilai tak terhingga
        distance[source] = 0; // Jarak dari simpul sumber ke dirinya sendiri adalah 0

        // Loop untuk memproses setiap simpul
        for (int i = 0; i < vertices - 1; i++) {
            // Loop untuk memproses setiap tepi
            for (int j = 0; j < vertices; j++) {
                for (int k = 0; k < vertices; k++) {
                    if (graph[j][k] != 0) { // Jika ada tepi dari simpul j ke simpul k
                        int newDistance = distance[j] + graph[j][k]; // Hitung jarak baru
                        if (newDistance < distance[k]) { // Jika jarak baru lebih pendek dari jarak sebelumnya
                            distance[k] = newDistance; // Update jarak terpendek ke simpul k
                        }
                    }
                }
            }
        }

        // Loop untuk memeriksa apakah terdapat sirkuit negatif
        for (int j = 0; j < vertices; j++) {
            for (int k = 0; k < vertices; k++) {
                if (graph[j][k] != 0) { // Jika ada tepi dari simpul j ke simpul k
                    int newDistance = distance[j] + graph[j][k]; // Hitung jarak baru
                    if (newDistance < distance[k]) { // Jika jarak baru lebih pendek dari jarak sebelumnya
                        System.out.println("Graph contains negative weight cycle");
                        return;
                    }
                }
            }
        }

        // Cetak jarak terpendek ke setiap simpul pada output
        System.out.println("Shortest distances from source node:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + distance[i]);
        }
    }
}

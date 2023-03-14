package modul4;

import java.util.*;

public class DjikstraV2 {

    public static void main(String[] args) {
        // Inisialisasi graf
        int[][] graph = {
                { 0, 6, 0, 0, 0, 0 },
                { 6, 0, 3, 5, 0, 0 },
                { 0, 3, 0, 2, 4, 0 },
                { 0, 5, 2, 0, 2, 3 },
                { 0, 0, 4, 2, 0, 5 },
                { 0, 0, 0, 3, 5, 0 }
        };
        int sourceNode = 0;
        // Panggil fungsi dijkstra dan berikan graf dan simpul sumber sebagai argumen
        dijkstra(graph, sourceNode);
    }

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices]; // Array untuk menandai simpul yang telah dikunjungi
        int[] distance = new int[vertices]; // Array untuk menyimpan jarak terpendek ke setiap simpul
        Arrays.fill(distance, Integer.MAX_VALUE); // Inisialisasi jarak awal dengan nilai tak terhingga
        distance[source] = 0; // Jarak dari simpul sumber ke dirinya sendiri adalah 0

        // Loop untuk memproses setiap simpul
        for (int i = 0; i < vertices - 1; i++) {
            int currentNode = findMinDistanceNode(visited, distance); // Cari simpul dengan jarak terpendek
            visited[currentNode] = true; // Tandai simpul sebagai telah dikunjungi

            // Loop untuk memproses setiap tetangga dari simpul yang sedang diproses
            for (int j = 0; j < vertices; j++) {
                if (graph[currentNode][j] != 0 && !visited[j]) { // Jika simpul j adalah tetangga dari simpul
                                                                 // currentNode dan belum dikunjungi
                    int newDistance = distance[currentNode] + graph[currentNode][j]; // Hitung jarak baru melalui simpul
                                                                                     // currentNode
                    if (newDistance < distance[j]) { // Jika jarak baru lebih pendek dari jarak sebelumnya
                        distance[j] = newDistance; // Update jarak terpendek ke simpul j
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

    public static int findMinDistanceNode(boolean[] visited, int[] distance) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceNode = -1;
        // Loop untuk mencari simpul dengan jarak terpendek yang belum dikunjungi
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceNode = i;
            }
        }
        return minDistanceNode;
    }
}

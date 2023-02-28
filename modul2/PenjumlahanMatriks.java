package modul2;

import java.util.Scanner;

public class PenjumlahanMatriks {
    static final int row = 2;
    static final int col = 3;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        display(solve(InputMatrix('A'), InputMatrix('B')));

        input.close();
    }

    private static int[][] InputMatrix(char nama) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Matriks %c (%d, %d) : ", nama, i, j);
                int n = input.nextInt();
                matrix[i][j] = n;
            }
        }
        return matrix;
    }

    private static int[][] solve(int[][] A, int[][] B) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = A[i][j] + B[i][j];
            }
        }
        return matrix;
    }

    private static void display(int[][] matrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("| %s | \t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

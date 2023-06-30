import java.util.Scanner;

public class Main {
    static int n = 9;

    static void Print(int a[][]) {
        System.out.print("  ");
        for (int j = 0; j < n; j++) {
            if ((j + 1) % 3 == 0)
                System.out.print(j + "    ");
            else
                System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(a[i][j] + " ");

                if (j == 2 || j == 5 || j == 8)
                    System.out.print(" | ");

            }
            System.out.println();
            if (i == 2 || i == 5 || i == 8)
                System.out.println("  - - - - - - - - - - - - - ");
        }
    }

    static boolean check(int a[][], int row, int col, int num) {
        for (int i = 0; i < n; i++) {
            if (a[i][col] == num)
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (a[row][i] == num)
                return false;
        }
        return true;
    }

    static int[][] place(int board[][]) {
        int h = 0;
        for (int i = 0; i < 3; i++) {
            if (h >= 9)
                h = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = (int) (Math.random() * 9);
                    int col = (int) (Math.random() * 9);
                    int num = (int) (Math.random() * 9);
                    // System.out.println(row + " " + col + h + " " + num);
                    if (check(board, row, col, num)) {
                        board[row][col] = num;
                    }

                }
            }
            h += 3;
        }
        return board;
    }

    public static void main(String[] args) {
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        Print(board);
        board = place(board);
        System.out.println();
        Print(board);

    }
}

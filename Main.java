import java.util.Scanner;

public class Main {
    static int n = 9;

    static void Print(int a[][]) {
        System.out.print("  ");
        for (int j = 0; j < n; j++)
            System.out.print(j + " ");

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
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
        for (int i = 0; i < n; i++) {
            if (h > 9)
                h = 0;
            for (int j = h; j < h + 3; j++) {
                for (int k = h; k < h + 3; k++) {
                    int row = (int) (Math.random() * 3);
                    int col = (int) (Math.random() * 3);
                    int num = (int) Math.random() * 9;
                    if (check(board, row, col, num)) {
                        board[i][j] = num;
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
        Print(board);

    }
}

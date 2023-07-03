import java.util.Scanner;

public class Main extends Placing_numbers {
    static int n = 9;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Win_or_not win_check = new Win_or_not();
        Printing prt = new Printing();
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        prt.Print(board, n);
        board = place(board);
        System.out.println();
        prt.Print(board, n);
        while (true) {
            System.out.println("Enter the row,coloumn and the number");
            int row = input.nextInt(), col = input.nextInt(), num = input.nextInt();
            if (check(board, row, col, num)) {
                board[row][col] = num;
                prt.Print(board, n);
                if (win_check.wincheck(board, n)) {
                    break;
                }
            } else {
                System.out.println("Kindly check the number it's in valid on this position");
                continue;
            }
        }

    }
}

class Win_or_not {
    static boolean wincheck(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}

class Placing_numbers {
    static int n = 9;

    static boolean check(int a[][], int row, int col, int num) {
        for (int i = 0; i < n; i++) {
            if (a[i][col] == num)
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (a[row][i] == num)
                return false;
        }
        int r = give(row);
        int c = give(col);
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (a[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    static int give(int a) {
        if (a >= 0 && a <= 2)
            return 0;
        else if (a >= 3 && a <= 5)
            return 3;
        else if (a >= 6 && a <= 8)
            return 6;
        return 0;
    }

    static int[][] place(int board[][]) {
        int h = 0;
        for (int i = 0; i < n; i++) {
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
}

class Printing {
    static void Print(int a[][], int n) {
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
}
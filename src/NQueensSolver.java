import java.util.*;

class  NQueensSolver {


    static boolean isSafe(int row, int col, int rows, int ld, int rd, int n) {
        return !(((rows >> row) & 1) == 1) && !(((ld >> (row + col)) & 1) == 1)
                && !(((rd >> (row - col + n)) & 1) == 1);
    }


    static void nQueenUtil(int col, int n, ArrayList<Integer> board,
                           ArrayList<ArrayList<Integer>> res, int rows, int ld, int rd) {


        if (col > n) {
            res.add(new ArrayList<>(board));
            return;
        }


        for (int row = 1; row <= n; ++row) {


            if (isSafe(row, col, rows, ld, rd, n)) {


                board.add(row);

                nQueenUtil(col + 1, n, board, res,
                        rows | (1 << row), (ld | (1 << (row + col))),
                        (rd | (1 << (row - col + n))));


                board.remove(board.size() - 1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        ArrayList<Integer> board = new ArrayList<>();


        nQueenUtil(1, n, board, res, 0, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> res = nQueen(n);

        for (ArrayList<Integer> solution : res) {
            System.out.print("[");
            for (int j = 0; j < n; ++j) {
                System.out.print(solution.get(j));
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}
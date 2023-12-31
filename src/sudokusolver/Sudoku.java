package sudokusolver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sudoku {

    private final int[][] board;
    private Integer[] set_1to10 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private List<Integer> list_1to10 = Arrays.asList(set_1to10);

    public Sudoku(int[][] board) {
        this.board = board;

        Collections.shuffle(this.list_1to10);
        this.list_1to10.toArray(this.set_1to10);
    }

    @Override
    public String toString() {
        String output;
        output = "|-----------------------|\n";
        for (int row = 0; row < 9; row++) {
            output += "| ";
            for (int col = 0; col < 9; col++) {
                output += this.board[row][col] + " ";
                if (col % 3 == 2) {
                    output += "| ";
                }
            }
            output += "\n";
            if (row % 3 == 2) {
                output += "|-----------------------|\n";
            }
        }
        return output;
    }

    private int[] findFirstFreePlace() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (this.board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private Boolean isValidMove(int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (this.board[row][c] == num) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (this.board[r][col] == num) {
                return false;
            }
        }

        int top = row / 3 * 3;
        int left = col / 3 * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (this.board[top + r][left + c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean solveBoard() {
        int[] position = this.findFirstFreePlace();
        int row = position[0];
        int col = position[1];

        if ((row == -1) || (col == -1)) {
            return true;
        }

        for (int num = 0; num < 9; num++) {
            if (this.isValidMove(row, col, this.set_1to10[num])) {
                this.board[row][col] = this.set_1to10[num];
                if (this.solveBoard()) {
                    return true;
                }
                this.board[row][col] = 0;
            }
        }
        return false;
    }
}

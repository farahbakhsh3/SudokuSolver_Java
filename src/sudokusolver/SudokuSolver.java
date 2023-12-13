
package sudokusolver;

public class SudokuSolver {

        public static void main(String[] args) {
            
            int[][] board = new int[][] {
                {9,0,0,0,0,0,0,0,0},
                {0,0,0,0,9,0,0,0,0},
                {0,0,0,0,0,0,9,0,0},
                {0,0,0,9,0,0,0,0,0},
                {0,9,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,9,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
            };
            Sudoku sudoku = new Sudoku(board);
            System.out.println(sudoku.toString());
            if(sudoku.solveBoard())
                System.out.println(sudoku.toString());
            else
                System.err.println("There is no sulotion for this board!!!");
    }
    
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest {

    private Board b;

    static {
        System.loadLibrary("libChessJNIpart");
    }

    @BeforeEach
    public void set() {
        b = new Board();
        b.setBoard();
    }

    @Test
    public void checkIfBoardInitializedCorrectly() {
        int[][] board = b.getBoard();

        int[][] actualBoard = {
                { 2, 3, 4, 6, 5, 4, 3, 2},
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -2, -3, -4, -6, -5, -4, -3, -2 }
        };

        Assertions.assertNotNull(board, "Board is ready");
        Assertions.assertEquals(8, board.length, "Correct board height");
        Assertions.assertEquals(8, board[0].length, "Correct board width");
        Assertions.assertEquals(actualBoard[0][0] , board[0][0], "Correct board values");


    }

}

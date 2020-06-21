package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class QueenTest {

    private Queen queen;

    @Test
    void shouldMoveForwardBackwardLeftRightAndDiagonalMovesAndAcrossTheBoard() {
        givenQueenPositionAt('D', 5);
        List<String> possibleMoves = queen.getPossibleMoves();
        checkWhetherValidPositionsAreReturned(possibleMoves);
    }

    @Test
    void shouldNotBeAbleToMoveBeyondBoundary() {
        givenQueenPositionAt('H', 4);
        List<String> possibleMoves = queen.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("I5"));
        Assertions.assertFalse(possibleMoves.contains("I4"));
        Assertions.assertFalse(possibleMoves.contains("I3"));
        Assertions.assertTrue(possibleMoves.contains("H5"));
        Assertions.assertTrue(possibleMoves.contains("H3"));
        Assertions.assertTrue(possibleMoves.contains("G3"));
        Assertions.assertTrue(possibleMoves.contains("G4"));
        Assertions.assertTrue(possibleMoves.contains("G5"));
        Assertions.assertEquals(21, possibleMoves.size());
    }

    @Test
    void shouldBeAbleToMoveMoreThanOneBlockAtaTimeInAnyDirection() {
        givenQueenPositionAt('D', 1);
        List<String> possibleMoves = queen.getPossibleMoves();
        Assertions.assertTrue(possibleMoves.contains("D2"));
        Assertions.assertTrue(possibleMoves.contains("D3"));
    }

    private void checkWhetherValidPositionsAreReturned(List<String> possibleMoves) {
        List<String> expectedPossibleMovesForQueenGivenItsPositionAtD5 =
                Arrays.asList("D6", "D7", "D8", "E6", "F7", "G8",
                        "E5", "F5", "G5", "H5", "E4", "F3", "G2",
                        "H1", "D4", "D3", "D2", "D1", "C4", "B3",
                        "A2", "C5", "B5", "A5", "C6", "B7", "A8");
        Assertions.assertTrue(possibleMoves.containsAll(expectedPossibleMovesForQueenGivenItsPositionAtD5));
        Assertions.assertEquals(27, possibleMoves.size());
    }

    private void givenQueenPositionAt(char row, int column) {
        queen = new Queen(row, column);
    }

}
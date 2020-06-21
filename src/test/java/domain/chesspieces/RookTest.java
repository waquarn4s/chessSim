package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RookTest {
    private Rook rook = new Rook('A', 3);

    @Test
    void shouldBeAbleToMoveStraightInAllDirectionAndAcrossTheBoard() {
        List<String> possibleMoves = rook.getPossibleMoves();
        List<String> expectedPossibleMovesForRookGivenItsPositionAtA3 =
                Arrays.asList("A4", "A5", "A6", "A7", "A8", "B3",
                        "C3", "D3", "E3", "F3", "G3", "H3", "A2", "A1");
        Assertions.assertTrue(possibleMoves.containsAll(expectedPossibleMovesForRookGivenItsPositionAtA3));
        Assertions.assertEquals(14, possibleMoves.size());
    }

    @Test
    void shouldNotBeAbleToMoveDiagonalInAnyDirection() {
        List<String> possibleMoves = rook.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("B4"));
        Assertions.assertFalse(possibleMoves.contains("B2"));
    }

    @Test
    void shouldNotCrossTheBoundary() {
        List<String> possibleMoves = rook.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("A9"));
        Assertions.assertFalse(possibleMoves.contains("A0"));
        Assertions.assertFalse(possibleMoves.contains("I3"));
    }
}
package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KingTest {

    private King king;
    @Test
    void shouldBeAbleToMoveForwardBackwardLeftRightAndDiagonalMovesAsPerKingsMovementRules() {
        givenKingPositionAt('D', 5);
        List<String> possibleMoves = king.getPossibleMoves();
        checkWhetherValidPositionsAreReturned(possibleMoves);
    }

    @Test
    void kingShouldNotBeAbleToMoveBeyondBoundary(){
        givenKingPositionAt('H', 4);
        List<String> possibleMoves = king.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("I5"));
        Assertions.assertFalse(possibleMoves.contains("I4"));
        Assertions.assertFalse(possibleMoves.contains("I3"));
        Assertions.assertTrue(possibleMoves.contains("H5"));
        Assertions.assertTrue(possibleMoves.contains("H3"));
        Assertions.assertTrue(possibleMoves.contains("G3"));
        Assertions.assertTrue(possibleMoves.contains("G4"));
        Assertions.assertTrue(possibleMoves.contains("G5"));
        Assertions.assertEquals(5,possibleMoves.size());
    }

    @Test
    void kingShouldNotBeAbleToMoveMoreThanOneBlockAtaTime(){
        givenKingPositionAt('D', 1);
        List<String> possibleMoves = king.getPossibleMoves();
        Assertions.assertTrue(possibleMoves.contains("D2"));
        Assertions.assertFalse(possibleMoves.contains("D3"));
    }

    private void checkWhetherValidPositionsAreReturned(List<String> possibleMoves) {
        Assertions.assertTrue(possibleMoves.contains("C6"));
        Assertions.assertTrue(possibleMoves.contains("D6"));
        Assertions.assertTrue(possibleMoves.contains("E6"));
        Assertions.assertTrue(possibleMoves.contains("C5"));
        Assertions.assertTrue(possibleMoves.contains("E5"));
        Assertions.assertTrue(possibleMoves.contains("C4"));
        Assertions.assertTrue(possibleMoves.contains("D4"));
        Assertions.assertTrue(possibleMoves.contains("E4"));
        Assertions.assertEquals(8,possibleMoves.size());
    }

    private void givenKingPositionAt(char row, int column) {
         king =  new King(row, column);
    }
}
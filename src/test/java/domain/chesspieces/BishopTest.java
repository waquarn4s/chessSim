package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    private Bishop bishop =  new Bishop('A', 3);

    @Test
    void shouldBeAbleToMoveDiagonallyInAllDirectionAndAcrossTheBoard() {
        List<String> possibleMoves = bishop.getPossibleMoves();
        Assertions.assertTrue(possibleMoves.contains("B2"));
        Assertions.assertTrue(possibleMoves.contains("C1"));
        Assertions.assertTrue(possibleMoves.contains("B4"));
        Assertions.assertTrue(possibleMoves.contains("C5"));
        Assertions.assertTrue(possibleMoves.contains("D6"));
        Assertions.assertTrue(possibleMoves.contains("E7"));
        Assertions.assertTrue(possibleMoves.contains("F8"));
    }

    @Test
    void shouldNotBeAbleToMoveStraightInAnyDirection() {
        List<String> possibleMoves = bishop.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("A4"));
        Assertions.assertFalse(possibleMoves.contains("A2"));
        Assertions.assertFalse(possibleMoves.contains("B3"));
    }

    @Test
    void shouldNotCrossTheBoundary(){
        List<String> possibleMoves = bishop.getPossibleMoves();
        Assertions.assertFalse(possibleMoves.contains("G9"));
        Assertions.assertFalse(possibleMoves.contains("D0"));
    }
}
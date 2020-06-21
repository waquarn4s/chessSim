package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PawnTest {

    @Test
    void shouldBeAbleToMoveOnlyOneTileInForwardDirectionOnAnEmptyBoard() {
        Pawn pawn = new Pawn('B', 3);
        List<String> possibleMoves = pawn.getPossibleMoves();
        Assertions.assertTrue(possibleMoves.contains("B4"));
        Assertions.assertFalse(possibleMoves.contains("B5"));
        Assertions.assertEquals(1, possibleMoves.size());
    }

    @Test
    void shouldNotBeAbleToMoveAtAllIfAlreadyAtTheLastRow() {
        Pawn pawn = new Pawn('B', 8);
        List<String> possibleMoves = pawn.getPossibleMoves();
        Assertions.assertTrue(possibleMoves.isEmpty());
    }
}
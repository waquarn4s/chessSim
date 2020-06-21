package domain.chesspieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HorseTest {
    private Horse horse;

    @Test
    void shouldBeAbleToMoveOnlyTwoStepsStraightAndOneStepTurnInOneMoveInAnyDirection() {
        givenHorsePositionAt('E', 3);
        List<String> possibleMoves = horse.getPossibleMoves();
        List<String> expectedPossibleMovesForHorseGivenItsPositionAtE3 =
                Arrays.asList("D5", "F5", "D1", "F1", "C2", "C4", "G2", "G4");
        Assertions.assertTrue(possibleMoves.containsAll(expectedPossibleMovesForHorseGivenItsPositionAtE3));
        Assertions.assertEquals(8, possibleMoves.size());
    }

    @Test
    void shouldNotBeAbleToMoveStraightOrDiagonalInAnyDirection() {
        givenHorsePositionAt('E', 3);
        List<String> possibleMoves = horse.getPossibleMoves();
        List<String> expectedPossibleMovesForHorseGivenItsPositionAtE3 =
                Arrays.asList("E4", "E5", "F4", "G5", "F3", "G3", "F2", "G1",
                "E2", "E1", "D2", "C1", "D3", "C3", "D4", "C5");
        Assertions.assertFalse(possibleMoves.containsAll(expectedPossibleMovesForHorseGivenItsPositionAtE3));
    }

    @Test
    void shouldNotBeAbleToMoveBeyondBoundary() {
        givenHorsePositionAt('H', 4);
        List<String> possibleMoves = horse.getPossibleMoves();
        List<String> expectedReducedPossibleMovesDueToBoundaryAtOneSideGivenHorsePositionAtH4 =
                Arrays.asList("F5", "G6", "G2", "F3");
        Assertions.assertTrue(possibleMoves
                .containsAll(expectedReducedPossibleMovesDueToBoundaryAtOneSideGivenHorsePositionAtH4));
        Assertions.assertEquals(4, possibleMoves.size());
    }

    private void givenHorsePositionAt(char row, int column) {
        horse =  new Horse(row, column);
    }
}
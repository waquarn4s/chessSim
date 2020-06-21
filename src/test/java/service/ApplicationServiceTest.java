package service;

import exception.ChessPieceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ApplicationServiceTest {

    private final ApplicationService applicationService = new ApplicationService();

    @Test
    void shouldThrowExceptionIfIncorrectPieceIsGivenAsInput() {
        Assertions.assertThrows(ChessPieceException.class,
                () -> applicationService.getMovesFor("Camel D5"));
    }

    @Test
    void shouldThrowExceptionIfIncorrectPositionIsGivenAsInput() {
        Assertions.assertThrows(ChessPieceException.class,
                () -> applicationService.getMovesFor("King DX1"));
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForBishopWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("Bishop D5");
        Assertions.assertEquals(13, moves.size());
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForKingWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("King D5");
        Assertions.assertEquals(8, moves.size());
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForQueenWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("Queen D5");
        Assertions.assertEquals(27, moves.size());
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForPawnWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("Pawn D5");
        Assertions.assertEquals(1, moves.size());
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForRookWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("Rook D5");
        Assertions.assertEquals(14, moves.size());
    }

    @Test
    void shouldReturnCorrectNumberOfPossibleMovesForHorseWhenGivenCorrectCenterPosition() throws ChessPieceException {
        List<String> moves = applicationService.getMovesFor("Horse D5");
        Assertions.assertEquals(8, moves.size());
    }
}
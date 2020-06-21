package domain.chesspieces;

import service.MovesService;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.ACROSS_THE_BOARD;

public class Bishop {
    private MovesService movesService = new MovesService();
    private char row;
    private int column;

    public Bishop(char currentRow, int currentColumn) {
        this.row = currentRow;
        this.column = currentColumn;
    }

    public List<String> getPossibleMoves() {
        List<String> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(movesService.getDiagonalForwardRightMovesFrom(row, column, ACROSS_THE_BOARD));
        possibleMoves.addAll(movesService.getDiagonalBackwardRightMovesFrom(row, column, ACROSS_THE_BOARD));
        possibleMoves.addAll(movesService.getDiagonalBackwardLeftMovesFrom(row, column, ACROSS_THE_BOARD));
        possibleMoves.addAll(movesService.getDiagonalForwardLeftMovesFrom(row, column, ACROSS_THE_BOARD));
        return possibleMoves;
    }
}

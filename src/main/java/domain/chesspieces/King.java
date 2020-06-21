package domain.chesspieces;

import service.MovesService;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.ONE_STEP_FURTHER;

public class King {
    private MovesService movesService = new MovesService();
    private char row;
    private int column;

    public King(char currentRow, int currentColumn) {
        this.row = currentRow;
        this.column = currentColumn;
    }

    public List<String> getPossibleMoves() {

        List<String> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(movesService.getForwardMovesFrom(row, column , ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getDiagonalForwardRightMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getRightMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getDiagonalBackwardRightMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getBackwardMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getDiagonalBackwardLeftMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getLeftMovesFrom(row, column, ONE_STEP_FURTHER));
        possibleMoves.addAll(movesService.getDiagonalForwardLeftMovesFrom(row, column, ONE_STEP_FURTHER));
        return possibleMoves;
    }
}

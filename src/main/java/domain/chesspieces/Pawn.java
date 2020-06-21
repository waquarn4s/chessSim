package domain.chesspieces;

import service.MovesService;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.ONE_STEP_FURTHER;

public class Pawn {

    private char row;
    private int column;

    public Pawn(char currentRow, int currentColumn) {
        this.row = currentRow;
        this.column = currentColumn;
    }
    private MovesService movesService = new MovesService();

    public List<String> getPossibleMoves() {
        return new ArrayList<>(movesService.getForwardMovesFrom(row, column, ONE_STEP_FURTHER));
    }
}

package domain.chesspieces;

import service.MovesService;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.upperA;
import static utility.Utility.upperH;

public class Horse {
    private MovesService movesService = new MovesService();
    private char row;
    private int column;

    public Horse(char row, int column) {
        this.row = row;
        this.column = column;
    }

    public List<String> getPossibleMoves() {
        List<String> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(getHorseForwardMoves());
        possibleMoves.addAll(getHorseBackwardMoves());
        possibleMoves.addAll(getHorseLeftMoves());
        possibleMoves.addAll(getHorseRightMoves());
        return possibleMoves;
    }

    private List<String> getHorseForwardMoves() {
        List<String> possibleForwardMoves = new ArrayList<>();
        int newColumnPosition = moveTwoStepForwardFrom(column);
        if (newColumnPosition != 0) {
            possibleForwardMoves.addAll(movesService.getLeftMovesFrom(row, newColumnPosition, 1));
            possibleForwardMoves.addAll(movesService.getRightMovesFrom(row, newColumnPosition, 1));
        }
        return possibleForwardMoves;
    }

    private List<String> getHorseBackwardMoves() {
        List<String> possibleBackwardMoves = new ArrayList<>();
        int newColumnPosition = moveTwoStepBackwardFrom(column);
        if (newColumnPosition != 0) {
            possibleBackwardMoves.addAll(movesService.getLeftMovesFrom(row, newColumnPosition, 1));
            possibleBackwardMoves.addAll(movesService.getRightMovesFrom(row, newColumnPosition, 1));
        }
        return possibleBackwardMoves;
    }

    private List<String> getHorseLeftMoves() {
        List<String> possibleLeftMoves = new ArrayList<>();
        char newRowPosition = moveTwoStepsLeftFrom(row);
        if (newRowPosition != row) {
            possibleLeftMoves.addAll(movesService.getForwardMovesFrom(newRowPosition, column, 1));
            possibleLeftMoves.addAll(movesService.getBackwardMovesFrom(newRowPosition, column, 1));
        }
        return possibleLeftMoves;
    }

    private List<String> getHorseRightMoves() {
        List<String> possibleRightMoves = new ArrayList<>();
        char newRowPosition = moveTwoStepsRightFrom(row);
        if (newRowPosition != row) {
            possibleRightMoves.addAll(movesService.getForwardMovesFrom(newRowPosition, column, 1));
            possibleRightMoves.addAll(movesService.getBackwardMovesFrom(newRowPosition, column, 1));
        }
        return possibleRightMoves;
    }

    private int moveTwoStepForwardFrom(int column) {
        return column + 2 < 9 ? column + 2 : 0;
    }

    private int moveTwoStepBackwardFrom(int column) {
        return column - 2 > 0 ? column - 2 : 0;
    }

    private char moveTwoStepsLeftFrom(char row) {
        char newPos = (char) (row - 2);
        return newPos >= upperA ? newPos : row;
    }

    private char moveTwoStepsRightFrom(char row) {
        char newPos = (char) (row + 2);
        return newPos <= upperH ? newPos : row;
    }

        /* private boolean rowPositionIsInBetweenAtoH(char row) {
         return (row > upperA && row < upperH || row > lowerA && row < lowerH);
     }
 */
}
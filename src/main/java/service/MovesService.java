package service;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.*;

public class MovesService {
    public List<String> getForwardMovesFrom(char row, int column, int range) {
        List<String> possibleForwardMoves = new ArrayList<>();
        while(range!= 0 && column<8){
            possibleForwardMoves.add(""+row + ++column);
            range--;
        }
        return possibleForwardMoves;
    }

    public List<String> getBackwardMovesFrom(char row, int column, int range) {
        List<String> possibleBackwardMoves = new ArrayList<>();
        while(range!= 0 && column>1){
            possibleBackwardMoves.add(""+row + --column);
            range--;
        }
        return possibleBackwardMoves;
    }

    public List<String> getLeftMovesFrom(char row, int column, int range) {
        List<String> possibleLeftMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToA(row)){
            possibleLeftMoves.add(""+ --row + column);
            range--;
        }
        return possibleLeftMoves;
    }

    public List<String> getRightMovesFrom(char row, int column, int range) {
        List<String> possibleRightMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToH(row)){
            possibleRightMoves.add(""+ ++row + column);
            range--;
        }
        return possibleRightMoves;
    }


    public List<String> getDiagonalForwardRightMovesFrom(char row, int column, int range) {
        List<String> possibleDiagonalForwardRightMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToH(row) && column<8){
            possibleDiagonalForwardRightMoves.add(""+ ++row + ++column);
            range--;
        }
        return possibleDiagonalForwardRightMoves;
    }



    public List<String> getDiagonalBackwardRightMovesFrom(char row, int column, int range) {
        List<String> possibleDiagonalBackwardRightMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToH(row) && column>1){
            possibleDiagonalBackwardRightMoves.add(""+ ++row + --column);
            range--;
        }
        return possibleDiagonalBackwardRightMoves;
    }

    public List<String> getDiagonalForwardLeftMovesFrom(char row, int column, int range) {
        List<String> possibleDiagonalForwardLeftMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToA(row) && column<8){
            possibleDiagonalForwardLeftMoves.add(""+ --row + ++column);
            range--;
        }
        return possibleDiagonalForwardLeftMoves;
    }

    public List<String> getDiagonalBackwardLeftMovesFrom(char row, int column, int range) {
        List<String> possibleDiagonalBackwardLeftMoves = new ArrayList<>();
        while(range!= 0 && rowPositionIsNotEqualToA(row) && column>1){
            possibleDiagonalBackwardLeftMoves.add(""+ --row + --column);
            range--;
        }
        return possibleDiagonalBackwardLeftMoves;
    }

    private boolean rowPositionIsNotEqualToH(char row) {
        return row != upperH;
    }

    private boolean rowPositionIsNotEqualToA(char row) {
        return row != upperA;
    }
}
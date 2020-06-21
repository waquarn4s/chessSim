package service;

import domain.chesspieces.*;
import exception.ChessPieceException;

import java.util.List;

import static utility.Utility.SPACE_SEPARATED_DELIMITER;
import static utility.Utility.validate;

public class ApplicationService {
    private char currentRowPosition;
    private int currentColumnPosition;

    public List<String> getMovesFor(String userInputString) {
        String[] input = userInputString.split(SPACE_SEPARATED_DELIMITER);
        String chessPiece = input[0];
        extractCurrentRowAndColumnPositionsFrom(input);
        List<String> availableMoves;

        if (chessPiece.equalsIgnoreCase("Bishop")) {
            availableMoves = new Bishop(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else if (chessPiece.equalsIgnoreCase("King")) {
            availableMoves = new King(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else if (chessPiece.equalsIgnoreCase("Queen")) {
            availableMoves = new Queen(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else if (chessPiece.equalsIgnoreCase("Horse")) {
            availableMoves = new Horse(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else if (chessPiece.equalsIgnoreCase("Rook")) {
            availableMoves = new Rook(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else if (chessPiece.equalsIgnoreCase("Pawn")) {
            availableMoves = new Pawn(currentRowPosition, currentColumnPosition).getPossibleMoves();
        } else {
            throw new ChessPieceException("You entered an invalid piece. please enter any piece from the following:" +
                    "King, Queen, Bishop, Rook, Horse, Pawn");
        }
        return availableMoves;
    }

    private void extractCurrentRowAndColumnPositionsFrom(String[] input) throws ChessPieceException {
        String currentPosition;
        try {
            currentPosition = input[1];
            validate(currentPosition);
            currentRowPosition = currentPosition.charAt(0);
            currentColumnPosition = Integer.parseInt(currentPosition.substring(1));
        } catch (Exception exception) {
            throw new ChessPieceException(exception.getMessage());
        }
    }
}
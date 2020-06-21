package utility;

import exception.ChessPieceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private Utility() {
    }

    private static final String VALID_INPUT_REGEX_FOR_POSITION_ON_A_CHESS_BOARD = "^[ABCDEFGH][12345678]$";
    public static final String SPACE_SEPARATED_DELIMITER = " ";
    public static final String COMMA_SEPARATED_DELIMITER = ", ";
    public static final int ONE_STEP_FURTHER = 1;
    public static final int ACROSS_THE_BOARD = 7;
    public static final char upperA = 'A';
    public static final char upperH = 'H';

    public static void validate(String currentPosition){
        Pattern pattern = Pattern.compile(VALID_INPUT_REGEX_FOR_POSITION_ON_A_CHESS_BOARD);
        Matcher m = pattern.matcher(currentPosition);
        if (!m.find()) {
            throw new ChessPieceException("Please Enter valid current position in the range of rows A-H followed by columns 1-8");
        }
    }
}
package utility;

import exception.ChessPieceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilityTest {

    @Test
    void shouldThrowExceptionForInvalidInput() {
        Assertions.assertThrows(ChessPieceException.class, () -> Utility.validate("A0"));
        Assertions.assertThrows(ChessPieceException.class, () -> Utility.validate("A9"));
        Assertions.assertThrows(ChessPieceException.class, () -> Utility.validate("I1"));
        Assertions.assertThrows(ChessPieceException.class, () -> Utility.validate("-8"));
        Assertions.assertThrows(ChessPieceException.class, () -> Utility.validate("AH12"));
    }

    @Test
    void shouldNotThrowExceptionForValidInput() {
        Assertions.assertDoesNotThrow(() -> Utility.validate("A1"));
        Assertions.assertDoesNotThrow(() -> Utility.validate("H8"));
        Assertions.assertDoesNotThrow(() -> Utility.validate("D4"));
    }
}
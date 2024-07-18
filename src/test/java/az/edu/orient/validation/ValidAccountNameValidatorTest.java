package az.edu.orient.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAccountNameValidatorTest {

    ValidAccountNameValidator validator = new ValidAccountNameValidator();

    @Test
    void isValidGivenOnlyDigitValuesThenReturnFalse() {
        //setup
        String value = "123456";
        //when
        boolean result = validator.isValid(value, null);
        //expect
        assertFalse(result);
    }

    @Test
    void isValidGivenNotOnlyLetterValuesThenReturnFalse() {
        String value="123aa!*%";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }
    @Test
    void isValidGivenOnlyLetterValuesThenReturnTrue() {
        String value="Nurlan";
        boolean result = validator.isValid(value, null);
        assertTrue(result);
    }
    @Test
    void isValidGivenValueLessThanFourThenReturnFalse() {
        String value="Ali";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }
    @Test
    void isValidGivenValueBiggerThan20ThenReturnFalse() {
        String value="dwasdakskmdamdsandadnandakjddsad";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }

}
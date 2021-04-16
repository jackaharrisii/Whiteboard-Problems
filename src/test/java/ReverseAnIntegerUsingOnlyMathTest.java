import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseAnIntegerUsingOnlyMathTest {

    ReverseAnIntegerUsingOnlyMath math = new ReverseAnIntegerUsingOnlyMath();

    @Test
    public void reverse_an_integer(){
        // Given
        Integer test = 956;
        Integer expected = 659;
        // When
        Integer actual = math.reverseInteger(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void dont_change_a_single_digit_integer(){
        // Given
        Integer test = 5;
        Integer expected = 5;
        // When
        Integer actual = math.reverseInteger(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void dont_crash_when_fed_a_zero(){
        // Given
        Integer test = 0;
        Integer expected = 0;
        // When
        Integer actual = math.reverseInteger(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_a_negative_integer(){
        // Given
        Integer test = -1875;
        Integer expected = -5781;
        // When
        Integer actual = math.reverseInteger(test);
        // Then
        assertEquals(expected, actual);
    }

    //Testing with a For loop
    @Test
    public void reverse_an_integer_forLoop(){
        // Given
        Integer test = 956;
        Integer expected = 659;
        // When
        Integer actual = math.reverseIntForLoop(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void dont_change_a_single_digit_integer_forLoop(){
        // Given
        Integer test = 5;
        Integer expected = 5;
        // When
        Integer actual = math.reverseIntForLoop(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void dont_crash_when_fed_a_zero_forLoop(){
        // Given
        Integer test = 0;
        Integer expected = 0;
        // When
        Integer actual = math.reverseIntForLoop(test);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_a_negative_integer_forLoop(){
        // Given
        Integer test = -1875;
        Integer expected = -5781;
        // When
        Integer actual = math.reverseIntForLoop(test);
        // Then
        assertEquals(expected, actual);
    }
}
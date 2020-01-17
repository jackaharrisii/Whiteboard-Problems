
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortStringNumbersTest {

    SortStringNumbers sort = new SortStringNumbers();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
     NORMAL CASES
     */

    @Test
    public void sort_single_digit_numbers(){
        // Given
        String[] testArray = new String[]{"1", "5", "9", "4"};
        String[] expected = new String[]{"1", "4", "5", "9"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    // no edge cases
    public void sort_a_normal_list(){
        // Given
        String[] testArray = new String[]{"1", "5", "15", "9", "4"};
        String[] expected = new String[]{"1", "4", "5", "9", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }



    /*
    EDGE CASES
     */

    @Test
    public void sort_a_list_that_includes_leading_zeroes(){
        // Given
        String[] testArray = new String[]{"001", "5", "15", "09", "4"};
        String[] expected = new String[]{"001", "4", "5", "09", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_that_includes_one_negative_number(){
        // Given
        String[] testArray = new String[]{"1", "5", "15", "-9", "4"};
        String[] expected = new String[]{"-9", "1", "4", "5", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_that_includes_multiple_negative_numbers(){
        // Given
        String[] testArray = new String[]{"1", "-5", "15", "-9", "4"};
        String[] expected = new String[]{"-9", "-5", "1", "4", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_that_includes_negative_numbers_with_leading_zeroes(){
        // Given
        String[] testArray = new String[]{"1", "-005", "15", "-9", "4"};
        String[] expected = new String[]{"-9", "-005", "1", "4", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_that_includes_decimals(){
        // Given
        String[] testArray = new String[]{"1", "5.0", "15", "9", "5.0001"};
        String[] expected = new String[]{"1", "5.0", "5.0001", "9", "15"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_and_remove_words_that_arent_numbers(){
        // Given
        String[] testArray = new String[]{"1", "cat", "5"};
        String[] expected = new String[]{"", "1", "5"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void sort_a_list_that_includes_spelled_out_numbers(){
        // Given
        String[] testArray = new String[]{"1", "ten thousand", "5", "11,000", "nine thousand nine hundred and ninety nine", "15", "nine", "4", "a million"};
        String[] expected = new String[]{"1", "4", "5", "nine", "15", "nine thousand nine hundred and ninety nine", "ten thousand", "11,000", "a million"};
        // When
        sort.sortStringNumbers(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    /*
     SUB-METHOD TESTS:
     */

    @Test
    public void bubbleSortByStringLength_Test(){
        // Given
        String[] testArray = new String[]{"a", "aaaa", "aaa", "aaaaa", "aa"};
        String[] expected = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"};
        // When
        sort.bubbleSortByStringLength(testArray);
        // Then
        assertArrayEquals(expected,testArray);
    }

    @Test
    public void removeLeadingZeroes_normal(){
        // Given
        String test = "007";
        String expected = "7";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeLeadingZeroes_when_none_exist(){
        // Given
        String test = "7";
        String expected = "7";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeLeadingZeroes_from_000(){
        // Given
        String test = "000";
        String expected = "0";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeLeadingZeroes_from_0(){
        // Given
        String test = "0";
        String expected = "0";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeLeadingZeroes_from_empty_string(){
        // Given
        String test = "";
        String expected = "0";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeLeadingZeroes_from_negative_number(){
        // Given
        String test = "-007";
        String expected = "-7";
        // When
        test = sort.removeLeadingZeroes(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void currentIsLonger_when_no_decimals(){
        // Given
        String current = "17";
        String previous = "7";
        // Then
        assertTrue(sort.currentIsLonger(current, previous));
    }

    @Test
    public void currentIsShorter_when_no_decimals(){
        // Given
        String current = "17";
        String previous = "7";
        // Then
        assertFalse(sort.currentIsShorter(current, previous));
    }

    @Test
    public void currentIsLonger_with_decimals(){
        // Given
        String current = "17.05";
        String previous = "3.14159";
        // Then
        assertTrue(sort.currentIsLonger(current, previous));
    }

    @Test
    public void currentIsShorter_with_decimals(){
        // Given
        String current = "17.05";
        String previous = "3.14159";
        // Then
        assertFalse(sort.currentIsShorter(current, previous));
    }

    @Test
    public void removeDecimals_from_positive_number(){
        // Given
        String test = "3.14159";
        String expected = "3";
        // When
        test = sort.removeDecimals(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeDecimals_from_negative_number(){
        // Given
        String test = "-3.14159";
        String expected = "-3";
        // When
        test = sort.removeDecimals(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeDecimals_with_extra_decimals(){
        // Given
        String test = "3.14.159";
        String expected = "3";
        // When
        test = sort.removeDecimals(test);
        // Then
        assertEquals(expected, test);
    }

    @Test
    public void removeNonNumberWords_simple(){
        // Given
        String[] test = {"3", "cat", "5"};
        String[] expected = {"3", "", "5"};
        // When
        test = sort.replaceNonNumberWords(test);
        // Then
        assertArrayEquals(expected, test);
    }

    @Test
    public void removeNonNumberWords_all_original_data_valid(){
        // Given
        String[] test = {"3", "5"};
        String[] expected = {"3", "5"};
        // When
        test = sort.replaceNonNumberWords(test);
        // Then
        assertArrayEquals(expected, test);
    }

    @Test
    public void aNumber_using_number(){
        // Given
        String test = "9";
        // Then
        assertTrue(sort.aNumber(test));
    }

    @Test
    public void aNumber_using_word(){
        // Given
        String test = "cat";
        // Then
        assertFalse(sort.aNumber(test));
    }

    @Test
    public void aNumber_using_mixed_letters_and_numbers(){
        // Given
        String test = "9aQ";
        // Then
        assertFalse(sort.aNumber(test));
    }

    @Test
    public void aNumber_using_negative_number(){
        // Given
        String test = "-9";
        // Then
        assertTrue(sort.aNumber(test));
    }

    @Test
    public void aNumber_using_decimal(){
        // Given
        String test = "9.5";
        // Then
        assertTrue(sort.aNumber(test));
    }

}
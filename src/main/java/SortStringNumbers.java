
/*
Given: an array of numbers as strings, i.e., {"1", "5", "15", "9", "4"}
Task: sort the numbers
Restriction: the numbers must stay strings - no converting to integers

Edge Cases:
- negative numbers
- leading zeroes
- decimals

Bleeding Edge Case and Data Validation:
- replace words from array which are not numbers with a blank string "", i.e., {"1", "cat", "5"} returns {"", "1", "5"}
- number is spelled out ("nine" instead of "9") <- not sure how to get this one so far, but probably a really thorough regex.....
- fractions

*/

import java.util.ArrayList;

public class SortStringNumbers {

/* this method works fine before the edge cases, but I need a more custom comparator to account for the edge cases

    Sorting sorting = new Sorting();

    public void sortStringNumbers(String[] input){
        sorting.bubbleSortGeneric(input);
        bubbleSortByStringLength(input);
    }

*/

    // Strategy - use insertion sort this time, but with a custom comparator
    public void sortStringNumbers(String[] values){
        values = replaceNonNumberWords(values);
        for (int i = 1; i < values.length; i++){
            String current = values[i];                           // current represents the value that is moving
            int j =i-1;                                           // j represents the index of the next value to compare current against
            while(j >= 0 && currentIsLessThanPrevious(current, values[j])) {   // this loop keep going until either current is less than the value at j, or it reaches the start of the array
                values[j+1]= values[j];
                j--;
            }
            values[j+1] = current;                                // this line inserts current into the now empty index of the array
        }
    }

    // CUSTOM COMPARATOR
    public boolean currentIsLessThanPrevious(String current, String previous){
        // remove leading zeroes
        current = removeLeadingZeroes(current);
        previous = removeLeadingZeroes(previous);
        // if one number is negative and the other is positive
        if (current.charAt(0) == '-' && previous.charAt(0) != '-') return true;
        if (current.charAt(0) != '-' && previous.charAt(0) == '-') return false;
        // if both numbers are negative
        if (current.charAt(0) == '-' && previous.charAt(0) == '-'){
            // compare lengths
            if (current.length() > previous.length()) return true;
            else if (current.length() < previous.length()) return false;
            // if the same length, compare values
            if (current.compareTo(previous) < 0) return false;
            else return true;
        }
        // if both numbers are positive
        if (current.charAt(0) != '-' && previous.charAt(0) != '-') {
            // compare lengths
            if (currentIsLonger(current, previous)) return false;
            else if (currentIsShorter(current, previous)) return true;
            // if the same length, compare values
            if (current.compareTo(previous) < 0) return true;
            else return false;
        }
        return false;
    }

    // SUB-METHODS FOR THE ABOVE METHODS

    public String[] replaceNonNumberWords(String[] input){
        for (int i = 0; i < input.length; i++){
            if (!aNumber(input[i])) input[i] = "";
        }
        return input;
    }

    public Boolean aNumber(String input){
        if (input.matches("-?\\d+\\.?\\d*")) return true;
        else return false;
    }

    public Boolean currentIsLonger(String current, String previous){
        current = removeDecimals(current);
        previous = removeDecimals(previous);
        if (current.length() > previous.length()) return true;
        else return false;
    }

    public Boolean currentIsShorter(String current, String previous){
        current = removeDecimals(current);
        previous = removeDecimals(previous);
        if (current.length() < previous.length()) return true;
        else return false;
    }

    public String removeDecimals(String input){
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') return input.substring(0, i);
        }
        return input;
    }

    public String removeLeadingZeroes(String input){
        boolean isNegative = false;
        if (input.length() == 0) return "0";
        // saves the negative for later
        if (input.charAt(0) == '-') {
            input = input.substring(1, input.length());
            isNegative = true;
        }
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) != '0') {
                if (isNegative) return "-" + input.substring(i, input.length());
                else return input.substring(i, input.length());
            }
        }
        return "0";
    }

    public String removeSpaces(String input){
        // do some stuff here
        return "";
    }

    public void bubbleSortByStringLength(String[] a){
        boolean sorted = false;
        String temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.length -1; i++){
                if (a[i].length() > a[i+1].length()){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public String makeFractionComparable(String input){
        // no idea how to solve this without math
        return "";
    }

}

/*
Given: any integer
Task: reverse the integer using only math
Requirements: this should work for integers >0, <0, and ==0
 */

public class ReverseAnIntegerUsingOnlyMath {

    public Integer reverseInteger(Integer num){
        Integer output = 0;
        while(num != 0){
            output = (output * 10) + (num % 10);
            num /= 10;
        }
        return output;
    }

}

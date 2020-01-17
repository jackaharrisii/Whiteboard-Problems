/*
Given: an array of numbers
Task: add up the sums of all possible sub arrays

Example: {1, 2, 3, 4}
+1
+1+2
+1+2+3
+1+2+3+4
+2
+2+3
+2+3+4
+3
+3+4
+4
=50
 */

public class CompoundSumFromSubArrays {

    /*  FIRST SOLUTION I ATTEMPTED ON HACKERRANK
    this was question 19 on the Zip Code admissions assessment
    I passed 5 tests out of 13, because the processing time was too slow
    *** please don't try to solve the problem this way ***
     */
    public Integer solveWithForLoops(Integer[] input){
        Integer sum = 0;
        for (int i = 0; i < input.length; i++){
            for (int j = i; j < input.length; j++){
                for (int k = i; k <= j; k++){
                    sum += input[k];
                }
            }
        }
        return sum;
    }

/*
THIS WAS MY SECOND SOLUTION ON HACKERRANK
when I realized that HackerRank allows the tester to put a restriction on processing time,
it became clear why I was failing tests.
I got out some scratch paper and figured out that there is a pattern to the number of occurrences for each number
1 - the occurrences are on a bell curve
2 - further, the occurrences are palindromic
I figured out the formula below:
 */

    public Integer solveWithMath(Integer[] input){
        Integer sum = 0;
        for(int i = 0; i < input.length; i++)
            sum += input[i] * (i+1) * (input.length - i);
        return sum;
    }

/*
The above passed 12 of 13 tests on HackerRank, and I couldn't figure out what was causing the last test to fail
It wasn't until after starting Zip Code that I found out that Integers have a max storage size
 */

    public Long solveWithLong(Integer[] input){
        Long sum = 0L;
        for(int i = 0; i < input.length; i++)
            sum += input[i] * (i+1) * (input.length - i);
        return sum;
    }

/*
To quantify the difference in efficiency, run the tests and look at the processing times
I'm looking at:
nested for loops with 500 numbers - 142 ms
nested for loops with 1000 numbers - 921 ms
math with 500 numbers - 0 ms
math with 1000 numbers - 1 ms
*/
}

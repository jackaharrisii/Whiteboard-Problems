import java.util.HashMap;
import java.util.Hashtable;

/* This is a question that came up as a common interview question from Google
https://medium.com/better-programming/solving-googles-most-frequently-asked-whiteboarding-question-1c2eacaf1523

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

 */
public class CheckArrayForSum {

    public Integer[] findIndexesWithNestedForLoops(Integer[] nums, Integer target){
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (i != j && nums[i] + nums[j] == target) return new Integer[]{i, j};
            }
        }
        return null;
    }

    public Integer[] findIndexesWithHashTable(Integer[] nums, Integer target){
        Hashtable<Integer,Integer> numTable = new Hashtable<>();
        // don't build the hashtable first - if you do, and the target is even, it can erroneously return the index of terget/2 for both values if it finds that in nums
//        for (int i = 0; i < nums.length; i++){
//            numTable.put(nums[i], i);
//        }
        for (int j = 0; j < nums.length; j++){
            int desiredValue = target - nums[j];
            // (putting "numTable.put(nums[j], j);" here will have the same result as the above commented out code
            if (numTable.containsKey(desiredValue)) return new Integer[]{numTable.get(desiredValue), j};
            numTable.put(nums[j], j);  // you must only insert the value into the hashtable after the check
        }
        return null;
    }

    // only works with pre-sorted array
    public Integer[] findIndexesWithSingleLoop(Integer[] nums, Integer target){
        int i = 0;
        int j = nums.length-1;
        while (j > i) {
            while (nums[i] + nums[j] != target) {
                if (nums[i] + nums[j] > target) j--;
                else if (nums[i] + nums[j] < target) i++;
            }
            return new Integer[]{i, j};
        }
        return null;
    }

}

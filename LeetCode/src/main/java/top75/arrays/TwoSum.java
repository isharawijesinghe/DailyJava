package top75.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * LeetCode 1. Two Sum
     * **/
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> keyMap = new HashMap<>();
        int[] output = new int[2];

        for (int i= 0; i < nums.length; i++){
            int remaining = target - nums[i];
            if (keyMap.containsKey(remaining)){
                int index = keyMap.get(remaining);
                output[0] =  index;
                output[1] =  i;
                return output;
            }
            keyMap.put(nums[i], i);
        }
        return output;

    }

    public static void main(String[] args) {
        int[] input = {3,3};
        System.out.println(Arrays.toString(twoSum(input, 6)));
    }

}

package top75.arrays;

import java.util.HashMap;

public class ContainsDuplicate {

    /**
     * LeetCode 121. Best Time to Buy and Sell Stock
     * **/
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i =0 ; i < nums.length; i++){
            if (countMap.get(nums[i]) != null && countMap.get(nums[i]) == 1){
                return true;
            }
            countMap.put(nums[i], 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        System.out.printf(String.valueOf(containsDuplicate(input)));
    }
}

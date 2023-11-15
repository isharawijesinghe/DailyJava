package top75.arrays;

import top75.twopointers.PivotIndex;

public class WaysToSplitArrays {

    public int waysToSplitArray(int[] nums) {

        long[] leftArray = new long[nums.length];

        long sum =0;
        int validSplit = 0;

        for (int i=0; i<= nums.length -1; i++){
            sum = sum + nums[i];
            leftArray[i] = sum;
        }

        sum =0;

        for (int i= nums.length -1; i >0; i--){
            sum = sum + nums[i];

            if (sum <= leftArray[i-1]){
                validSplit++;
            }
        }

        return validSplit;

    }

    public static void main(String[] args) {

        int x = -3 + (-2);
        System.out.println(x);
        WaysToSplitArrays waysToSplitArrays = new WaysToSplitArrays();

        int[] input = {9,9,9};
        System.out.println(waysToSplitArrays.waysToSplitArray(input));
    }

}

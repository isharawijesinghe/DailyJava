package top75.twopointers;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int[] response = new int[1];
        int leftPointer = -1;
        int rightPointer = nums.length;
        int leftCount = 0;
        int rightCount = 0;
        while ((leftPointer)  < (rightPointer)){
            if ((leftCount + nums[leftPointer]) == (rightCount +  nums[rightPointer])){
                leftCount =  leftCount + nums[leftPointer];
                rightCount =  rightCount + nums[rightPointer];
                leftPointer++;
                rightPointer--;
            } else if ((leftCount + nums[leftPointer]) > (rightCount +  nums[rightPointer])) {
                rightCount =  rightCount + nums[rightPointer];
                rightPointer--;
            } else {
                leftCount =  leftCount + nums[leftPointer];
                leftPointer++;
            }
        }

        if ((leftCount - nums[leftPointer] == rightCount - nums[leftPointer]) ){
            return response[0] = leftPointer;
        }
        return response[0] = -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();

        int[] input = {1,2,3};
        System.out.println(pivotIndex.pivotIndex(input));
    }

}

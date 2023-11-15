package top75.twopointers;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int[] response = new int[1];
        int leftPointer = 0;
        int rightPointer = nums.length -1;
        int leftCount = 0;
        int rightCount = 0;

        while ((rightPointer) - (leftPointer)  >= 2){
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

    public int pivotIndex1(int[] nums) {
        int[] response = new int[1];
        int leftPointer = 0;
        int rightPointer = nums.length -1;
        int leftCount = nums[leftPointer];
        int rightCount = nums[rightPointer];


        while (rightPointer-leftPointer != 2){
            if (leftCount <= rightCount){
                leftPointer++;
                leftCount = leftPointer + nums[leftPointer];
            } else {
                rightPointer--;
                rightCount =  rightCount + nums[rightPointer];
            }
        }

        if (leftCount == rightCount){
            return response[0] = leftPointer + 1;
        }
        return response[0] = -1;
    }

    public int pivotIndex2(int[] nums) {
        int positionIndex = -1;
        int[] sumListFromLeft = new int[nums.length];
        int sum =0;
        for (int i=0; i <= nums.length -1; i++){
            sumListFromLeft[i] = sum;
            sum = sum + nums[i];
        }

        sum = 0;

        for (int i= nums.length -1; i >=0; i--){
            if (sumListFromLeft[i] == sum){
                positionIndex = i;
            }
            sum = sum + nums[i];
        }

        return positionIndex;

    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();

        int[] input = {2,1,-1};
        System.out.println(pivotIndex.pivotIndex2(input));
    }

}

package top75.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {


        while (k > nums.length){
            k = k - nums.length;
        }


        int[] copyArray = new int[nums.length];
        for (int i =0 ; i <= nums.length-1; i++){
            copyArray[i] = nums[i];
        }

        int index = 0;
        int breakPoint = nums.length - k;

        for (int i = breakPoint; i <= nums.length-1; i++){
            nums[index] = copyArray[i];
            index++;
        }

        for (int i = 0; i <= breakPoint-1; i++){
            nums[index] = copyArray[i];
            index++;
        }

    }

}

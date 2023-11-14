package top75.arrays;

import java.lang.reflect.Array;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int[] duplicateArray = new int[nums.length];

        int position = 0;
        for (int i=0; i <= nums.length-1; i++){
            if (nums[i] != 0){
                duplicateArray[position] = nums[i];
                position++;
            }
            nums[i] = 0;
        }

        for (int i=0; i <= duplicateArray.length-1; i++){
            nums[i] = duplicateArray[i];
        }
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] num1 = {0,1,0,3,12};
        mz.moveZeroes(num1);
        for (int i=0; i <= num1.length-1; i++){
            System.out.println(num1[i]);
        }
    }

}

package top75.arrays;

public class JumpGame {

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int position){
        if (nums.length <= position + 1){
            return true;
        } else {
            int jumps = nums[position];
            for (int i = 1; i<= jumps; i++){
                if(canJump(nums, position + i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] num1 = {2,0,0};
        System.out.println(jg.canJump(num1));
    }
}

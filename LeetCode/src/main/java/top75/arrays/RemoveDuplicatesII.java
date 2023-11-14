package top75.arrays;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();

        for (int i =0; i <= nums.length -1; i++){
            if (lhm.containsKey(nums[i]) && lhm.get(nums[i]) < 2){
                lhm.put(nums[i], lhm.get(nums[i]) + 1);
            } else if (!lhm.containsKey(nums[i])){
                lhm.put(nums[i], 1);
            }
        }

        int j = 0;
        int count =0;
        for (Map.Entry<Integer, Integer> entry : lhm.entrySet()){
            if (entry.getValue() == 2){
                nums[j] = entry.getKey();
                j++;
                nums[j] = entry.getKey();
                j++;
                count =  count + 2;
            } else {
                nums[j] = entry.getKey();
                j++;
                count++;
            }
        }

        for (int i = j ; i <= nums.length-1; i++){
            nums[i] =0;
        }

        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII rd = new RemoveDuplicatesII();
        int[] input = {1,1,1,2,2,3};
        int output = rd.removeDuplicates(input);
        System.out.println(output);
        System.out.println(input);
    }
}


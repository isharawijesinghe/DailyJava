package top75.arrays;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicatesI {

    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        for (int i =0; i <= nums.length -1; i++){
            hs.add(nums[i]);
        }

        int j = 0;
        Iterator<Integer> itr = hs.iterator();
        while (itr.hasNext()){
            nums[j] = itr.next();
            j++;
        }

        return hs.size();
    }

    public static void main(String[] args) {
        RemoveDuplicatesI rd = new RemoveDuplicatesI();
        int[] input = {1,1,2};
        System.out.println(rd.removeDuplicates(input));
    }
}


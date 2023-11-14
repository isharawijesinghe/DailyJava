package top75.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i <= nums1.length-1 ; i++){
            if (countMap.containsKey(nums1[i])){
                countMap.put(nums1[i], countMap.get(nums1[i]) +1);
            } else {
                countMap.put(nums1[i], 1);
            }
        }

        for (int i=0; i <= nums2.length-1; i++){
            if (countMap.containsKey(nums2[i]) && countMap.get(nums2[i]) > 0){
                result.add(nums2[i]);
                countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i=0; i <= result.size()-1; i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

package top75.arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int aLen = nums1.length;
        int bLen = nums2.length;
        int[] result = new int[aLen + bLen];

        System.arraycopy(nums1, 0, result, 0, aLen);
        System.arraycopy(nums2, 0, result, aLen, bLen);

        Arrays.sort(result);

        if (result.length % 2 == 0){
            return ((result[(result.length-1)/2]) + (result[(result.length+1)/2]))/2.0;

        } else {
            return (result[result.length/2]);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(median.findMedianSortedArrays(num1, num2));
    }

}

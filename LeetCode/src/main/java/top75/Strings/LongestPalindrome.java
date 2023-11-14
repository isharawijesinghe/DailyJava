package top75.Strings;

public class LongestPalindrome {

//    public String longestPalindrome(String s) {
//
//    }


    public boolean isPalindrome(String s){
        int leftPointer = 0;
        int rightPointer = s.length()-1;

        while (leftPointer < rightPointer){
            if (s.charAt(leftPointer) == s.charAt(rightPointer)){
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }
        }
        return true;
    }
}

package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insertion {

    public static void main(String[] args) {
        List<Integer> unOrderList = Arrays.asList(10, 3, 1, 7, -1, -2, 40);
        System.out.println(unOrderList.toString());
        System.out.println(sortArray(unOrderList).toString());
    }


    public static List sortArray(List<Integer> unOrderArray){
        int i = 1;
        while (i < unOrderArray.size()){
            int j = i;
            while (j >= 1 && unOrderArray.get(j) < unOrderArray.get(j-1)){
                Integer currentItem = unOrderArray.get(j);
                Integer previousItem = unOrderArray.get(j-1);
                unOrderArray.set(j-1, currentItem);
                unOrderArray.set(j, previousItem);
                j--;
            }
            i++;
        }
        return unOrderArray;
    }

}

package sorting;

import java.util.Arrays;
import java.util.List;

public class Bubble {

    public static void main(String[] args) {
        List<Integer> unOrderList = Arrays.asList(10, 3, 1, 7, -1, -2, 40);
        System.out.println(unOrderList.toString());
        System.out.println(sortArray(unOrderList).toString());
    }


    public static List sortArray(List<Integer> unOrderArray){
        for (int i =  unOrderArray.size() ; i >= 0; i--){
            for (int j= 0; j < i -1; j++){
                if (unOrderArray.get(j) > unOrderArray.get(j+1)){
                    Integer currentItem = unOrderArray.get(j);
                    Integer nextItem = unOrderArray.get(j+1);
                    unOrderArray.set(j, nextItem);
                    unOrderArray.set(j + 1, currentItem);
                }
            }
        }
        return unOrderArray;
    }
}

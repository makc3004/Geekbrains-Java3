package hw;

import java.util.Arrays;

public class Main {
    public int[] arrayToReturn (int[] inputArray){
        int numForCheck = 4;
        int count = 0;
        int position = 0;
        int[] outPutArray;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == numForCheck){
                count++;
                position = i;
            }
        }
        if (count == 0) {

            throw new RuntimeException("В массиве нет числа 4");
        } else {
            outPutArray = Arrays.copyOfRange(inputArray,position +1, inputArray.length);
        }
        return outPutArray;
    }
    public boolean arrayToCheck(int[] inputArray){
        int numForCheck1 = 4;
        int numForCheck2 = 1;
        for (int i = 0; i < inputArray.length ; i++) {
            if (inputArray[i] == numForCheck1 || inputArray[i] == numForCheck2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main test = new Main();
        int[] arr = {2,5,7,4,9,10,3,1};
        int[] arr2 = {2,3,5,6,8};
        System.out.println(Arrays.toString(test.arrayToReturn(arr)));
        System.out.println(test.arrayToCheck(arr2));
    }
}

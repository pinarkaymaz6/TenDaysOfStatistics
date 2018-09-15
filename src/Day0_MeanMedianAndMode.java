 import java.util.*;
 import java.text.*;

public class Day0_MeanMedianAndMode {
    private static DecimalFormat df = new DecimalFormat(".#");
    public static double getMean(int[] array){
        double sum = 0;
        for(int a: array){
            sum += a;
        }
        return sum/array.length;

    }

    public static double getMedian(int[] array){
        array = bubbleSort(array);
        if(array.length % 2 == 0){
            int index = (array.length-1)/2;
            return (double)(array[index]+ array[index+1])/2;
        }else{
            return (double)array[array.length/2];
        }
    }

    public static int[] bubbleSort(int[] array){
        System.out.println("Original Array");
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println("\n");

        int end = array.length-1;
        while(end> 0){
            int swapPosition = 0;
            for (int j = 0; j < end; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapPosition = j;
                }
            }
            end = swapPosition;
        }
        System.out.println("Sorted Array");
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println("\n");
        return array;
    }

    public static int getMode(int[] array){
        int maxCount = 1;
        int smallestMostFrequent = 999999;
        for(int i=0; i< array.length; i++){
            int count = 1;
            for(int j= i+1; j< array.length; j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                smallestMostFrequent = array[i];
            }else if(count == maxCount){
                if(array[i] < smallestMostFrequent){
                    smallestMostFrequent = array[i];
                }
            }
        }
        return smallestMostFrequent;
    }

    public static void main(String[] args) {

        System.out.println("Please enter the number of elements");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Please enter "+arraySize+" element(s)");
        for(int i=0; i < arraySize; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Mean of the array: " + df.format(getMean(array)));
        System.out.println("Median of the array: " + df.format(getMedian(array)));
        System.out.println("Mode of the array: " + getMode(array));
    }
}
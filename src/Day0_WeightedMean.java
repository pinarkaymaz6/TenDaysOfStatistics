import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Day0_WeightedMean {
    private static DecimalFormat df = new DecimalFormat(".#");
    public static double getWaightedMean(int[] array, int[] weights){
        double sum = 0;
        double weightSum = 0;
        for(int i=0; i< array.length; i++){
            sum += array[i]*weights[i];
            weightSum += weights[i];
        }
        return (double)sum/weightSum;
    }

    public static void main(String[] args) {

        System.out.println("Please enter the number of elements");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        int[] weights = new int[arraySize];
        System.out.println("Please enter "+arraySize+" integer(s) for an array");
        for(int i=0; i < arraySize; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Please enter "+arraySize+" weight(s) for the array");
        for(int i=0; i < arraySize; i++){
            weights[i] = scanner.nextInt();
        }
        System.out.println(df.format(getWaightedMean(array, weights)));

    }
}

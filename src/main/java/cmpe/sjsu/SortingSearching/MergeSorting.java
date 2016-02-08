package cmpe.sjsu.SortingSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Naks on 25-Oct-15.
 * Merge Sort Class
 */
public class MergeSorting {

    int[] localA, helpingArray;
    int size;

    public MergeSorting(int[] A) {
        this.localA = A;
        this.size = A.length;
        this.helpingArray = new int[size];
        MergeSort(0, size - 1); // Calling MergeSort for complete array which will get executed recursively
    }

    private void MergeSort(int low, int high) {
        if (low < high) // If low is not smaller than high, the array is already sorted.
        {
            int mid = low + (high - low) / 2;
            MergeSort(low, mid);
            MergeSort(mid + 1, high);
            Merge(low, mid, high);
        }
    }

    private void Merge(int low, int mid, int high) {
        for (int i = 0; i <= high; i++)
            helpingArray[i] = localA[i]; // copy localA as we are going to modify localA

        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (helpingArray[i] <= helpingArray[j]) {
                localA[k] = helpingArray[i];
                i++;
            } else {
                localA[k] = helpingArray[j];
                j++;
            }
            k++;
        }

        /*Copy remaining item into the array. Note left side will always have more values after dividing array,
        * hence we are considering only left side to copy in an array*/

        while (i <= mid) {
            localA[k] = helpingArray[i];
            System.out.println();
            i++;
            k++;
        }

    }

    public void showZigZagArray() {
        System.out.println("Sorted Array");
        for (int i = 0,j=localA.length-1; i!=j; i++,j--) {
            System.out.println(localA[j]);
            System.out.println(localA[i]);
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        File file = new File("resources/unsortedlist.txt");
        ;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                arrayList.add(Integer.parseInt(sc.next()));
            }
            int[] unsortedArray = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++)
                unsortedArray[i] = arrayList.get(i);
            MergeSorting mergeSorting = new MergeSorting(unsortedArray);
            mergeSorting.showZigZagArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}

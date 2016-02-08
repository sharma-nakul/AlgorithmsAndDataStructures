package cmpe.sjsu.SortingSearching;

/**
 * Given an array of elements which is first increasing and then decreasing, find the maximum element in the array.
 */
public class BSearchApp {

    int array[] = {1,2,3,4,5,6,1};
    int key = -1;

    int maxVal(int low, int high) {
        int m = low + (high - low) / 2;
        if (array[m + 1] > array[m]) {
            key = array[m + 1];
            maxVal(m + 1, high);
        } else if (array[m + 1] < array[m] && key < array[m])
            maxVal(low, m);

            return key;
    }

    public static void main(String args[]) {

        BSearchApp bSearchApp = new BSearchApp();
        System.out.println(bSearchApp.maxVal(0, 6));

    }


}

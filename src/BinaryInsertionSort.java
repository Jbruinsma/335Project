
public class BinaryInsertionSort {

    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i += 1) {

            int key = arr[i];
            int j = i - 1;
            int insertionIndex = BinaryIndexSearch.search(arr, 0, i - 1, key);

            while (j >= insertionIndex) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[insertionIndex] = key;

        }
    }
}


public class BinaryInsertionSort {

    public static void binaryInsertionSort(Student[] arr) {
        for (int i = 1; i < arr.length; i += 1) {

            Student key = arr[i];
            int j = i - 1;
            int insertionIndex = BinaryIndexSearch.search(arr, 0, i - 1, key.id);

            while (j >= insertionIndex) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[insertionIndex] = key;

        }
    }
}

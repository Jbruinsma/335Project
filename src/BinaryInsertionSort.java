
public class BinaryInsertionSort {

    public static void binaryInsertionSort(Student[] arr) {

        // Traverse though every student in the array to sort them

        for (int i = 1; i < arr.length; i += 1) {

            Student key = arr[i];
            int j = i - 1;

            // Find the index where the key student should be inserted using binary search, Student ID is the key
            int insertionIndex = BinaryIndexSearch.search(arr, 0, i - 1, key.id);

            // Shift students to the right to until the current Student is inserted at the found index

            while (j >= insertionIndex) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[insertionIndex] = key;

        }
    }
}

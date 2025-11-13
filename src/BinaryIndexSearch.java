public class BinaryIndexSearch {

    public static int search(Student[] arr, int low, int high, String key) {

        // Base case: If the high index is less than the low index, return the low index as the insertion point
        if (low > high) return low;

        int mid = (low + high) / 2;

        // If the Student ID at the middle index is less than the key, search in the right half
        if (arr[mid].id.compareTo(key) < 0) return search(arr, mid + 1, high, key);

        // Else search in the left half
        else return search(arr, low, mid - 1, key);
    }
}
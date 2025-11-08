public class BinaryIndexSearch {

    public static int search(Student[] arr, int low, int high, String key) {

        if (high < low) return low;

        int mid = (low + high) / 2;
        if (arr[mid].id.compareTo(key) < 0) return search(arr, mid + 1, high, key);
        else return search(arr, low, mid - 1, key);
    }
}
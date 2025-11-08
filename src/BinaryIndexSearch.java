public class BinaryIndexSearch {

    public static int search(int[] arr, int low, int high, int key) {

        if (high < low) return low;

        int mid = (low + high) / 2;
        if (arr[mid] < key) return search(arr, mid + 1, high, key);
        else return search(arr, low, mid - 1, key);
    }
}
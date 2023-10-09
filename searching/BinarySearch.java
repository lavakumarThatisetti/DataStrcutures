package searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int x, int low, int high) {
        // Repeat until the pointers low and high meet each other
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 7, 8, 9 };
        int x = 4;
        int result = binarySearch(array, x, 0, array.length-1);
        if (result == -1)
            System.out.print("Element not found");
        else
            System.out.print("Element found at index: " + result);
    }
}

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // One by one, move the boundary of unsorted sub array.
        for (int i = 0; i < n - 1; i++) {
            // Find minimum el in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found min el with the first el
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 4, 6, 3};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

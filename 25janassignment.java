// PEP- Assignment-> 25Jan






  
  //  QUESTION 04
  
import java.util.Scanner;

public class ArrayOperations {
    private int[] arr = new int[10];
    private int size;

    public ArrayOperations() {
        size = 0;
    }

    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements (max 10): ");
        size = scanner.nextInt();
        if (size > 10) size = 10;
        System.out.println("Enter " + size + " integer values: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public void displayArray() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void reverseArray() {
        int start = 0, end = size - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.print("Reversed Array: ");
        displayArray();
    }

    public void checkIfSorted() {
        boolean isSorted = true;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("The array is sorted in ascending order.");
        } else {
            System.out.println("The array is not sorted in ascending order.");
        }
    }

    public void findMaxMin() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int maxElem = Integer.MIN_VALUE, minElem = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxElem) maxElem = arr[i];
            if (arr[i] < minElem) minElem = arr[i];
        }
        System.out.println("Maximum Element: " + maxElem);
        System.out.println("Minimum Element: " + minElem);
    }

    public static void main(String[] args) {
        ArrayOperations operations = new ArrayOperations();
        operations.populateArray();
        operations.displayArray();
        operations.reverseArray();
        operations.checkIfSorted();
        operations.findMaxMin();
    }
}

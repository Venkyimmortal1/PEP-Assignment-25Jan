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



// QUESTION 05

public class SumOfDigits {

    public static int sumOfDigits(int number) {
        if (number == 0) {
            return 0;
        } else {
            return number % 10 + sumOfDigits(number / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        int sum = sumOfDigits(number);
        System.out.println("The sum of the digits of " + number + " is " + sum + ".");
    }
}



//  QUESTION 06


import java.util.Scanner;

public class PalindromeNumber {

    public static boolean isPalindrome(int number, int reverse) {
        if (number == 0) {
            return number == reverse;
        } else {
            reverse = reverse * 10 + number % 10;
            return isPalindrome(number / 10, reverse);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        boolean result = isPalindrome(number, 0);
        System.out.println(result ? "true" : "false");
    }
}


// QUESTION 07

public class RodCutting {

    public static int maxProfit(int n, int[] prices) {
        if (n == 0) {
            return 0;
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int profit = prices[i - 1] + maxProfit(n - i, prices);
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int N = 8;
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int result = maxProfit(N, prices);
        System.out.println("Maximum Profit: " + result);
    }
}


// QUESTION 08


public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int N = 2;
        towerOfHanoi(N, 'A', 'C', 'B');
    }
}


// QUESTION 09

import java.util.Scanner;

public class DirectAddressTable {

    private static Integer[] table;

    public static void insert(int key, int value) {
        table[key] = value;
    }

    public static String search(int key) {
        if (table[key] != null) {
            return table[key].toString();
        } else {
            return "NOT FOUND";
        }
    }

    public static void delete(int key) {
        table[key] = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        table = new Integer[n];

        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            String[] parts = query.split(" ");
            String operation = parts[0];
            int key = Integer.parseInt(parts[1]);

            switch (operation) {
                case "INSERT":
                    int value = Integer.parseInt(parts[2]);
                    insert(key, value);
                    break;
                case "SEARCH":
                    System.out.println(search(key));
                    break;
                case "DELETE":
                    delete(key);
                    break;
            }
        }

        scanner.close();
    }
}


// QUESTION 10


import java.util.*;

public class HashTable {

    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static class HashTableChaining {
        private Node[] table;

        HashTableChaining(int size) {
            table = new Node[size];
        }

        int hash(int key) {
            return key % table.length;
        }

        void insert(int key) {
            int index = hash(key);
            Node newNode = new Node(key);
            newNode.next = table[index];
            table[index] = newNode;
        }

        String search(int key) {
            int index = hash(key);
            Node current = table[index];
            while (current != null) {
                if (current.key == key) {
                    return "FOUND";
                }
                current = current.next;
            }
            return "NOT FOUND";
        }

        void delete(int key) {
            int index = hash(key);
            Node current = table[index];
            Node prev = null;
            while (current != null) {
                if (current.key == key) {
                    if (prev == null) {
                        table[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }

    private static class HashTableOpenAddressing {
        private int[] table;

        HashTableOpenAddressing(int size) {
            table = new int[size];
            Arrays.fill(table, -1);
        }

        int hash(int key) {
            return key % table.length;
        }

        void insert(int key) {
            int index = hash(key);
            while (table[index] != -1) {
                index = (index + 1) % table.length;
            }
            table[index] = key;
        }

        String search(int key) {
            int index = hash(key);
            int originalIndex = index;
            while (table[index] != -1) {
                if (table[index] == key) {
                    return "FOUND";
                }
                index = (index + 1) % table.length;
                if (index == originalIndex) {
                    break;
                }
            }
            return "NOT FOUND";
        }

        void delete(int key) {
            int index = hash(key);
            int originalIndex = index;
            while (table[index] != -1) {
                if (table[index] == key) {
                    table[index] = -1;
                    return;
                }
                index = (index + 1) % table.length;
                if (index == originalIndex) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String method = scanner.next();
        int q = scanner.nextInt();
        scanner.nextLine();

        if (method.equals("CHAINING")) {
            HashTableChaining hashTable = new HashTableChaining(m);

            for (int i = 0; i < q; i++) {
                String query = scanner.nextLine();
                String[] parts = query.split(" ");
                String operation = parts[0];
                int key = Integer.parseInt(parts[1]);

                switch (operation) {
                    case "INSERT":
                        hashTable.insert(key);
                        break;
                    case "SEARCH":
                        System.out.println(hashTable.search(key));
                        break;
                    case "DELETE":
                        hashTable.delete(key);
                        break;
                }
            }
        } else if (method.equals("OPEN_ADDRESSING")) {
            HashTableOpenAddressing hashTable = new HashTableOpenAddressing(m);

            for (int i = 0; i < q; i++) {
                String query = scanner.nextLine();
                String[] parts = query.split(" ");
                String operation = parts[0];
                int key = Integer.parseInt(parts[1]);

                switch (operation) {
                    case "INSERT":
                        hashTable.insert(key);
                        break;
                    case "SEARCH":
                        System.out.println(hashTable.search(key));
                        break;
                    case "DELETE":
                        hashTable.delete(key);
                        break;
                }
            }
        }
        scanner.close();
    }
}




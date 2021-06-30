import java.util.*;

class insertion {
    static void insertionSort (int[] a) {
        for (int i=1; i<a.length; i++) {
            int key = a[i];
            int p = i - 1;
            while (a[p] > key) {
                a[p + 1] = a[p];
                p--;
            }
            a[p + 1] = key;
        }
    }

    static void printArray (int[] a) {
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter no. of elements - ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " elements : ");
        for (int i=0; i<n; i++) 
            a[i] = sc.nextInt();
        insertionSort(a);
        System.out.println("FINAL SORTED ARRAY :-");
        printArray(a);
    }
}
import java.util.*;

class quicksort {
    static int partition (int[] a, int l, int h) {
        int pivot = a[h];
        int j = l - 1;
        for (int i=l; i<=h-1; i++) {
            if (a[i] < pivot) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, j+1, h);
        return (j+1);
    }

    static void swap (int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    static void quickSort (int[] a, int l, int h) {
        if (l < h) {
            int p = partition(a, l, h);
            quickSort(a, l, p-1);
            quickSort(a, p+1, h);
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
        quickSort(a, 0, n-1);
        System.out.println("FINAL SORTED ARRAY :-");
        printArray(a);
    }
}
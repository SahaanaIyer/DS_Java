import java.util.*;

class merge {
    static void merging (int[] a, int l, int m, int h) {
        int xsize = m - l + 1;
        int ysize = h - m;
        int[] x = new int[xsize];
        int[] y = new int[ysize];
        for (int i=0; i<xsize; i++) x[i] = a[l + i];
        for (int i=0; i<ysize; i++) y[i] = a[m + i + 1];
        int i = 0;
        int j = 0;
        int k = 1;
        while (i < xsize && j < ysize) {
            if (x[i] <= y[j]) a[k] = x[i++];
            else a[k] = y[j++];
            k++;
        }
        while (i < xsize) {
            a[k] = x[i++];
            k++;
        }
        while (j < ysize) {
            a[k] = y[j++];
            k++;
        }
    }

    static void mergeSort (int[] a, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m+1, h);
            merging(a, l, m, h);
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
        mergeSort(a, 0, n-1);
        System.out.println("FINAL SORTED ARRAY :-");
        printArray(a);
    }
}
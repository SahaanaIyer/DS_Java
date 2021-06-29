import java.util.*;

public class binary {
    static int binarySearch (int[] a, int x) {
        int l = 0; 
        int h = a.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] == x) return m;
            else if (a[m] < x) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter no. of elements - ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " elements : ");
        for (int i=0; i<n; i++) 
            a[i] = sc.nextInt();
        System.out.print("Enter element to be searched - ");
        int ele = sc.nextInt();
        int pos = binarySearch(a, ele);
        if (pos == -1) System.out.println("Element " + ele + " not found");
        else System.out.println("Element found at position - " + (pos+1));
    }
}
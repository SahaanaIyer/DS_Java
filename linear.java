import java.util.*;

public class linear {
    static int linearSearch (int[] a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x) return i;
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
        int pos = linearSearch(a, ele);
        if (pos == -1) System.out.println("Element " + ele + " not found");
        else System.out.println("Element found at position - " + (pos+1));
    }
}
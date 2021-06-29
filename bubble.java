import java.util.*;

class bubble {
    static void bubbleSort (int[] a) {
        for (int i=0; i<a.length-1; i++) {
            printArray(a);
            for (int j=0; j<a.length-i-1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println();
        }
        System.out.println("FINAL SORTED ARRAY :-");
        printArray(a);
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
        bubbleSort(a);
    }
}
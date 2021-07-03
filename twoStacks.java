import java.util.*;

class twoStacks {
    static int max = 10;
    static int[] arr = new int[max];
    static int topA = -1;
    static int topB = max;

    public static void pushA (int x) {
        if (topA + 1 == topB) System.out.println("Stack A Overflow");
        else arr[++topA] = x;
    }

    public static void pushB (int x) {
        if (topA + 1 == topB) System.out.println("Stack B Overflow");
        else arr[--topB] = x;
    }

    public static void popA() {
        if (topA == -1) System.out.println("Stack A Underflow");
        else topA--;
    }

    public static void popB() {
        if (topB == max) System.out.println("Stack B Underflow");
        else topB++;
    }

    public static void peekA() {
        if (topA == -1) System.out.println("Stack A Underflow");
        else System.out.println(arr[topA]);
    }

    public static void peekB() {
        if (topB == max) System.out.println("Stack B Underflow");
        else System.out.println(arr[topB]);
    }

    public static void displayA() {
        if (topA + 1 == topB) System.out.println("Stack A Overflow");
        else {
            for (int i=0; i<=topA; i++) System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void displayB() {
        if (topA + 1 == topB) System.out.println("Stack B Overflow");
        else {
            for (int i=max-1; i>=topB; i--) System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int val, ch;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                pushA(val);
                                break inner;
                    case 2 :    val = sc.nextInt();
                                pushB(val);
                                break inner;
                    case 3 :    popA();
                                break inner;
                    case 4 :    popB();
                                break inner;
                    case 5 :    peekA();
                                break inner;
                    case 6 :    peekB();
                                break inner;
                    case 7 :    displayA();
                                break inner;
                    case 8 :    displayB();
                                break inner;
                }
            }
        }
    }
}
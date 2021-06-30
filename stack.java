import java.util.*;

class stack {
    int max = 500;
    int[] arr = new int[max];     
    int top = -1;
    
    public void push (stack s, int x) {
        if (s.top == max - 1) System.out.println("Stack Overflow");
        else s.arr[++s.top] = x;
    }

    public void pop (stack s) {
        if (s.top == -1) System.out.println("Stack Underflow");
        else {
            System.out.println("Element popped is " + s.arr[s.top]);
            s.top--;
        }
    }

    public int peek (stack s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return s.arr[s.top];
    }

    public void display (stack s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
        }
        else {
            for (int i=0; i<=s.top; i++) System.out.print(s.arr[i] + " ");
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        stack s = new stack();
        int val, ch;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                s.push(s, val);
                                break inner;
                    case 2 :    s.pop(s);
                                break inner;
                    case 3 :    int peek = s.peek(s);
                                if (peek != -1) System.out.println("Peek element is " + peek);
                                break inner;
                    case 4 :    s.display(s);
                                break inner;
                }
            }
        }
    }
}
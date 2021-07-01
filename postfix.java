import java.util.*;

class postfix {    
    int max = 500;
    int[] arr = new int[max];     
    int top = -1;
    
    public void push (postfix s, int x) {
        if (s.top == max - 1) System.out.println("Stack Overflow");
        else s.arr[++s.top] = x;
    }

    public int pop (postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int popped = s.arr[s.top--];
            return popped;
        }
    }

    public int peek (postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return s.arr[s.top];
    }

    public void display (postfix s) {
        if (s.top == -1) System.out.println("Stack Underflow");
        else {
            for (int i=0; i<=s.top; i++) System.out.print(s.arr[i] + " ");
            System.out.println();
        }
    }

    public boolean isEmpty (postfix s) {
        if (s.top == -1) return true;
        else return false;
    }

    public boolean isOperator(postfix p, char x) {
        if (x == '+' || x == '-' || x == '*' || x == '/') return true;
        else return false;
    }

    public int calculate (postfix p, int x, char op, int y) {
        if (op == '+') return (x+y);
        else if (op == '-') return (x-y);
        else if (op == '*') return (x*y);
        else if (op == '/') return (x/y);
        else return 0;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        postfix p = new postfix();
        String s = sc.next();
        int val;
        for (int i=0; i<s.length(); i++) {
            if (!p.isOperator(p, s.charAt(i))) 
                p.push(p, s.charAt(i)-48);
            else {
                int n1 = p.pop(p);
                int n2 = p.pop(p);
                switch(s.charAt(i)) {
                    case '+' :  val = n2 + n1;
                                p.push(p, val);
                                break;

                    case '-' :  val = n2 - n1;
                                p.push(p, val);
                                break;

                    case '*' :  val = n2 * n1;
                                p.push(p, val);
                                break;

                    case '/' :  val = n2 / n1;
                                p.push(p, val);
                                break;
                }
            }
        }
        System.out.println("Value of the expression " + s + " is " + p.pop(p));
    }
}
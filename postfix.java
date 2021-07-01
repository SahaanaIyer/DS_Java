import java.util.*;

class postfix {    
    int max = 500;
    char[] arr = new char[max];     
    int top = -1;
    
    public void push (postfix s, char x) {
        if (s.top == max - 1) System.out.println("Stack Overflow");
        else s.arr[++s.top] = x;
    }

    public char pop (postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
        }
        else {
            char popped = s.arr[s.top--];
            return popped;
        }
    }

    public char peek (postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
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

    public boolean isOperand(postfix p, char x) {
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
        int val = 0;
        int x;
        for (int i=0; i<s.length(); i++) {
            if (p.isOperand(p, s.charAt(i))) p.push(p, s.charAt(i));
            else {
                char popped = p.pop(p);
                if (val == 0) {
                    x = s.charAt(i) - 48;
                    i++;
                }
                else {
                    x = val;
                } 
                int y = s.charAt(i) - 48;
                val = p.calculate(p, x, popped, y);
            }
        }
        System.out.println("Value of the expression " + s + " is " + val);
    }
}
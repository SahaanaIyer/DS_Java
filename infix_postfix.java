import java.util.*;

class infix_postfix {    
    int max = 500;
    char[] arr = new char[max];     
    int top = -1;
    
    public void push (infix_postfix s, char x) {
        if (s.top == max - 1) System.out.println("Stack Overflow");
        else s.arr[++s.top] = x;
    }

    public char pop (infix_postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
        }
        else {
            char popped = s.arr[s.top--];
            return popped;
        }
    }

    public char peek (infix_postfix s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
        }
        return s.arr[s.top];
    }

    public void display (infix_postfix s) {
        if (s.top == -1) System.out.println("Stack Underflow");
        else {
            for (int i=0; i<=s.top; i++) System.out.print(s.arr[i] + " ");
            System.out.println();
        }
    }

    public boolean isEmpty (infix_postfix s) {
        if (s.top == -1) return true;
        else return false;
    }

    public boolean isOperand(infix_postfix p, char x) {
        if (x == '+' || x == '-' || x == '*' || x == '/') return true;
        else return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        infix_postfix p = new infix_postfix();
        String s = sc.next();
        StringBuffer val = new StringBuffer();
        int x;
        char op2, op;
        String op1, sub;
        op1 = Character.toString(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            // op1 = sub;
            if (s.charAt(i) == '(') p.push(p, s.charAt(i));
            else if (p.isOperand(p, s.charAt(i))) {
                op = s.charAt(i);
            }
            else if (!p.isOperand(p, s.charAt(i))) {
                op2 = s.charAt(i);
            }
            op1 = op + op1 + op2;
        }
        // val.insert(op1);
        System.out.println(op1);
    }
}
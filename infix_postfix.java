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
        if (s.top == -1) return '#';
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

    public boolean isOperator(char x) {
        if (x == '+' || x == '-' || x == '*' || x == '/' || x == '(' || x == ')') return true;
        else return false;
    }

    public int priority(char x) {
        if (x == '(' || x == '[' || x == '{') return 0;
        else if (x == '*' || x == '/') return 2;
        else if (x == '+' || x == '-') return 1;
        else return 0;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        infix_postfix p = new infix_postfix();
        String s = sc.next();
        char[] op = new char[s.length()+1];
        int k = 0;
        for (int i=0; i<s.length(); i++) {
            if (!p.isOperator(s.charAt(i))) 
                op[k++] = s.charAt(i);
            else {
                if (s.charAt(i) == '(') 
                    p.push(p, s.charAt(i));
                else if (p.priority(s.charAt(i)) > p.priority(p.peek(p)))
                    p.push(p, s.charAt(i));
                else if (s.charAt(i) == ')') {
                    while (p.peek(p) != '(') {
                        char popped = p.pop(p);
                        if (popped != '#') op[k++] = popped;
                    }
                    p.pop(p);
                }
                else {
                    while (p.priority(p.peek(p)) >= p.priority(s.charAt(i))) {
                        char popped = p.pop(p);
                        if (popped != '#') op[k++] = popped;
                    }
                    p.push(p, s.charAt(i));
                }
            }
        }
        while (p.top != -1) {
            op[k++] = p.pop(p);
        }
        op[k] = '\0';
        System.out.println("Equivalent postfix expression of " + s + " is " + String.valueOf(op));
    }
}
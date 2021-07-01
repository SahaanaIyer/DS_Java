import java.util.*;

class paranthesis {
    int max = 500;
    char[] arr = new char[max];     
    int top = -1;
    
    public void push (paranthesis s, char x) {
        if (s.top == max - 1) System.out.println("Stack Overflow");
        else s.arr[++s.top] = x;
    }

    public char pop (paranthesis s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
        }
        else {
            char popped = s.arr[s.top];
            s.top--;
            return popped;
        }
    }

    public char peek (paranthesis s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
            return '#';
        }
        return s.arr[s.top];
    }

    public void display (paranthesis s) {
        if (s.top == -1) {
            System.out.println("Stack Underflow");
        }
        else {
            for (int i=0; i<=s.top; i++) System.out.print(s.arr[i] + " ");
            System.out.println();
        }
    }

    public int match (char x, char y) {
        if (x == '(' && y == ')') return 1;
        else if (x == '[' && y == ']') return 2;
        else if (x == '{' && y == '}') return 3;
        else return 0;
    }

    public boolean isEmpty (paranthesis s) {
        if (s.top == -1) return true;
        else return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        paranthesis p = new paranthesis();
        String s = sc.next();
        int flag = 0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                p.push(p, s.charAt(i));
            else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                char popped = p.pop(p);
                if (popped != '#') {
                    int m = p.match(popped, s.charAt(i));
                    if (m == 0) {
                        System.out.println("Paranthesis not balanced");
                        flag = 1;
                        break;
                    }
                }
                else {
                    System.out.println("Paranthesis not balanced");
                    flag = 1;
                    break;
                }
            }
            else continue;
        }
        if (flag == 0) {
            if (p.isEmpty(p)) System.out.println("Paranthesis balanced");
            else System.out.println("Paranthesis not balanced");
        }
    }
}
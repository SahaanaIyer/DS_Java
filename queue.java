import java.util.*;

class queue {
    int max = 500;
    int[] arr = new int[max];
    int front = -1;
    int rear = -1;

    public void enqueue (queue q, int x) {
        if (q.rear == max - 1) System.out.println("Queue Overflow");
        else if (q.front == -1 && q.rear == -1) {
            q.arr[++q.rear] = x;
            q.front = q.rear;
        }
        else q.arr[++q.rear] = x;
    }

    public void dequeue (queue q) {
        if (q.front == -1 && q.rear == -1) System.out.println("Queue Underflow");
        else if (q.front == q.rear) {
            System.out.println("Element popped is " + q.arr[q.front]);
            q.front = -1;
            q.rear = -1;
        }
        else System.out.println("Element popped is " + q.arr[q.front++]);
    }

    public void display (queue q) {
        for (int i=q.front; i<=q.rear; i++) System.out.print(q.arr[i] + " ");
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        queue q = new queue();
        int val, ch;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                q.enqueue(q, val);
                                break inner;
                    case 2 :    q.dequeue(q);
                                break inner;
                    case 3 :    q.display(q);
                                break inner;
                }
            }
        }
    }
}
import java.util.*;

class circqueue {
    int max = 10;
    int[] arr = new int[max];
    int front = -1;
    int rear = -1;

    public void enqueue (circqueue cq, int val) {
        if ((cq.rear + 1) % max == cq.front) System.out.println("Queue Overflow");
        else if (cq.rear == -1 && cq.front == -1) {
            cq.rear = 0;
            cq.front = 0;
            cq.arr[cq.rear] = val;
        }
        else {
            cq.rear = (cq.rear + 1) % max;
            cq.arr[cq.rear] = val;
        }
    }

    public void dequeue (circqueue cq) {
        if (cq.front == -1 && cq.rear == -1) System.out.println("Queue Underflow");
        else if (cq.front == cq.rear) {
            System.out.println("Element popped is " + cq.arr[cq.front]);
            cq.front = -1;
            cq.rear = -1;
        }
        else {
            System.out.println("Element popped is " + cq.arr[cq.front]);
            cq.front = (cq.front + 1) % max;
        }
    }

    public void display (circqueue cq) {
        for (int i=cq.front; i!=cq.rear; i=(i+1)%max) 
            System.out.print(cq.arr[i] + " ");
        System.out.print(cq.arr[cq.rear]);
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        circqueue cq = new circqueue();
        int val, ch;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                cq.enqueue(cq, val);
                                break inner;
                    case 2 :    cq.dequeue(cq);
                                break inner;
                    case 3 :    cq.display(cq);
                                break inner;
                }
            }
        }
    }
}
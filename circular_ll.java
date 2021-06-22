import java.util.*;
import java.lang.*;

public class circular_ll{
    static Node head;
    
    static class Node {
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }
    
    public static void insertStart (int data) {
        Node p = head;
        Node newnode = new Node (data);
        newnode.next = head;
        if (head == null) {
            newnode.next = newnode;
            head = newnode;
            return;
        }
        while (p.next != head) {
            p = p.next;
        }
        p.next = newnode;
        head = newnode;
    }
    
    public static void insertEnd (int data) {
        Node newnode = new Node (data);
        Node p = head;
        while (p.next != head)
            p = p.next;
        p.next = newnode;
        newnode.next = head;
    }
    
    public static void insertAfter (int data, int aft) {
        Node newnode = new Node (data);
        Node p = head;
        while (p.data != aft && p.next != head) {
            p = p.next;
        }
        if(p.next == head && p.data != aft) {
            return;
        }
        else {
            newnode.next = p.next;
            p.next = newnode;   
        }
    }
    
    public static void insertBefore (int data, int bef) {
        Node newnode = new Node (data);
        Node p = head;
        Node prev = p;
        if (head.data == bef) {
            newnode.next = head;
            while (p.next != head)
                p = p.next;
            p.next = newnode;
            head = newnode;
            p = head;
            return;
        }
        while (p.data != bef && p.next != head) {
            prev = p;
            p = p.next;
        }
        newnode.next = p;
        prev.next = newnode;   
    }
    
    public static void display() {
        Node p = head;
        for (Node i=p; p.next!=head; p=p.next) {
            System.out.println(p.data+" ");
        }
        System.out.println(p.data);
    }
    
    public static void deleteStart() {
        Node p = head.next;
        while (p.next != head)
            p = p.next;
        p.next = head.next;
        head.next = null;
        head = p.next;
    }

    public static void deleteEnd() {
        Node p = head;
        Node prev = p;
        while (p.next != head) {
            prev = p;
            p = p.next;
        }
        prev.next = head;
    }

    public static void deleteBefore(int val) {
        Node p = head;
        Node prev = head;
        Node pprev = head;
        if (head.data == val) {
            deleteEnd();
        }
        else if (head.next.data == val) {
            deleteStart();
        }
        else {
            while (p.next != head && p.data != val) {
                pprev = prev;
                prev = p;
                p = p.next;
            }
            if (p.next == head && p.data == val) {
                pprev.next = p;
            }
            else if (p.data == val) {
                pprev.next = p;
            }
        }
    }

    public static void deleteAfter(int val) {
        Node p = head.next;
        Node prev = head;
        if (head.data == val) {
            head.next = head.next.next;
            return;
        }
        while (p != head && p.data != val) {
            prev = p;
            p = p.next;
        }
        if (p.next == head && prev.data == val) {
           deleteEnd();
        }
        else if (p.next == head && p.data == val) {
            deleteStart();
        }
        else if (p != head)
            p.next = p.next.next;
    }

    public static void main(String []args){
        Scanner sc = new Scanner (System.in);
        int ch;
        int val;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                insertStart(val);
                                break inner;
                    case 2 :    val = sc.nextInt();
                                insertEnd(val);
                                break inner;
                    case 3 :    int aft = sc.nextInt();
                                val = sc.nextInt();
                                insertAfter(val, aft);
                                break inner;
                    case 4 :    int bef = sc.nextInt();
                                val = sc.nextInt();
                                insertBefore(val, bef);
                                break inner;
                    case 5 :    display();
                                break inner;
                    case 6 :    deleteStart();
                                break inner;
                    case 7 :    deleteEnd();
                                break inner;
                    case 8 :    int daft = sc.nextInt();
                                deleteAfter(daft);
                                break inner;
                    case 9 :    int dbef = sc.nextInt();
                                deleteBefore(dbef);
                                break inner;
                }
            }
        }
    }
}
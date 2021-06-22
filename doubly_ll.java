import java.util.*;
import java.lang.*;

public class doubly_ll{
    static Node head;
    
    static class Node {
        int data;
        Node prev;
        Node next;
        Node (int d) {
            data = d;
            next = null;
            prev = null;
        }
    }
    
    public static void insertStart (int data) {
        Node newnode = new Node (data);
        newnode.next = head;
        head = newnode;
    }
    
    public static void insertEnd (int data) {
        Node newnode = new Node (data);
        Node p = head;
        while (p.next != null)
            p = p.next;
        newnode.prev = p;
        p.next = newnode;
    }
    
    public static void insertAfter (int data, int aft) {
        Node newnode = new Node (data);
        Node p = head;
        while (p.data != aft && p.next != null) {
            p = p.next;
        }
        if (p.next == null && p.data == aft) {
            newnode.prev = p;
            p.next = newnode;
        }
        else {
            p.next.prev = newnode;
            newnode.next = p.next;
            p.next = newnode;   
            newnode.prev = p;
        }
    }
    
    public static void insertBefore (int data, int bef) {
        Node newnode = new Node (data);
        Node p = head;
        Node prev = p;
        if (head.data == bef) {
            newnode.next = head;
            head = newnode;
            p = head;
            return;
        }
        while (p.data != bef && p.next != null) {
            prev = p;
            p = p.next;
        }
        newnode.next = prev.next;
        prev.next = newnode;   
    }
    
    public static void display() {
        Node p = head;
        for (Node i=p; p!=null; p=p.next) {
            System.out.println(p.data+" ");
        }
    }
    
    public static void deleteStart() {
        Node p = head.next;
        head.next = null;
        head = p;
        p.prev = null;
    }

    public static void deleteEnd() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.prev.next = null;
        p.prev = null;
    }

    public static void deleteBefore(int val) {
        Node p = head;
        if (head.data == val) {
            return;
        }
        else if (head.next.data == val) {
            deleteStart();
        }
        else {
            while (p != null && p.data != val) {
                p = p.next;
            }
            p.prev.prev.next = p;
            p = p.prev.prev;
        }
    }

    public static void deleteAfter(int val) {
        Node p = head;
        while (p != null && p.data != val) {
            p = p.next;
        }
        if (p.next.next == null && p.data == val) {
           deleteEnd();
        }
        else if (p != null) {
            p.next.next.prev = p;
            p.next = p.next.next;
        }
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
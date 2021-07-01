import java.util.*;

class bst {
    static Node root = null;

    static class Node {
        int data;
        Node left;
        Node right;
        Node (int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    public void insert (int x) {
        Node newnode = new Node (x);
        Node p = root;
        Node t = root;
        if (root == null) root = newnode;
        else {
            while (t != null) {
                if (t.data < x) {
                    p = t;
                    t = t.right;
                }
                else {
                    p = t;
                    t = t.left;
                }
            }
            if (p.left == null && p.data > x)   p.left = newnode;
            else if (p.right == null && p.data < x)   p.right = newnode;
        }
    }

    public void delete (int x) {
        int flag = 0;
        Node t = root;
        Node p = root;
        if (root == null) {
            System.out.println("Tree is Empty");
        }
        else {
            while (t != null) {
                if (t.data < x) {
                    p = t;
                    t = t.right;
                }
                else if (t.data > x) {
                    p = t;
                    t = t.left;
                }
                else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("Left : " + t.left + "    Right : " + t.right);
                if (t.left == null && t.right == null) {
                    if (p.left == t) p.left = null;
                    else p.right = null;
                }
                else if (t.left == null && t.right != null) {
                    if (p.left == t) p.left = t.right;
                    else p.right = t.right;
                }
                else if (t.left != null && t.right == null) {
                    if (p.left == t) p.left = t.left;
                    else p.right = t.left;
                }
                else if (t.left != null && t.right != null) {
                    Node r = t.left;
                    while (r.right != null) {
                        p = r;
                        r = r.right;
                    }
                    t.data = r.data;
                    if (p.left == r) p.left = null;
                    else p.right = null;
                }
            }
        }
    }

    public void inorder (Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }

    public void preorder (Node t) {
        if (t != null) {
            System.out.print(t.data + " ");
            inorder(t.left);
            inorder(t.right);
        }
    }

    public void postorder (Node t) {
        if (t != null) {
            inorder(t.left);
            inorder(t.right);
            System.out.print(t.data + " ");
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        bst b = new bst();
        int val, ch;
        while (true) {
            if (sc.hasNext()) {
                ch = sc.nextInt();
                inner : switch(ch) {
                    case 1 :    val = sc.nextInt();
                                b.insert(val);
                                break inner;
                    case 2 :    val = sc.nextInt();
                                b.delete(val);
                                break inner;
                    case 3 :    b.inorder(root);
                                System.out.println();
                                break inner;
                    case 4 :    b.preorder(root);
                                System.out.println();
                                break inner;
                    case 5 :    b.postorder(root);
                                System.out.println();
                                break inner;
                }
            }
        }
    }
}
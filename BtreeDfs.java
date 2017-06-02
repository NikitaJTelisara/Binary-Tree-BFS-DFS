public class BtreeDfs {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);


        /*          1
               2         3
           4     5    6     7


         */

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        /* (dfs)post order traversal o/p: 4 5 2 6 7 3 1 */
        System.out.println(" rec post order ");
        postOrderTraversal(n1);
        System.out.println(" iter post order");
        IterPostOrderTraversal(n1);

        /* (dfs)pre order traversal o/p: 1 2 4 5 3 6 7 */
        System.out.println(" rec pre order ");
        //preOrderTraversal(n1);
        System.out.println(" iter pre order ");
        IterPreOrderTraversal(n1);


        System.out.println(" In order recursive");
        inOrderTraversal(n1);
        System.out.println(" Iter In order");
        IterInOrderTraversal(n1);
    }

    /*DFS */
    /* recursive */
    public static void postOrderTraversal(Node n) {
        if (n != null) {
            postOrderTraversal(n.left);
            postOrderTraversal(n.right);
            System.out.println(n.data);
        }
    }

    /*DFS */
    /* iteraive */
    public static void IterPostOrderTraversal(Node n) {
        Stack s = new Stack();
        s.push(n);
        Node prev = null;
        Node element = null;
        while (!s.isEmpty()) {
            Node cur = s.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    s.push(cur.left);
                } else if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    element = s.pop();
                    System.out.println(element.data);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    element = s.pop();
                    System.out.println(element.data);
                }
            } else if (cur.right == prev) {
                element = s.pop();
                System.out.println(element.data);
            }
            prev = cur;
        }
    }

    public static void preOrderTraversal(Node n) {
        if (n != null) {
            System.out.println(n.data);
            preOrderTraversal(n.left);
            preOrderTraversal(n.right);

        }
    }

    public static void IterPreOrderTraversal(Node n) {
        if (n == null) {
            return;
        }
        Stack s = new Stack();
        s.push(n);
        while (!s.isEmpty()) {
            Node element = s.pop();
            System.out.println(element.data);
            if (element.right != null) {
                s.push(element.right);
            }
            if (element.left != null) {
                s.push(element.left);
            }
        }
    }

    public static void inOrderTraversal(Node n) {
        if (n != null) {
            inOrderTraversal(n.left);
            System.out.println(n.data);
            inOrderTraversal(n.right);
        }
    }

    public static void IterInOrderTraversal(Node n) {
        Stack s = new Stack();
        while (n != null) {
            s.push(n);
            n = n.left;
        }
        while (!s.isEmpty()) {
            n = s.pop();
            System.out.println(n.data);
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    s.push(n);
                    n = n.left;
                }
            }
        }
    }
}
public class BtreeBfs {
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

        /*  (bfs)level order traversal o/p: 1 2 3 4 5 6 7 */
        System.out.println(" Iterative level order iterative");
        ItLevelOrderTraversal(n1);
        System.out.println(" recursive level order iterative");
        recLevelOrderTraversal(n1);
    }

    /* BFS *
  /* iterative */
    public static void ItLevelOrderTraversal(Node n) {
        Queue q = new Queue();
        q.enQueue(n);
        while (!q.isEmpty()) {
            Node element = q.deQueue();
            System.out.println(element.data);
            if (element.left != null) {
                q.enQueue(element.left);
            }
            if (element.right != null) {
                q.enQueue(element.right);
            }
        }
    }

    /* BFS *
  /* iterative */
    public static void recLevelOrderTraversal(Node n) {
        int height = getHeight(n);
        for (int i = 1; i <= height; i++) {
            printLevel(n, i);
        }
    }

    public static void printLevel(Node n, int level) {
        if (level == 1) {
            System.out.println(n.data);
        } else {
            printLevel(n.left, level - 1);
            printLevel(n.right, level - 1);
        }
    }

    public static int getHeight(Node n) {
        if (n == null) {
            return 0;
        }
        int leftHeight = getHeight(n.left);
        int rightHeight = getHeight(n.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /* better
    public static int getHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return (Math.max(getHeight(n.left),getHeight(n.right) )) + 1;
    }
*/

}

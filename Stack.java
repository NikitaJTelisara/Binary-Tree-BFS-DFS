public class Stack {
    Node top;

    public Node pop() {
        if (top != null) {
            Node n = top;
            top = top.next;
            return n;
        }
        return null;
    }

    public void push(Node n) {
        if (top != null) {
            n.next = top;
        }
        top = n;
    }

    public Node peek() {
        if (top != null) {
            return top;
        }
        return null;
    }

    boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
}
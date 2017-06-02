public class Queue {
    Node front;
    Node end;

    public void enQueue(Node n) {
        if (front == null) {
            front = n;
            end = n;
        } else {
            end.next = n;
            end = end.next;
        }
    }

    public Node deQueue() {
        if (front != null) {
            Node n = front;
            front = front.next;
            return n;
        }
        return null;
    }

    public boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }
}

public class CircularDoublyLinkedList {

    Node head = null;
    Node tail = null;

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isInList(int element) {
        if (isEmpty()) return false;

        Node current = head;
        do {
            if (current.data == element) return true;
            current = current.next;
        } while (current != head);

        return false;
    }

    public void reverseList() {
        if (isEmpty() || head.next == head) return;

        Node current = head;
        Node temp = null;

        do {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        } while (current != head);

        temp = head;
        head = tail;
        tail = temp;
    }

    public void deleteFromTail() {
        if (isEmpty()) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    public void deleteFromHead() {
        if (isEmpty()) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    public void addAtPosition(int element, int position) {
        Node newNode = new Node(element);

        if (position == 0) {
            addToHead(element);
            return;
        }

        Node current = head;
        for (int i = 1; i < position && current.next != head; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
    }

    public void addToTail(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public void addToHead(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }
}

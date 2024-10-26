public class CircularSingleLinkedList {

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

        Node prev = null, current = head, next = null, first = head;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != first);

        current.next = prev;
        head = prev;
        tail = current
    }

    public void deleteFromTail() {
        if (isEmpty()) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = head;
        tail = current;
    }

    public void deleteFromHead() {
        if (isEmpty()) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
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
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void addToHead(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
}



public class DoublyLinkedList {
    Node head = null;
    Node tail = null;

    public void addToHead(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

    }

    public void addToTail(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = tail =  newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int element, int position) {
        Node newNode = new Node(element);
        Node current = head;

        if (position == 0) {
            addToHead(element);
        }

        else {
            for (int i = 1; i < position; i++) {
                current = current.next;
            }

            if (current.next == null || current == null) {
                addToTail(element);
            }

            newNode.next = current.next;
            current.next.prev = newNode;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public void removeFromHead() {
        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeFromTail() {
        if (head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void removeNode(int element) {
        if (head.data == element) {
            removeFromHead();
        }
        else if (tail.data == element) {
            removeFromTail();
        }
        else {
            Node current = head;

            while(current != null && current.data != element) {
                current = current.next;
            }

            if (current == null) {
                return;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isInList(int element) {
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverseList() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node current = tail;
        System.out.println("The Reversed List : ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node current = head;
        System.out.println("The List : ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


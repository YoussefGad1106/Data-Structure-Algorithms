public class SingleLinkedList {

    Node head = null;
    Node tail = null;

    public void addToHead(int element) {

        if (head == null)
            head = tail = new Node(element);
        else {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }

    }

    public void addToTail(int element) {
        if (head == null)
            head = tail = new Node(element);
        else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }
    }

    public void addAtPosition(int element, int position) {

        if (position == 0)
            addToHead(element);

        if (head == null) {
            System.out.println("Error: List is empty. Cannot add");
            return;
        }

        Node temp = head ;
        for (int i = 1; i < position; i++) {
            if (temp.next == null) {
                System.out.println("Error: Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp == tail)
            addToTail(element);
        else {
            Node newNode = new Node(element);
            newNode.next = temp.next;
            temp.next = newNode;
        }


    }

    public void deleteFromHead() {

        if (head == tail)
            head = tail = null;
        else
            head = head.next;
    }

    public void deleteFromTail() {

        if (head == tail)
            head = tail = null;
        else {
            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
    }

   public void reverseList()
   {
       Node current = head;
       Node prev = null;
       Node next = null;

       if(head == null)
           System.out.println("Error: List is empty. Cannot reverse");

       while (current != null)
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       head = prev;
   }

    public boolean isInList(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
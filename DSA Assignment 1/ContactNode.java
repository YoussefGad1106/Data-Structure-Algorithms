public class ContactNode {
    String name;
    String phoneNumber;
    ContactNode next;

    public ContactNode(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public ContactNode(String name, String phoneNumber, ContactNode next) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = next;
    }

    public ContactNode()
    {
        this.name = null;
        this.phoneNumber = null;
        this.next = null;
    }
}


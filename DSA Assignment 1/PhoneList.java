public class PhoneList {

    ContactNode head = null;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void addContact(String name, String phoneNumber)
    {
        if (name == null || name.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) { 
            System.out.println("Invalid contact details. Both name and phone number are required.");
            return;
        }
        
        if (searchContact(name) != null) {
            System.out.println("Contact already exists.");
            return;
        }
        
        System.out.println("Adding Contact : ");

        if (isEmpty()) {
            head = new ContactNode(name, phoneNumber);
            System.out.println("Contact added: " + name + ", " + phoneNumber);
        }
        else {
            ContactNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ContactNode(name, phoneNumber);
            System.out.println("Contact added: "+name+", "+phoneNumber);
        }

        System.out.println();
    }

    public void displayList ()
    {
        if (isEmpty()) {
            System.out.println("Phone list is empty.");
            return;
        }
        else {
            System.out.println("Displaying Contacts : ");
            ContactNode current = head;
            while (current != null) {
                System.out.println("Name : "+current.name+", Phone Number : "+current.phoneNumber);
                current = current.next;
            }

            System.out.println();
        }
    }

    public void searchContact(String name)
    {
        if (isEmpty()) {
            System.out.println("Phone list is empty.");
            return;
        }
        else {
            System.out.println("Searching for Contact : ");
            ContactNode current = head;

            while (current != null) {
                if (current.name.equalsIgnoreCase(name)) {
                    System.out.println("Contact found: Name : "+current.name+", Phone Number : "+current.phoneNumber);
                    break;
                }
                current = current.next;
            }

            if (current == null) {
                System.out.println("Contact with name : "+name+" not found.");
            }

            System.out.println();
        }
    }

    public void deleteContact(String name)
    {
        System.out.println("Deleting Contact : ");

        if (isEmpty()) {
            System.out.println("Phone list is empty.");
            return;
        }
        if (head.name.equals(name)) {
            System.out.println("Deleting Contact: " + head.name + ", Phone Number: " + head.phoneNumber);
            head = head.next;
        }
        else {
            ContactNode current = head;
            while (current.next != null) {
                if (current.next.name.equals(name)) {
                    current.next = current.next.next;
                    System.out.println("Deleting Contact : "+name+", Phone Number : "+current.phoneNumber);
                    break;
                }
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Contact with name : "+name+" not found.");
            }
        }
        System.out.println();
    }
}

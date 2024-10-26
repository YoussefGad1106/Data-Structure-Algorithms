public class Main {
    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();

        phoneList.addContact("Alice","123-456-7890");
        phoneList.displayList ();
        phoneList.searchContact("Alice");
        phoneList.searchContact("Bob");
        phoneList.deleteContact("Bob");
        phoneList.deleteContact("Alice");
        phoneList.displayList ();
    }
}

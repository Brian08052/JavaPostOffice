class QueueTester {

    public static void main(String[] args) {
        QueueOfCustomers q = new QueueOfCustomers(3);
        if (q.length() != 0) System.out.println("Error A");
        if (! q.isEmpty()) System.out.println("Error B");
        if (q.isFull()) System.out.println("Error C");
        if (q.getFront() != null) System.out.println("Error D");
        q.remove(); // Should be ignored
        Customer c1 = new Customer(1, 12);
        q.insert(c1);
        if (q.length() != 1) System.out.println("Error E");
        if (q.isEmpty()) System.out.println("Error F");
        if (q.isFull()) System.out.println("Error G");
        if (q.getFront() != c1) System.out.println("Error H");
        Customer c2 = new Customer(2, 14);
        q.insert(c2);
        if (q.length() != 2) System.out.println("Error I");
        if (q.isEmpty()) System.out.println("Error J");
        if (q.isFull()) System.out.println("Error K");
        if (q.getFront() != c1) System.out.println("Error L");
        q.remove();
        if (q.length() != 1) System.out.println("Error M");
        if (q.isEmpty()) System.out.println("Error N");
        if (q.isFull()) System.out.println("Error O");
        if (q.getFront() != c2) System.out.println("Error P");
        Customer c3 = new Customer(3, 17);
        Customer c4 = new Customer(4, 23);
        q.insert(c3);
        q.insert(c4);
        if (q.length() != 3) System.out.println("Error Q");
        if (q.isEmpty()) System.out.println("Error R");
        if (! q.isFull()) System.out.println("Error S");
        if (q.getFront() != c2) System.out.println("Error T");
        Customer c5 = new Customer(5, 25);
        q.insert(c5); // should be ignored
        if (q.length() != 3) System.out.println("Error U");
        if (q.isEmpty()) System.out.println("Error V");
        if (! q.isFull()) System.out.println("Error W");
        if (q.getFront() != c2) System.out.println("Error X");
        System.out.println(q);
        q.remove();
        q.remove();
        System.out.println(q);
        q.remove();
        if (q.length() != 0) System.out.println("Error Y");
        if (! q.isEmpty()) System.out.println("Error Z");
        if (q.isFull()) System.out.println("Error Z again");
        if (q.getFront() != null) System.out.println("Error Z once more");
        System.out.println(q);
    }
}

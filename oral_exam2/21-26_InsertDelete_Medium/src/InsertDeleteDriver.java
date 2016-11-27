/**
 * Driver program to show functionality of InsertDelete program
 *
 * @author Jason Ryan
 */
public class InsertDeleteDriver {

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();

        System.out.println("List is empty: " + testList.isEmpty());

        System.out.println("Node deleted: " + testList.deleteFirst());

        testList.insertFront(2);
        testList.print();
        testList.insertFront(1);
        testList.print();
        testList.insert(0,0);
        testList.print();
        testList.insertEnd(3);
        testList.print();
        testList.insertEnd(5);
        testList.print();
        testList.insert(4, 4);
        testList.print();
        testList.insert(6, 6);
        testList.print();

        System.out.println("Out of bounds insertion test: ");
        testList.insert(-1, -1);
        testList.insert(99, 99);

        System.out.println("List is empty: " + testList.isEmpty());

        System.out.println("(Delete out of bounds test) Node deleted: " + testList.delete(10));
        System.out.println("(Delete out of bounds test) Node deleted: " + testList.delete(-53));
        testList.print();

        System.out.println("Node deleted: " + testList.delete(3));
        testList.print();
        System.out.println("Node deleted: " + testList.deleteFirst());
        testList.print();
        System.out.println("Node deleted: " + testList.deleteLast());
        testList.print();
    }
}

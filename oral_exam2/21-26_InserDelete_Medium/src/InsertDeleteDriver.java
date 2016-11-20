/**
 * Driver program to show functionality of InsertDelete program
 *
 * @author Jason Ryan
 */
public class InsertDeleteDriver {
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

        System.out.println("List is empty: " + testList.isEmpty());
        System.out.println("Node deleted: " + testList.deleteFirst());
        testList.print();
        System.out.println("Node deleted: " + testList.deleteLast());
        testList.print();
    }
}

/**
 * Driver program to show functionality of InsertDelete program
 *
 * @author Jason Ryan
 */
public class InsertDeleteDriver {
    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();

        System.out.println("List is empty: " + testList.isEmpty());

        testList.insertFront(1);
        testList.insertFront(2);
        testList.insertEnd(3);
        testList.insertEnd(4);

        System.out.println("List is empty: " + testList.isEmpty());

        System.out.println("Node deleted: " + testList.deleteFirst());
        System.out.println("Node deleted: " + testList.deleteLast());
    }
}

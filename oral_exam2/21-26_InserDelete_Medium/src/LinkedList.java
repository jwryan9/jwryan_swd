/**
 * Class that implements linked list behavior
 *
 * @author  Jason Ryan
 */
public class LinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    /**
     * Constructor
     */
    LinkedList() {
        firstNode = lastNode = null;
    }

    /**
     * Method to insert new node at the front of linked list
     *
     * @param newItem data to be inserted at start of linked list
     */
    public void insertFront(T newItem) {
        if(this.isEmpty()) {
            firstNode = lastNode = new Node<>(newItem);
        } else {
            firstNode = new Node<>(newItem, firstNode);
        }
    }

    /**
     * Method to insert new node at the end of linked list
     *
     * @param newItem data to be inserted at end of linked list
     */
    public void insertEnd(T newItem) {
        if(this.isEmpty()) {
            firstNode = lastNode = new Node<>(newItem);
        } else {
            lastNode.setNextNode(new Node<>(newItem));
        }
    }

    /**
     * Removes the first node of linked list
     *
     * @return data stored in removed node
     */
    public T deleteFirst() {
        T removed = null;

        // Set references for first node if list is not empty
        if(this.isEmpty()) {
            System.out.println("Empty linked list. Nothing to delete.");
        } else if(firstNode == lastNode) {
            removed = firstNode.getData();
            firstNode = lastNode = null;
        } else {
            removed = firstNode.getData();
            firstNode = firstNode.getNextNode();
        }

        return removed;
    }

    /**
     * Removes the last node of linked list
     *
     * @return data stored in removed node
     */
    public T deleteLast() {
        T removed = lastNode.getData();

        if(this.isEmpty()) {
            System.out.println("Empty linked list. Nothing to delete.");
        } else if(firstNode == lastNode) {
            removed = firstNode.getData();
            firstNode = lastNode = null;
        } else {
            Node<T> tempNode = firstNode;

            // Navigate to second to last node in linked list
            while(tempNode.getNextNode() != null) {
                tempNode = tempNode.getNextNode();
            }

            lastNode = tempNode;
            tempNode.setNextNode(null);
        }

        return removed;
    }

    /**
     * Determins whether linked list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

}

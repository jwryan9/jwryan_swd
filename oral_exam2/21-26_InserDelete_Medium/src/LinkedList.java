/**
 * Class that implements linked list behavior
 *
 * @author  Jason Ryan
 */
public class LinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int length;

    /**
     * Constructor
     */
    LinkedList() {
        firstNode = lastNode = null;
        length = 0;
    }

    /**
     * Method to insert new node at the front of linked list
     *
     * @param data data to be inserted at start of linked list
     */
    public void insertFront(T data) {
        if(this.length == 0) {
            firstNode = lastNode = new Node<>(data);
        } else {
            firstNode = new Node<>(data, firstNode);
        }

        length++;
    }

    /**
     * Method to insert new node at the end of linked list
     *
     * @param data data to be inserted at end of linked list
     */
    public void insertEnd(T data) {
        if(this.length == 0) {
            firstNode = lastNode = new Node<>(data);
        } else {
            lastNode.setNextNode(new Node<>(data));
            lastNode = lastNode.getNextNode();
        }

        length++;
    }

    /**
     * Method to insert new node at specified position in linked list
     *
     * @param data data to be inserted in linked list
     * @param pos position in linked list to insert
     */
    public void insert(T data, int pos) {
        if(pos < 0 || pos > length) {
            System.out.println("Position out of bounds. Node not added.");
            return;
        } else if(pos == 0) {
            insertFront(data);
        } else if(pos == length) {
            insertEnd(data);
        } else {
            Node<T> tempNode = firstNode;

            // Loop to position in list
            while(pos > 1) {
                tempNode = tempNode.getNextNode();
                pos--;
            }

            // Make node insertion
            if(tempNode.getNextNode() != null) {
                tempNode.setNextNode(new Node<T>(data, tempNode.getNextNode()));
            } else {
                tempNode.setNextNode(new Node<T>(data));
            }

            length++;
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
        if(this.length == 0) {
            System.out.println("Empty linked list. Nothing to delete.");
            return removed;
        } else if(firstNode == lastNode) {
            removed = firstNode.getData();
            firstNode = lastNode = null;
        } else {
            removed = firstNode.getData();
            firstNode = firstNode.getNextNode();
        }

        length--;
        return removed;
    }

    /**
     * Removes the last node of linked list
     *
     * @return data stored in removed node
     */
    public T deleteLast() {
        T removed = null;

        if(this.length == 0) {
            System.out.println("Empty linked list. Nothing to delete.");
            return removed;
        } else if(firstNode == lastNode) {
            removed = firstNode.getData();
            firstNode = lastNode = null;
        } else {
            Node<T> tempNode = firstNode;

            // Navigate to second to last node in linked list
            while(tempNode.getNextNode() != lastNode) {
                tempNode = tempNode.getNextNode();
            }

            removed = lastNode.getData();

            // Update last node
            lastNode = tempNode;
            lastNode.setNextNode(null);
        }

        length--;

        return removed;
    }

    /**
     * Method to delete a node at specified location.
     *
     * @param pos position in linked list to delete
     * @return data deleted from linked list
     */
    public T delete(int pos) {
        T removed = null;

        if(pos < 0 || pos > length) {
            System.out.println("Position out of bounds. Node not deleted.");
        } else if(this.length == 0) {
            System.out.println("Empty linked list. Nothing to delete.");
        } else if(pos == 0) {
            removed = this.deleteFirst();
        } else if(pos == length) {
            removed = this.deleteLast();
        } else {
            Node<T> tempNode = firstNode;

            // Navigate to node to be removed
            while(pos > 1) {
                tempNode = tempNode.getNextNode();
                pos--;
            }

            // Remove node
            removed = tempNode.getNextNode().getData();
            tempNode.setNextNode(tempNode.getNextNode().getNextNode());

            length--;
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

    /**
     * Output contents of linked list to screen
     */
    public void print() {
        if(this.isEmpty()) {
            System.out.println("Empty linked list.");
        } else {
            System.out.println("Length: " + length);
            Node<T> node = firstNode;
            while(node != null) {
                System.out.print(node.getData() + " ");
                node = node.getNextNode();
            }

            System.out.println();
        }
    }

}

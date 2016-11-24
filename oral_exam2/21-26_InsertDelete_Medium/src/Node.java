/**
 * Class to represent nodes in a linked list
 *
 * @author Jason Ryan
 */
public class Node<T> {
    private T data;
    private Node<T> nextNode;

    /**
     * Single argument constructor
     *
     * @param data data to be held in node
     */
    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }

    /**
     * Two argument constructor
     *
     * @param data data to be held in node
     * @param nextNode node to follow new node
     */
    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    /**
     * Getter for data value
     *
      * @return data held in node
     */
    public T getData() {
        return data;
    }

    /**
     * Getter for next node
     *
     * @return following node
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

    /**
     * Setter for data value
     *
      * @param data new data value
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Setter for next node
     *
     * @param nextNode new following node
     */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}

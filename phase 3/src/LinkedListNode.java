public class LinkedListNode<T, U> extends SearchableNode<T, U> {
    private LinkedListNode<T, U> next;
    private LinkedListNode<T, U> previous;

    public LinkedListNode(T index, U value) {
        setIndex(index);
        setvalue(value);
        next = null;
        previous = null;
    }

    public LinkedListNode<T, U> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T, U> next) {
        this.next = next;
    }

    public LinkedListNode<T, U> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode<T, U> previous) {
        this.previous = previous;
    }
}


// In the LinkedList class, the search method iterates through the linked list from the head and prints the items it goes through.
// It returns the value associated with the index if found or null if not found.
//The add method adds a new node at the beginning of the linked list, and the delete method removes a node with the specified index.
//The LinkedListNode class extends SearchableNode and includes a next field to reference the next node in the list.
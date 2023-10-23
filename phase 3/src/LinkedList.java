// we create two classes: LinkedList and LinkedListNode.
// The LinkedList class will implement the Query interface, and the LinkedListNode class will extend from SearchableNode.
// Additionally, we ensure that the search method prints the items it went through from the head node.

public class LinkedList<T, U> implements Query<T, U> {
    private LinkedListNode<T, U> head;

    public LinkedList() {
        head = null;
    }

    // Question 2
    public U searchFromTail(T index) {
        LinkedListNode<T, U> current = head;
        LinkedListNode<T, U> prev = null;
        System.out.println("Searching from the tail of the linked list:");

        // Traverse to the end of the list to start searching from the tail.
        while (current != null) {
            prev = current;
            current = current.getNext();
        }

        while (prev != null) {
            System.out.println("Index: " + prev.getIndex() + ", Value: " + prev.getvalue());
            if (prev.getIndex().equals(index)) {
                return prev.getvalue();
            }
            prev = prev.getPrevious();
        }
        System.out.println("Index not found.");
        return null;
    }


    // Question 1
    @Override
    public U search(T index) {
        LinkedListNode<T, U> current = head;
        System.out.println("Searching through the linked list:");
        while (current != null) {
            System.out.println("Index: " + current.getIndex() + ", Value: " + current.getvalue());
            if (current.getIndex().equals(index)) {
                return current.getvalue();
            }
            current = current.getNext();
        }
        System.out.println("Index not found.");
        return null;
    }

    @Override
    public Query<T, U> add(T index, U value) {
        LinkedListNode<T, U> newNode = new LinkedListNode<>(index, value);
        newNode.setNext(head);
        head = newNode;
        return this;
    }

    @Override
    public Query<T, U> delete(T index) {
        if (head == null) {
            return this;
        }
        if (head.getIndex().equals(index)) {
            head = head.getNext();
            return this;
        }
        LinkedListNode<T, U> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getIndex().equals(index)) {
                current.setNext(current.getNext().getNext());
                break;
            }
            current = current.getNext();
        }
        return this;
    }
}

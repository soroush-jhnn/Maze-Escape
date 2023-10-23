public class SkipListNode<T extends Comparable<T>, U> extends SearchableNode<T, U> {
    private SkipListNode<T, U>[] next;

    public SkipListNode(T index, U value, int level) {
        setIndex(index);
        setvalue(value);
        next = new SkipListNode[level];
    }

    public SkipListNode<T, U> getNext(int level) {
        return next[level];
    }

    public void setNext(int level, SkipListNode<T, U> nextNode) {
        next[level] = nextNode;
    }
}

public class BinarySearchTreeNode<T extends Comparable<T>, U> extends SearchableNode<T, U> {
    private BinarySearchTreeNode<T, U> left;
    private BinarySearchTreeNode<T, U> right;

    public BinarySearchTreeNode(T index, U value) {
        setIndex(index);
        setvalue(value);
        left = null;
        right = null;
    }

    public BinarySearchTreeNode<T, U> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<T, U> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T, U> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<T, U> right) {
        this.right = right;
    }
}

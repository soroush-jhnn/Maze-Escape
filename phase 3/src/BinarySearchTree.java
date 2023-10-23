public class BinarySearchTree<T extends Comparable<T>, U> implements Query<T, U> {
    private BinarySearchTreeNode<T, U> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public U search(T index) {
        System.out.println("Searching in the Binary Search Tree:");
        return searchFromNode(root, index);
    }

    private U searchFromNode(BinarySearchTreeNode<T, U> node, T index) {
        if (node == null) {
            System.out.println("Index not found.");
            return null;
        }

        System.out.println("Index: " + node.getIndex() + ", Value: " + node.getvalue());

        int compareResult = index.compareTo(node.getIndex());
        if (compareResult == 0) {
            return node.getvalue();
        } else if (compareResult < 0) {
            return searchFromNode(node.getLeft(), index);
        } else {
            return searchFromNode(node.getRight(), index);
        }
    }

    // Add and delete methods can be implemented for the BinarySearchTree here...

//    @Override
//    public Query add(T index, U value) {
//        return null;
//    }
//
//    @Override
//    public Query delete(T index) {
//        return null;
//    }

    public BinarySearchTree<T, U> add(T index, U value) {
        root = addNode(root, index, value);
        return this;
    }

    private BinarySearchTreeNode<T, U> addNode(BinarySearchTreeNode<T, U> node, T index, U value) {
        if (node == null) {
            return new BinarySearchTreeNode<>(index, value);
        }

        int compareResult = index.compareTo(node.getIndex());

        if (compareResult < 0) {
            node.setLeft(addNode(node.getLeft(), index, value));
        } else if (compareResult > 0) {
            node.setRight(addNode(node.getRight(), index, value));
        }

        return node;
    }

    public BinarySearchTree<T, U> delete(T index) {
        root = deleteNode(root, index);
        return this;
    }

    private BinarySearchTreeNode<T, U> deleteNode(BinarySearchTreeNode<T, U> node, T index) {
        if (node == null) {
            return node; // Value not found, no change.
        }

        int compareResult = index.compareTo(node.getIndex());

        if (compareResult < 0) {
            node.setLeft(deleteNode(node.getLeft(), index));
        } else if (compareResult > 0) {
            node.setRight(deleteNode(node.getRight(), index));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setIndex(minValue(node.getRight()));
            node.setRight(deleteNode(node.getRight(), node.getIndex()));
        }

        return node;
    }

    private T minValue(BinarySearchTreeNode<T, U> node) {
        T minValue = node.getIndex();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getIndex();
            node = node.getLeft();
        }
        return minValue;
    }



    // Additional methods for adding and deleting nodes in the BST...
}

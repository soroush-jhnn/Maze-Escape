public class SkipList<T extends Comparable<T>, U> implements Query<T, U> {
    private static final int MAX_LEVEL = 16; // Maximum number of levels in the Skip List
    private static final double PROMOTION_RATE = 0.25; // Promotion rate

    private SkipListNode<T, U>[] head;
    private int maxLevel;

    public SkipList(int level) {
        head = new SkipListNode[MAX_LEVEL];
        for (int i = 0; i < MAX_LEVEL; i++) {
            head[i] = new SkipListNode<>(null, null, level);
        }
        maxLevel = 1;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < PROMOTION_RATE && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    @Override
    public U search(T index) {
        System.out.println("Searching in the Skip List from the highest level:");
        SkipListNode<T, U> current = head[maxLevel - 1];

        for (int level = maxLevel - 1; level >= 0; level--) {
            while (current.getNext(level) != null && index.compareTo(current.getNext(level).getIndex()) >= 0) {
                current = current.getNext(level);
                System.out.println("Level: " + (level + 1) + ", Index: " + current.getIndex() + ", Value: " + current.getvalue());
            }
        }

        if (current.getIndex() != null && index.compareTo(current.getIndex()) == 0) {
            return current.getvalue();
        } else {
            System.out.println("Index not found.");
            return null;
        }
    }

    // Add and delete methods can be implemented for the Skip List here...

//    @Override
//    public Query add(T index, U value) {
//        return null;
//    }
//
//    @Override
//    public Query delete(T index) {
//        return null;
//    }

    public SkipList<T, U> add(T index, U value) {
        int level = randomLevel(); // Determine the level for the new node.
        SkipListNode<T, U> newNode = new SkipListNode<>(index, value, level);

        for (int i = 0; i < level; i++) {
            newNode.setNext(i, null); // Initialize all next references to null.
        }

        for (int i = maxLevel - 1; i >= 0; i--) {
            while (head[i].getNext(i) != null && index.compareTo(head[i].getNext(i).getIndex()) > 0) {
                head[i] = head[i].getNext(i); // Traverse at level i.
            }

            if (i < level) {
                // Insert the new node at this level.
                newNode.setNext(i, head[i].getNext(i));
                head[i].setNext(i, newNode);
            }
        }

        return this;
    }

    public SkipList<T, U> delete(T index) {
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (head[i].getNext(i) != null && index.compareTo(head[i].getNext(i).getIndex()) > 0) {
                head[i] = head[i].getNext(i); // Traverse at level i.
            }

            if (head[i].getNext(i) != null && index.compareTo(head[i].getNext(i).getIndex()) == 0) {
                // Found the node to delete at this level.
                head[i].setNext(i, head[i].getNext(i).getNext(i)); // Remove the node.
            }
        }

        return this;
    }


    // Additional methods for adding and deleting nodes in the Skip List...
}

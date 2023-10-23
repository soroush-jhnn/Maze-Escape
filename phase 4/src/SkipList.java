import java.util.Random;

class SkipListNode<T, U> {
    T key;
    U value;
    SkipListNode<T, U>[] next;

    public SkipListNode(int level, T key, U value) {
        this.key = key;
        this.value = value;
        next = new SkipListNode[level];
    }
}

public class SkipList<T extends Comparable<T>, U> {
    private SkipListNode<T, U> head;
    private int maxLevel;
    private int size;
    private Random random;

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        this.head = new SkipListNode<>(maxLevel, null, null);
        this.size = 0;
        this.random = new Random();
    }

    public U search(T key) {
        SkipListNode<T, U> current = head;
        for (int level = maxLevel - 1; level >= 0; level--) {
            while (current.next[level] != null && key.compareTo(current.next[level].key) > 0) {
                current = current.next[level];
            }
        }

        if (current.next[0] != null && key.equals(current.next[0].key)) {
            return current.next[0].value;
        } else {
            return null;
        }
    }

    public void insert(T key, U value) {
        int level = randomLevel();
        SkipListNode<T, U> newNode = new SkipListNode<>(level, key, value);

        SkipListNode<T, U> current = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (current.next[i] != null && key.compareTo(current.next[i].key) > 0) {
                current = current.next[i];
            }

            if (i < level) {
                newNode.next[i] = current.next[i];
                current.next[i] = newNode;
            }
        }

        size++;
    }

    public void delete(T key) {
        SkipListNode<T, U> current = head;
        SkipListNode<T, U>[] update = new SkipListNode[maxLevel];
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (current.next[i] != null && key.compareTo(current.next[i].key) > 0) {
                current = current.next[i];
            }
            update[i] = current;
        }

        if (current.next[0] != null && key.equals(current.next[0].key)) {
            for (int i = 0; i < maxLevel; i++) {
                if (update[i].next[i] != null && key.equals(update[i].next[i].key)) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
            size--;
        }
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < 0.5 && level < maxLevel) {
            level++;
        }
        return level;
    }

    public int size() {
        return size;
    }

    // hash function
    public int hashOverallScore(double overallScore) {
        long bits = Double.doubleToLongBits(overallScore); // Convert to bits.
        return (int) (bits ^ (bits >>> 32)); // Apply XOR operation to generate the hash value.
    }

    // another hash function based on student number
    public int hashStudentNumber(String studentNumber) {
        int hash = 0;
        for (int i = 0; i < studentNumber.length(); i++) {
            hash = 31 * hash + studentNumber.charAt(i);
        }
        return Math.abs(hash); // Ensure non-negative hash values.
    }

}

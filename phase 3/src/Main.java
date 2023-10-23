public class Main {
    public static void main(String[] args) {

        // Question 1 (LinkedList):
        // Create a LinkedList instance
//        LinkedList<String, Integer> linkedList = new LinkedList<>();
//
//        // Add elements to the linked list
//        linkedList.add("A", 1)
//                .add("B", 2)
//                .add("C", 3);
//
//        // Search for an element
//        Integer result = linkedList.search("B");
//        if (result != null) {
//            System.out.println("Found: " + result);
//        } else {
//            System.out.println("Not found.");
//        }


        // Question 2
        // Create a custom LinkedList instance
//        LinkedList<String, Integer> customList = new LinkedList<>();
//
//        // Add elements to the linked list
//        customList.add("A", 1);
//        customList.add("B", 2);
//        customList.add("C", 3);
//        customList.add("D", 4);
//        customList.add("E", 5);
//
//        // Search for an element from the tail of the list
//        Integer result = customList.searchFromTail("H");
//
//        if (result != null) {
//            System.out.println("Found from the tail: " + result);
//        } else {
//            System.out.println("Not found.");
//        }


        // Question 3 (BinarySearchTree):
        // Create a BinarySearchTree instance
//        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
//
//        // Add elements to the binary search tree
//        binarySearchTree.add(5, "Five")
//                .add(7, "Seven")
//                .add(2, "Two")
//                .add(3, "Three")
//                .add(4, "Four");
//
//        // Search for an element
//        String result = binarySearchTree.search(3);
//        if (result != null) {
//            System.out.println("Found: " + result);
//        } else {
//            System.out.println("Not found.");
//        }


        // Question 4 (SkipList):
        // Create a SkipList instance
        int level = 4;
        SkipList<Integer, String> skipList = new SkipList<>(level);

        // Add elements to the skip list
        skipList.add(5, "Five")
                .add(3, "Three")
                .add(7, "Seven")
                .add(2, "Two")
                .add(4, "Four");

        // Search for an element
        String result = skipList.search(7);
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Not found.");
        }
    }
}

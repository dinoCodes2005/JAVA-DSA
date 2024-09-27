package Heap;

public class Main {
    public static void main(String[] args) {   
        BinaryHeap newBP = new BinaryHeap(5);
        newBP.insert(10, "min");
        newBP.insert(5, "min");
        newBP.insert(15, "min");
        newBP.insert(1, "min");
        newBP.levelOrder();
        newBP.peek();
    }
}

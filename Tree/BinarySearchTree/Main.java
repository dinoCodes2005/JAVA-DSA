package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST newBST = new BST();
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(60);
        newBST.insert(80);
        newBST.insert(100);
        newBST.insert(20);
        newBST.insert(40);

        newBST.levelOrder();
        newBST.deleteNode(newBST.root, 90);
        newBST.levelOrder();

    }
}

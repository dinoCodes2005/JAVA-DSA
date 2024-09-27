package BinaryTreeUsingArray;

public class MainMethod {
    public static void main(String[] args) {
        BinaryTreeArray BinaryTree = new BinaryTreeArray(10);
        BinaryTree.insert("N1");
        BinaryTree.insert("N2");
        BinaryTree.insert("N3");
        BinaryTree.insert("N4");
        BinaryTree.insert("N5");
        BinaryTree.insert("N6");
        BinaryTree.insert("N7");
        BinaryTree.insert("N8");
        BinaryTree.insert("N9");
        System.out.println("");

        BinaryTree.preOrder(1);
        System.out.println("");
        BinaryTree.inOrder(1);
        System.out.println();
        BinaryTree.postOrder(1);
        System.out.println();
        BinaryTree.levelOrder();
        BinaryTree.delete("N6");
        BinaryTree.levelOrder();
        BinaryTree.search("N5");
        BinaryTree.deleteBinaryTree();

    }
}

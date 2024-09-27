package BinaryTreeUsingLL;


public class Main { 
    public static void main(String[] args) {
        
        BinaryTreeLL binaryTree = new BinaryTreeLL();
        BinaryNode N1 = new BinaryNode();
        N1.value="N1";
        BinaryNode N2 = new BinaryNode();
        N2.value="N2";
        BinaryNode N3 = new BinaryNode();
        N3.value="N3";
        BinaryNode N4 = new BinaryNode();
        N4.value="N4";
        BinaryNode N5 = new BinaryNode();
        N5.value="N5";
        BinaryNode N6 = new BinaryNode();
        N6.value="N6";
        BinaryNode N7 = new BinaryNode();
        N7.value="N7";
        BinaryNode N8 = new BinaryNode();
        N8.value="N8";
        BinaryNode N9 = new BinaryNode();
        N9.value="N9";
        BinaryNode N10 = new BinaryNode();
        N10.value="N10";
        
        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N4.left = N8;
        N4.right = N9;
        N9.right = N10;
        N3.left = N6;
        N3.right = N7;
        
        binaryTree.root = N1;
        

        // binaryTree.preOrder(binaryTree.root);
        // binaryTree.inOrder(binaryTree.root);
        // binaryTree.postOrder(binaryTree.root);
        binaryTree.levelOrder();
        System.out.println("");
        binaryTree.deleteDeepestNode();
        binaryTree.levelOrder();
        binaryTree.deleteNode("N5");
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.deleteBinaryTree();
        // binaryTree.search("N6");
        // binaryTree.insert("N10");
        // binaryTree.insert("N11");
        
    }

}

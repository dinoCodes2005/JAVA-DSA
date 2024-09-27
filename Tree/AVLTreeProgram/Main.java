package AVLTreeProgram;


public class Main {
    public static void main(String[] args) {
        AVL newAVL= new AVL();
        newAVL.insert(30);
        newAVL.insert(25);
        newAVL.insert(35);
        newAVL.insert(20);
        newAVL.insert(15);
        newAVL.insert(5);
        newAVL.insert(10);
        newAVL.insert(50);
        newAVL.insert(60);
        newAVL.insert(70);
        newAVL.insert(65);
        newAVL.levelOrder();
        newAVL.deleteNode(15);
        System.out.println();
        newAVL.levelOrder();


    }
}

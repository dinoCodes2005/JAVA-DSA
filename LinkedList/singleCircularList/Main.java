package singleCircularList;

public class Main {
    public static void main(String[] args) {
        SinglyCircularLinkedList sCL=new SinglyCircularLinkedList();
        sCL.createCircularLinkedList(5);
        sCL.insertCSL(5, 1);
        sCL.insertCSL(8, 2);
        sCL.insertCSL(4, 3);
        sCL.insertCSL(0, 4);
        sCL.printList();
        sCL.deletion(2);
        sCL.printList();
        sCL.printList();
        sCL.deleteEntireCSL();

        System.out.println(sCL.head.value);
    }
}

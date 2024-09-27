package doubleLinkedList;

public class Main {
    public static void main(String[] args) {
        doublyLinkedList dLL = new doublyLinkedList();
        QuestionsDLL obj =new QuestionsDLL();
        dLL.createDoublyLinkedList(5);
        dLL.insertDLL(1, 1);
        dLL.insertDLL(6, 2);
        dLL.insertDLL(9, 3);
        dLL.insertDLL(8, 4);
        dLL.insertDLL(2, 5);
        dLL.searching(1);
        dLL.printDLL();
        dLL.deletion(2);
        dLL.printDLL();
        obj.partition(dLL, 5);
        dLL.printDLL();
        dLL.reversePrintDLL();
    }
    
}

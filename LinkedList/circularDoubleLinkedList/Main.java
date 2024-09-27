package circularDoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        circularDoubleLinkedList cDLL = new circularDoubleLinkedList();
        cDLL.createCircularDLL(5);
        cDLL.insertCDLL(4, 0);
        cDLL.insertCDLL(6, 0);
        cDLL.insertCDLL(9, 2);
        cDLL.insertCDLL(3, 1);
        cDLL.insertCDLL(10, 4);
        cDLL.insertCDLL(0, 3);
        cDLL.Searching(6);

        cDLL.printDLL();
        cDLL.Deletion(4);

        cDLL.printDLL();
        cDLL.reversePrintDLL();
        cDLL.deleteEntireCDL();
    }
}

package singleLinkedList;

public class MainMethod {
    public static void main(String[] args) {
        
        SinglyLinkedList sLL=new SinglyLinkedList();        //getting an object of the SinglyLinkedList class because other methods like insert(), deletion() is stored inside it 
        Questions obj = new Questions();                    //getting an object of the Questions class because deleteDups() is present inside it 
        sLL.createSinglyLinkedList(5);
        sLL.insertLinkedList(6, 1);
        sLL.insertLinkedList(7, 3);
        sLL.insertLinkedList(6, 4);
        sLL.insertLinkedList(9, 5);
        sLL.insertLinkedList(10, 4);
        sLL.insertLinkedList(2, 2);
        sLL.Deletion(2);
        sLL.Traversal();
        sLL.Searching(7);
        sLL.rotate(2);
        sLL.Traversal();
        obj.deleteDups(sLL);                                //using object "obj" to call the deleteDups() function then putting sLL(object of SinglyLinkedList) as parameter
        sLL.Traversal();
        obj.partition(sLL, 9);
        sLL.Traversal();
        obj.nthToLast(sLL, 3);  
        sLL.Traversal();  

        sLL.deleteEntireSLL();
    }
}

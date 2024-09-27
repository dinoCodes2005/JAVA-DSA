



public class StackUsingLL {
    SinglyLinkedList ll;
    StackUsingLL()
    {
        ll=new SinglyLinkedList();
    }

    public void push(int value)                 //inserting at the beginning of the LL
    {
        ll.insertSinglyLinkedList(value,0);
        System.out.println("Inserted successfully");
    }

    public boolean isEmpty()
    {
        if(ll.head==null)
        return true;
        else
        return false;
    }

    public int pop()                            //deletion from the beginning of LL
    {
        int result=-1;
        if(ll.head==null)
        {
            System.out.println("The stack is empty");
        }
        else{
            System.out.println("Popped successfully");
            result=ll.head.value;
            ll.deletion(0);
        }
        return result;
    }

    public int peek()
    {
        int result=-1;
        if(ll.head==null)
            System.out.println("The stack is empty");
        else
        result=ll.head.value;
        return result;

    }

    public void deleteStack()
    {
        ll.head=null;
        System.out.println("The stack has been deleted");
    }


    
}

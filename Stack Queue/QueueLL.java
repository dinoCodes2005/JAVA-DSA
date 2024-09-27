

public class QueueLL {
    SinglyLinkedList ll;

    public QueueLL()
    {
        ll=new SinglyLinkedList();
        System.out.println("The Queue Linked List has been successfully created");

    }

    public boolean isEmpty()
    {
        if(ll.head==null)
        return true;
        else
        return false;
    }

    public void enQueue(int value)
    {
        ll.insertSinglyLinkedList(value,ll.size);
        System.out.println("Successfully inserted "+value);
    }

    public int deQueue()
    {
        if(isEmpty())
        return -1;
        int result=ll.head.value;
        ll.deletion(0);
        System.out.println("Successfully deleted "+result);
        return result;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("The Queue is Empty");
            return -1;
        }
        else 
        return ll.head.value;
    }

    public void deleteQueue()
    {
        ll.head=null;
        ll.tail=null;
        System.out.println("Queue has been deleted successfully");
    }
}

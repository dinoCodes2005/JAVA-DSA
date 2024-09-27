package doubleLinkedList;


public class doublyLinkedList {

    public doubleNode head;         //object of the class doubleNode to store the head reference
    public doubleNode tail;         //object of the class doubleNode to store the tail reference
    public int size;

    public doublyLinkedList()
    {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public doubleNode createDoublyLinkedList(int value)
    {
        doubleNode node=new doubleNode();
        node.value=value;
        node.next=null;
        node.prev=null;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void insertDLL(int value, int location)
    {
        doubleNode node =new doubleNode();
        node.value=value;
        if(head==null)
        createDoublyLinkedList(value);
        else if(location==0)
        {
            node.next=head;
            node.prev=null;
            head.prev=node;
            head=node;
        }
        else if(location>=size)
        {
            doubleNode temp=head;
            for(int i=0;i<size;i++)
            {
                temp=temp.next;
            }
            tail.next=node;
            node.next=null;
            node.prev=tail;
            tail=node;
        }
        else
        {
            doubleNode prevNode=head;
            for(int i=0;i<location-1;i++)
            prevNode=prevNode.next;

            doubleNode nextNode=prevNode.next;

            node.next=nextNode;
            prevNode.next=node;
            nextNode.prev=node;
            node.prev=prevNode;

        }
        size++;
    }

    public void printDLL()
    {
        if(head==null)
        System.out.println("DLL does not exist");
        doubleNode temp=head;
        // for(int i=0;i<size;i++)
        while(temp!=null)
        {
            System.out.print(temp.value);
            if(temp.next!=null)
                System.out.print("<==>");
             temp=temp.next;
            // if(i!=size-1)
            // System.out.print("<==>");
        }
        System.out.println("\n");
    }

    public void reversePrintDLL()
    {
        doubleNode temp=tail;
        while(temp!=null)
        {
            System.out.print(temp.value);
            if(temp.prev!=null)
            System.out.print("<==>");
            temp=temp.prev;
        }
    }

    public boolean searching(int value)
    {
        doubleNode temp=head;
        for(int i=0;i<size;i++)
        {
            if(temp.value==value)
            {
                System.out.println("The value is found");
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void deletion(int location)
    {
        if(head==null)
        {
            System.out.println("DLL does not exist");
            return;
        }
        else if(location==0)
        {
            head=head.next;                 //deletion at first when there are multiple elements
            head.prev=null;
            if(size==1)
            {
                head=null;                  //deletion at first when there is only element
                tail=null;
            }
        }
        else if(location>=size)
        {
            System.out.println("Out of Bounds");
        }
        else
        {
            doubleNode temp=head;
            for(int i=0;i<location-1;i++)
            {
                temp=temp.next;
            }
            doubleNode prevNode=temp;                       //head <==> prevNode <==> nodeToBeDeleted <==> nextNode <==> tail
            doubleNode nextNode=temp.next.next;
            prevNode.next=prevNode.next.next;
            nextNode.prev=temp;
        }

    }

    public void deleteEntireDLL()
    {
        doubleNode temp=head;
        for(int i=0;i<size;i++)
        {
            temp.prev=null;                                 //deleting the previous reference of each node using this loop 
            temp=temp.next;
        }
        head=null;                                          //setting head and tail references to null ; this means the left out middle contents will be deleted by Garbage Collector 
        tail=null;
        System.out.println("Entire DLL has been deleted");
    }
    
}

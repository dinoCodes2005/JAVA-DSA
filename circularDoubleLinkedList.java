package circularDoubleLinkedList;

public class circularDoubleLinkedList {
    public doubleNode head;
    public doubleNode tail;
    public int size;
    public circularDoubleLinkedList()
    {

        this.head=null;                     //initialisation
        this.tail=null;
        this.size=0;
    }
    public doubleNode createCircularDLL(int value)
    {
        doubleNode node=new doubleNode();           //creation of cDLL
        node.value=value;
        node.next=tail;
        head=node;
        tail=node;
        node.prev=head;
        size++;
        return node;
    }

    public void insertCDLL(int value,int location)
    {
        doubleNode node =new doubleNode();
        node.value=value;
        if(head==null)
        {
            createCircularDLL(value);               //calling above function if the cDLL is empty
            return;
        }
        else if(location==0)
        {
            node.next=head;
            node.prev=tail;
            head.prev=node;
            tail.next=node;
            head=node;                      //we dont write head.next =node instead just write head=node 
        }
        else if(location>=size)
        {
            doubleNode temp=head;
            for(int i=0;i<size;i++)
            {
                temp=temp.next;                 //insertion at the end
            }
            node.next=head;
            node.prev=tail;
            head.prev=node;
            tail=node;
        }
        else
        {
            doubleNode prevNode=head;
            for(int i=0;i<location-1;i++)
            prevNode=prevNode.next;
            doubleNode nextNode = prevNode.next;                //at custom location
            prevNode.next=node;
            nextNode.prev=node;
            node.prev=prevNode;
            node.next=nextNode;

        }
        size++;
    }

    public void printDLL()
    {
        doubleNode temp=head;
        for(int i=0;i<size;i++)
        {
            System.out.print(temp.value);
            if(i!=size-1)
            System.out.print(" <==> ");
            temp=temp.next;
        }
        System.out.println("\n");
    }

    public void reversePrintDLL()
    {
        doubleNode temp=tail;
        for(int i=size-1;i>=0;i--)
        {
            System.out.print(temp.value);
            if(i!=0)
            System.out.print(" <==> ");
            temp=temp.prev;
        }
        System.out.println("\n");
    }

    public boolean Searching(int value)
    {
        if(head==null)
        return false;
        doubleNode temp=head;
        for(int i=0;i<size;i++)
        {
            if(temp.value==value)
            {
                System.out.println("present");
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void Deletion(int location)
    {
        if(head==null)
        System.out.println("List is empty");
        else if(location==0)
        {
            head=head.next;
            head.prev=tail;
            tail.next=head;                 //general case of deletion at the beginning 
            size--;
            if(size==1)
            {
                head=null;                  //when there is only one element
                tail=null;
                size--;
            }
        }
        else if(location>=size)
        System.out.println("Out of Bounds");
        else
        {
            doubleNode prevNode=head;
            for(int i=0;i<location-1;i++)
            {
                prevNode=prevNode.next;         //traversing to the node justt before the one that needs to be deleted
            }
            doubleNode currentNode=prevNode.next;
            doubleNode nextNode =currentNode.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
    }

    public void deleteEntireCDL()
    {
        doubleNode temp=head;
        for(int i=0;i<size;i++)
        {
            temp.prev=null;                 //removes the backward link of nodes
            temp=temp.next;                
        }
        head=null;                          //setting references of head node to null
        tail=null;                          //setting references of tail node to null
        //rest gets deleted by Garbage Collector 
        System.out.println("Deleted successfully");
    }
}

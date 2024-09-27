package singleCircularList;

public class SinglyCircularLinkedList
{
    public Node head;
    public Node tail;
    public int size;
    public Node createCircularLinkedList(int nodeValue)
    {
        Node node =new Node();              //adding first element in the list and connecting head and tail
        node.value=nodeValue;
        node.next=node;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void insertCSL(int value,int location)
    {
        Node node =new Node();
        node.value=value;
        if(head==null)
        createCircularLinkedList(value);        //calling the above method
        else if(location==0)
        {
            node.next=head;                     //inserting at the beginning
            head=node;
            tail.next=node;
        }
        else if(location>=size)
        {
            node.next=head;                     //inserting at the last
            tail.next=node;
            tail=node;
        }
        else
        {
            Node temp=head;
            for(int i=0;i<location;i++)         //inserting at custom location
            {
                temp=temp.next;
            }
            Node nextNode=temp.next;
            temp.next=node;
            node.next=nextNode;
        }
        size++;
    }

    public void printList()
    {
        if(head==null)
        System.out.println("CLL does not exist");
        else{
            Node temp=head;
            for(int i=0;i<size;i++)
            {
                System.out.print(temp.value);
                if(i!=size-1)
                System.out.print("-->");
                temp=temp.next;
            }
            System.out.println("\n");
        }
    }



    public void deletion(int location)
    {
        if(head==null)
        System.out.println("CSL does not exist");
        else if(location==0)
        {
            head=head.next;
            tail.next=head;
            size--;                             //deletion from start 
            if(size==0)
            {
                tail=null;                      
                head.next=null;                 //checking if it was the only element present in the list ; if so referring head and tail to null
                head=null;
            }
        }
        else if(location>=size)
        {
            Node temp=head;
            for(int i=0;i<size;i++)
            {
                temp=temp.next;                 
            }
            if(temp.next==head)
            {
                head.next=null;
                size=0;                         //deletion at the end if there was only one element in the list
                head=null;
            }
            temp.next=head;
            tail=temp;                          //deletion at the end if there was multiple elements
            size--;
        }
        else
        {
            Node temp=head;
            for(int i=0;i<location-1;i++)
            {
                temp=temp.next;                 //deletion at custom location
            }
            temp.next=temp.next.next;
            size--;
        }

    }

    public void deleteEntireCSL()
    {
        if(head==null)
        {
            System.out.println("CSL does not exist");
            return;
        }
        else{
            head=null;
            tail.next=null;
            tail=null;
            System.out.println("Deleted Successfully");
        }
    }

    
}
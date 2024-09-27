
public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int value)
    {
        Node node =new Node();
        node.value=value;
        node.next=tail;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public void insertSinglyLinkedList(int value, int location)
    {
        Node node=new Node();
        node.value=value;
        if(head==null)
        createSinglyLinkedList(value);
        else if(location==0){
            node.next=head;
            head=node;
        }
        else if(location>=size)
        {
            node.next=tail;
            tail.next=node;
            tail=node;
        }
        else
        {
            Node temp =head;
            for(int i=0;i<location-1;i++)
            {
                temp=temp.next;
            }
            Node nextNode = temp.next;
            temp.next=node;
            node.next=nextNode;
        }
    }

    public void deletion(int location)
    {
        if(head==null)
        System.out.println("List is Empty");
        else if(location==0)
        {
            head=head.next;
            size--;
            if(size==0)
            tail=null;
        }
        else if(location>=size)
        System.err.println("Beyond the size ");
        else{
            Node temp=head;
            for(int i=0;i<location-1;i++)
            {
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
            if(temp.next==null)
            tail=temp;
        }
    }
}

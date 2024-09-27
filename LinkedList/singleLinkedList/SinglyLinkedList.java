package singleLinkedList;

public class SinglyLinkedList {
    // contains head and tail references
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue)
    {
        Node node =new Node();
        node.next =null;
        node.value =nodeValue;
        head =node;
        tail =node;
        size =1;
        return head;
    }

    public void insertLinkedList(int nodeValue ,int location)
    {
        Node node = new Node();
        node.value =nodeValue;
        if(head==null)
        {
            createSinglyLinkedList(nodeValue);
        }

        else if(location==0)
        {
            node.next = head;   //inserting at the beginning
            head=node;
        }

        else if(location>=size)
        {
            node.next=null;     //inserting at the last
            tail.next=node;
            tail=node;
        }

        else
        {
            Node tempNode = head;       //inserting in the middle
            int i=0;
            while(i<location-1)
            {
                tempNode=tempNode.next;
                i++;
            }

            Node nextNode=tempNode.next;        //temp is the left one , node is the middle one and nextNode is right one 
            tempNode.next =node;                // temp --> node --> nextNode
            node.next = nextNode;
        }
        size++;
    }
    
    public void Traversal(){
        if(head==null)
        System.out.println("SLL does not exist");
        else{
            Node temp = head;
            while(temp!=null)
            {
                System.out.print(temp.value);
                if(temp.next!=null)
                System.out.print("-->");
                temp=temp.next;
            }
        }
        System.out.println("\n");
    }

    public boolean Searching(int value)
    {
        if(head!=null)
        {
            Node temp1=head;
            for(int i=0;i<size;i++)
            {
                if(temp1.value==value)
                {
                    System.out.println("The value is present at "+i);
                    return true;
                }
                temp1=temp1.next;
            }
        }
        return false;
        
    }

    public void Deletion(int location)
    {
        if(head==null)
        {
            System.out.println("List is Empty");        //when the list is empty
        }

        else if(location==0)
        {
            head=head.next;
            size--;                                 //when the deletion is taking place at first
            if(size==0)                             //when the deletion is taking place at first but list had only one element so we connect tail to it 
            tail=null;
        }

        else if(location>=size)
        {
            System.out.println("Beyond the size of LL");       //exceeds the size of the LL
        }

        else{
            Node tempNode=head;
            for (int i = 0; i < location-1; i++) {
                tempNode=tempNode.next;                         //deletion at a certain position
            }
            tempNode.next = tempNode.next.next;
            size--;

            if(tempNode.next==null)
            tail=tempNode;
        }

    }

    public String rotate(int number) {
        int index = number;
        if (index < 0 || index >= size) {           //since the value is out of range of the LL
          return null;
        }
        if (index == 0) {
          return "No Rotation";                     //value is set at the first so there will be no change
        }
        Node prevNode = head;
        for(int i=0; i<index-1; i++) {              
          prevNode = prevNode.next;                 //pointing to the given index
        }
        if (prevNode == null) {
            return "No Rotation";                   //pointing to the end ; so no change
          }
          //before the change = head-->prevNode-->tail

        tail.next = head;                           
        head = prevNode.next;                       
        tail = prevNode;                            
        prevNode.next = null;
        return "Success";
      }

    public void deleteEntireSLL()
    {
        head=null;
        tail=null;
        System.out.println("Entire SLL deleted successfully");
    }
}

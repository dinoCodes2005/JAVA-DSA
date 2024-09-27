package singleLinkedList;
import java.lang.classfile.components.ClassPrinter;
import java.util.HashSet;
import java.util.regex.MatchResult;
public class Questions 
{
    // TODO
    void deleteDups(SinglyLinkedList ll)              //takes the object linkedList as parameter
    {             
        HashSet<Integer> hs=new HashSet();      //creating hashSet -- because it does not store duplicate elements
        Node current =ll.head;
        Node prev=null;                         //previous to null
        while(current!=null)
        {
            int curval=current.value;
            if(hs.contains(curval))             //checking if the element is stored in hashSet
            {
                prev.next=current.next;         //Ye baad me hoga -if yes ; then point the previous node to next node of the duplicate one to get it removed by the Garbage Collector
                ll.size--;
            }
            else{
                hs.add(curval);                 //Ye pehle hoga -if no then put the value to hashSet as a marker that yes it has been checked before
                prev=current;                   //moving the checking process to one step forward
            }
            current = current.next;
        }
    }

    public int nthToLast(SinglyLinkedList ll, int location)
    {
        Node prev=ll.head;
        Node current=prev.next;
        int firstLocation = ll.size-location;               //if a element is at nth from last then it is at size-nth from first : first = size - nth 
        for(int i=0;i<firstLocation-1;i++){                 //traversing to previous node from the beginning
            prev =prev.next;
        }
        Node toBeReturned = prev;
        prev.next=current.next;
        ll.size--;
        return toBeReturned.value;
        
    }
    public SinglyLinkedList partition(SinglyLinkedList ll, int x) {
    // TODO
    Node currentNode =ll.head;
    ll.tail=ll.head;
    while(currentNode !=null)
    {
        Node next =currentNode.next;
        if(currentNode.value<x)
        {
            currentNode.next=ll.head;           //when value less than x is found it shift the currentNode to the beginning
            ll.head=currentNode;
        }
        else
        {
            ll.tail.next=currentNode;           //otherwise push the value to the end and connect it to tail
            ll.tail=currentNode;
        }
        currentNode=next;
    }
    ll.tail.next=null;                          //setting tail next reference to null
    return ll;
  }
  
  public SinglyLinkedList sumList(SinglyLinkedList list1 ,SinglyLinkedList list2)
  {
    Node n1=list1.head;     //head of the first list
    Node n2=list2.head;     //head of the second list
    int carry=0;
    SinglyLinkedList resultLL = new SinglyLinkedList();     //creating object of sLL named resultLL to store the result of the summed up list
    while(n1!=null || n2!=null)       //run until the end
    {
        int result=carry;                 //stores the carry after every loop exec.
        if(n1 !=null)                     
        {
            result+=n1.value;            //this basically adds the first digit of both the lists; the value gets reset after every loop storing the carry which compels to add the carry at the second loop
            n1=n1.next;
        }
        if(n2 !=null)
        {
            result+=n2.value;            //same as the above ; this is the digit addition of the second linked list
            n2=n2.next;
        }
        resultLL.insertLinkedList(result%10, 0);            //after every addition of the digits , second digit is moved to the first 
        carry=result/10;                                            //while the first digit is stored in the carry and passed onto the result in the second loop 
    }
    return resultLL;

  }

  public Node getKthNode(Node head,int k)               //here head is basically the head of longer list and k is the size difference which will help us to find the number of elements that can be ignored to traverse simultaneously
  {
    Node current =head;
    while(k>0 && current!=null)
    {
        current=current.next;
        k--;
    }
    return current;
  }

  public Node findIntersection(LinkedList lA,LinkedList lB)
  {
    if(lA.head==null || lB.head==null)              //if the list is empty : no intersection point 
    return null;
    if(lA.tail!=lB.tail)                            //if the tail of listA and listB does not point to same then it will return null
    return null;
    Node shorter =new Node();                       //node pointer for short list
    Node longer = new Node();                       //node pointer for longer list
    if(lA.size>lB.size)
    {
        longer=lA.head;
        shorter=lB.head;
    }
    else{
        longer=lB.head;
        shorter=lA.head;
    }
    longer =getKthNode(longer, Math.abs(lA.size-lB.size));              //math.abs is used to find the number of elements in the longer list that can be ignored
    while(shorter!=longer)
    {
        shorter=shorter.next;                       //it will keep pointing to next node of shorter and longer until the intersection point is found 
        longer=longer.next;
    }
    return longer;                                  //this will give the intersection point of the linkedList
  }
}



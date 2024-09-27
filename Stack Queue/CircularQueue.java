


public class CircularQueue {
    int arr[];
    int rear;
    int front;
    int size;

    public CircularQueue(int size)
    {
        this.arr=new int[size];
        this.size=size;
        this.rear=-1;
        this.front=-1;
        System.out.println("Circular Queue is successfully created with size of "+size);
    }

    public boolean isEmpty()
    {
        if(rear==-1)                          //when last element is empty ; topOfQueue will be equal to -1
        return true;
        else
        return false;
    }

    public boolean isFull()
    {
        if(rear+1==front)          //circular Queue is formed since the last element gets connected to first
        return true;
        else if(front==0&&rear+1==size)                //when the Circular Queue starts from index =0 and ends at the size-1
        return true;
        else
        return false;
    }

    public void enQueue(int value)
    {
        if(isFull())
        System.out.println("The CQ is full");
        else if(isEmpty())
        {
            front=0;
            rear++;
            arr[rear]=value;
            System.out.println("Successfully inserted "+value);
        }
        else{
            if(rear+1==size)                        //when the rear end is at the size-1 position but the first elements are empty
                rear=0;                             //in this case the element is inserted at first 
            else
                rear++;                             //otherwise insert at the general position that is the rear end
            arr[rear]=value;
            System.out.println("Successfully inserted "+value);
        }
    }

    public int deQueue()
    {
        if(isEmpty())
        {
        System.out.println("The CQ is empty");
        return -1;
        }
        else{
            int result=arr[front];
            arr[front]=0;                   //storing the front element
            if(front==rear)                 //only one element in queue and front is at the start of the array
            {
                front=-1;
                rear=-1;
            }
            else if(front+1==size){         //only one element in array but front is at the last
                front=0;
            }
            else
            {
                front++;                    //normal condition
            }
            return result;
        }
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("The circular Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public void deleteQueue()
    {
        arr=null;
        System.out.println("Circular Queue has been deleted Successfully");
    }
}

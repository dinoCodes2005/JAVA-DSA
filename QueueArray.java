

public class QueueArray {
    int arr[];
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size)
    {
        this.arr=new int[size];
        this.topOfQueue=-1;
        this.beginningOfQueue=-1;
        System.out.println("The Queue is successfully created with size: "+size);

    }

    public boolean isFull()
    {
        if(topOfQueue==arr.length-1)
        return true;
        else
        return false;
    }

    public boolean isEmpty()
    {
        if(beginningOfQueue==-1||beginningOfQueue==arr.length)          //the second condition is for circular queue
        return true;
        else 
        return false;
    }

    public void enQueue(int value)
    {
        if(isFull())
        System.out.println("The Queue is Full");
        else if(isEmpty())
        {
            beginningOfQueue=0;         //from -1 to 0
            topOfQueue++;                       //-1 to 0
            arr[topOfQueue]=value;              //setting the value from rear end
            System.out.println(value+" Value has been inserted");
        }
        else{
            topOfQueue++;               //in case of !Empty case the value will be added to the rear end just like before but this time we wont interfere with beginning
            arr[topOfQueue]=value;
            System.out.println(value+" Value has been inserted");
        }
    }

    public int deQueue()
    {
        if(isEmpty())
        {
            System.out.println("The Queue is Empty");
            return -1;
        }
        else
        {
            int result=arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue>topOfQueue)         //this means that beginning of Queue has crossed the rear which means that now it is an empty queue
            {
                beginningOfQueue=-1;
                topOfQueue=-1;
            }
            return result;
        }
    }

    public int peek()
    {
        if(!isEmpty())
        {
            return arr[beginningOfQueue];
        }
        else{
            System.out.println("The Queue is Empty");
            return -1;
        }
    }

    public void deleteQueue()
    {
        arr=null;
        System.out.println("The Queue has been deleted");
    }
}
public class Stack 
{
    int arr[];
    int top;
    public Stack(int size)                      //stack constructor will take its size as the input
    {
        this.arr=new int[size];
        this.top=-1;                            //-1 is the garbage value for the condition if top is empty 
        System.out.println("The size of the Stack is "+size);
    }
    public boolean isEmpty()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty");
            return true;
        }
        else
        return false;
    }

    public boolean isFull()
    {
        if(top==arr.length-1)
        {
            System.out.println("Stack is full");
            return true;
        }
        else{
            System.out.println("Stack is not full");
            return false;
        }
    }

    public void push(int value)
    {
        if(isFull())
            System.out.println("Stack is full");
        else{
            arr[top+1]=value;
            top++;
            System.out.println("Successfully inserted");
        }
    }

    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("The stack is empty");
            return -1;
        }
        else{
            int topStack=arr[top];
            top--;
            return topStack;
        }
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("The stack is empty");
            return -1;
        }
        else{
            return arr[top];
        }
    }

    public void deleteStack()
    {
        arr=null;
        System.out.println("The stack is successfully deleted");
    }
}
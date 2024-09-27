package Heap;

public class BinaryHeap {
    int arr[];
    int sizeOfTree;

    public BinaryHeap(int size)
    {
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Heap created");
    }

    public boolean isEmpty()
    {
        if(sizeOfTree==0)
        return true;
        return false;
    }

    public Integer peek()
    {
        if(isEmpty())
        {
            System.out.println("Heap is empty");
            return null;
        }
        return arr[1];
    }

    public int sizeOfBP()
    {
        return sizeOfTree;
    }

    public void levelOrder()
    {
        for(int i=1;i<=sizeOfTree;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void heapifyBottomToTop(int index,String heapType)
    {
        int parent = index/2;
        if(index<=1)
        {
            return;
        }
        //swapping the arr[index] & parent if it is less than parent
        if(heapType=="min")
        {
            if(arr[index]<arr[parent])
            {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        else if(heapType == "max")
        {
        //swapping the arr[index] & parent if it is greater than the parent
            if(arr[index]>arr[parent])
            {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value,String typeHeap)
    {
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeHeap);
        System.out.println("Value has been inserted");
    }

    public void heapifyTopToBottom(int index,String typeHeap)
    {
        int left = 2*index;
        int right = left+1;
        int swapChild =0;
        if(sizeOfTree<left)
        return;

        if(typeHeap=="max")
        {
            if(sizeOfTree==left)
            {
                if(arr[index]<arr[left])
                {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else {
                if(arr[left]>arr[right])
                {
                    swapChild = left;
                    if(arr[left]>arr[right])
                    {
                        swapChild = left;
                    }
                    else
                    {
                        swapChild = right;
                    }
                    if(arr[index]<arr[swapChild])
                    {
                        int temp = arr[index];
                        arr[index] = arr[swapChild];
                        arr[swapChild] = temp;
                    }
                }
            }
        }
        else if(typeHeap=="min")
        {
            if(sizeOfTree==left)
            {
                if(arr[index]>arr[left])
                {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else {
                if(arr[left]<arr[right])
                {
                    swapChild = left;
                    if(arr[left]>arr[right])
                    {
                        swapChild = left;
                    }
                    else
                    {
                        swapChild = right;
                    }
                    if(arr[index]>arr[swapChild])
                    {
                        int temp = arr[index];
                        arr[index] = arr[swapChild];
                        arr[swapChild] = temp;
                    }
                }
            }
        }
        heapifyTopToBottom(swapChild, typeHeap);
    }

    public int extractHeadOfBP(String heapType)
    {
        if(isEmpty())
        return -1;
        else
        {
            int extractValue = arr[i];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractValue;
        }
    }
}

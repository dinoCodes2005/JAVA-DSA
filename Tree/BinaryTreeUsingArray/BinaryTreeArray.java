package BinaryTreeUsingArray;

public class BinaryTreeArray {
    String arr[];
    int lastUsedIndex;

    public BinaryTreeArray(int size){
        arr = new String[size+1];
        this.lastUsedIndex=0;
        System.out.println("Binary Tree has been created with a size of "+size);
    }

    boolean isFull()
    {
        if(arr.length-1==lastUsedIndex)
            return true;
        return false;
    }

    void insert(String value)
    {
        if(!isFull())
        {
            arr[lastUsedIndex+1]=value;
            lastUsedIndex++;
            System.out.println("The value of "+value+"has been inserted");
        }
        else{
            System.out.println("Binary Tree is full");
        }
    }

    public void preOrder(int index)
    {
        if(index>lastUsedIndex)
        {
            return;
        }
        System.out.print(arr[index]+" ");
        preOrder(2*index);
        preOrder(2*index +1);
    }

    public void inOrder(int index)
    {
        if(index>lastUsedIndex)
        {
            return;
        }
        inOrder(2*index);
        System.out.print(arr[index]+" ");
        inOrder(2*index +1);
    }

    public void postOrder(int index)
    {
        if(index>lastUsedIndex)
        return;
        postOrder(2*index);
        postOrder(2*index+1);
        System.out.print(arr[index]+" ");
    }

    public void levelOrder()
    {
        for(int i=1;i<=lastUsedIndex;i++)
        System.out.print(arr[i]+" ");
    }

    public int search(String value)
    {
        for(int i=1;i<=lastUsedIndex;i++)      
        {
            if(arr[i]==value)
            {
                System.out.println("The value exists at this location "+i);
                return i;
            }
        }
        System.out.println("The value does not exist");
        return -1;
    }

    public void delete(String value)
    {
        int location = search(value);
        if(location==-1)
            return;
        else
        {
            arr[location]=arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The node successfully deleted");
        }
    }

    public void deleteBinaryTree()
    {
        try {
            arr=null;
            System.out.println("The binary tree has been deleted");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree");
        }
    }

}

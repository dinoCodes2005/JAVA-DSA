package AVLTreeProgram;

import java.util.LinkedList;
import java.util.Queue;
import javax.lang.model.util.ElementScanner14;

public class AVL {
    BinaryNode root;
    public AVL()
    {
        root=null;
    }

    BinaryNode search(BinaryNode node ,int value)
    {
        if(node==null)
        {
            System.out.println("Value not found");
            return null;
        }
        else if(node.value==value)  
        {
            System.out.println("Value found in BST");
            return node;
        }
        else if(value<node.value)
        return search(node.left,value);
        else
        return search(node.right,value);
    }


    void levelOrder()
    {
        if(root==null)
        {
            System.out.println("The tree is empty");
            return ;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left!=null)
                queue.add(presentNode.left);
            if(presentNode.right!=null)
                queue.add(presentNode.right);
        }
    }

    public int getHeight(BinaryNode node)
    {
        if(node==null)
        return 0;
        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalanced)
    {
        BinaryNode newRoot = disbalanced.left;
        disbalanced.left = disbalanced.left.right;
        newRoot.right = disbalanced;
        disbalanced.height = 1+Math.max(getHeight(disbalanced.left),getHeight(disbalanced.right));
        newRoot.height = 1+Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNode rotateLeft(BinaryNode disbalanced)
    {
        BinaryNode newRoot = disbalanced.right;
        disbalanced.right = disbalanced.right.left;
        newRoot.left = disbalanced;
        disbalanced.height = 1+Math.max(getHeight(disbalanced.left),getHeight(disbalanced.right));
        newRoot.height = 1+Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }

    public int getBalance(BinaryNode node)
    {
        if(node==null)
        return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insertNode(BinaryNode node,int nodeValue)
    {
        if(node==null)
        {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        }
        else if(nodeValue<node.value)
        {
            node.left = insertNode(node.left, nodeValue);
        }
        else{
            node.right = insertNode(node.right, nodeValue);
        }
        
        node.height = 1+Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);

        //LL condition
        if(balance>1 && nodeValue<node.left.value)
        {
            return rotateRight(node);
        }

        //LR condition
        if(balance>1 && nodeValue>node.left.value)
        {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        //RR condition
        if(balance <-1 && nodeValue>node.right.value)
        {
            return rotateLeft(node);
        }

        //RL condition
        if(balance <-1 && nodeValue<node.right.value)
        {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value)
    {
        root = insertNode(root,value);
    }

    //for deletion similar to BST
    public static BinaryNode minimumNode(BinaryNode root)
    {
        if(root.left==null)
        return root;
        return minimumNode(root.left);
    }

    public BinaryNode deleteBinaryNode(BinaryNode node,int value)
    {
        if(node==null)
        {
            System.out.println("Value not found in AVL");
            return node;
        }

        //move to left until you find the value
        if(value<node.value)
        node.left = deleteBinaryNode(node.left,value);
        else if(value>node.value)
        node.right = deleteBinaryNode(node.right,value);
        //move to right until you find the value 

        //when the value is found
        else{

            //not a leaf node -- it has two children
            if(node.left!=null && node.right!=null)
            {
                //use the BST node deletion technique
                BinaryNode temp =node;
                BinaryNode minNodeforRight = minimumNode(temp.right);
                node.value = minNodeforRight.value;
                node.right = deleteBinaryNode(node.right, minNodeforRight.value);
            }
            else if(node.left!=null)
            node = node.left;       //when the left child is not null
            else if(node.right!=null)
            node = node.right;      //when the right child is not null
            else            
            node=null;              //when the node is leaf 
        }

        int balance = getBalance(node);

        //LL condition
        if(balance >1 && getBalance(node.left)>=0)
        return rotateRight(node);


        //LR condition
        if(balance>1 && getBalance(node.left)<0)
        {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        //RR condition
        if(balance<-1 && getBalance(node.right)<=0)
        return rotateLeft(node);

        //RL condition
        if(balance<-1 && getBalance(node.right)>0)
        {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;

    }

    public void deleteNode(int value)
    {
        root = deleteBinaryNode(root,value);
    }

}

package BinarySearchTree;

import java.util.*;

public class BST {
    BinaryNode root;
    public BST()
    {
        root=null;
    }

    private BinaryNode insert(BinaryNode current, int value)
    {
        if(current==null)                   //when BST is null
        {
            BinaryNode node = new BinaryNode();
            node.value=value;
            System.out.println("The value has been inserted");
            return node;
        }

        else if(value<=current.value)               //if the value is less than the value of the current node then recursively call the insert()
            {
                current.left=insert(current.left,value);
                return current;
            }
        
        else
        {
            current.right=insert(current.right,value);
            return current;
        }
    }

    void insert(int value)
    {
        root= insert(root,value);
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

    public static BinaryNode minimumNode(BinaryNode root)
    {
        if(root.left==null)
        return root;
        else
        {
            return minimumNode(root.left);
        }
    }

    public BinaryNode deleteNode(BinaryNode root,int value)
    {
        if(root==null)
        {
            System.out.println("value not found");              //if the bst is empty
            return null;
        }

        if(value<root.value)                                    //if the value is less than root value then recursively move to the left
        root.left=deleteNode(root.left, value);
        else if(value>root.value)                               //otherwise to the right
        root.right=deleteNode(root.right, value);
        else
        {
            if(root.left!=null && root.right!=null)             //if we are at the value 
            {
                BinaryNode temp =root;                          //root is now the value so store it in a temp var
                BinaryNode minNodeForRight = minimumNode(temp.right);           //finding the minimum node to the right of the current
                root.value=minNodeForRight.value;
                root.right=deleteNode(root.right, minNodeForRight.value);
            }
            else if(root.left!=null)                        //normal traversal
            root=root.left;
            else if(root.right!=null)
            root=root.right;
            else
            root=null;
        }
        return root;
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


}

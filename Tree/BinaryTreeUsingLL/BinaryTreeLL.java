package BinaryTreeUsingLL;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    BinaryNode root;
    public BinaryTreeLL()
    {
        this.root=null;
    }

    void preOrder(BinaryNode node)
    {
        if(node==null)
        return;
        System.out.print(node.value+" ");           //printing the root first because of the preOrder Traversal
        preOrder(node.left);                        //recursively calling the left children since we are doing preOrder Traversal (Root , Left , Right)
        preOrder(node.right);
    }

    void inOrder(BinaryNode node)
    {
        if(node==null)
        return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    void postOrder(BinaryNode node)
    {
        if(node==null)
        return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

    void levelOrder()
    {
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

    public void search(String value)
    {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode = queue.remove();
            if(presentNode.value ==value){
                System.out.println("The value is found in Tree");
                return;
            }
            if(presentNode.left!=null)
            {
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null)
            {
                queue.add(presentNode.right);
            }
        }

        System.out.println("The value is not found");
    }

    void insert(String value)
    {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root==null)
        {
            root=newNode;
            System.out.println("Inserted new node at root");
            return ;
        }
        
        Queue<BinaryNode> queue =new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryNode presentNode = queue.remove();
            if(presentNode.left==null)
            {
                presentNode.left=newNode;
                System.out.println("Inserted new node at left children");
                break;
            }
            else if(presentNode.right==null)
            {
                presentNode.right=newNode;
                System.out.println("Inserted new node at right children");
                break;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public BinaryNode getDeepestNode()
    {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode =null;
        while(!queue.isEmpty())
        {
            presentNode = queue.remove();
            if(presentNode.left!=null)
            queue.add(presentNode.left);
            if(presentNode.right!=null)
            queue.add(presentNode.right);
        }
        return presentNode;
    }

    public void deleteDeepestNode()
    {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode,deepestNode=null;
        while(!queue.isEmpty())
        {
            presentNode = queue.remove();
            if(presentNode.left!=null)
            {
                queue.add(presentNode.left);
                deepestNode=presentNode.left;
            }

            if(presentNode.right!=null)
            {
                queue.add(presentNode.right);
                deepestNode=presentNode.right;
            }

            //deepestNode points to the deepest Node
            //queue is empty now
        }
        
        //reinitialising the queue
        queue.add(root);
        BinaryNode parentNode = null;

        while(!queue.isEmpty())
        {
            parentNode = queue.remove();
            if(parentNode.left!=null)               //if the parentNode has something then check whether it has deepestNode as its children : if yes then at that side point to null
            {
                if(parentNode.left == deepestNode)
                {
                    parentNode.left=null;
                    return;
                }
                else
                    queue.add(parentNode.left);     //normal traversal towards the deepest Node if the above conditon failed
            }

            if(parentNode.right!=null)
            {
                if(parentNode.right==deepestNode)
                {
                    parentNode.right=null;
                    return;
                }
                else
                    queue.add(parentNode.right);
            }
        }
    }

    void deleteNode(String value)
    {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            BinaryNode presentNode = queue.remove();
            if(presentNode.value==value)            //using levelOrder traversal to search the given value
            {
                presentNode.value=getDeepestNode().value;           //if the present value is present at the deepestNode then delete it using the above function
                deleteDeepestNode();
                System.out.println("The node is deleted");
                return;
            }
            else{
                if(presentNode.left!=null)          //normal traversal logic
                queue.add(presentNode.left);
                if(presentNode.right!=null)
                queue.add(presentNode.right);
            }
        }
        System.out.println("The node does not exitst in this Binary tree");
    }

    void deleteBinaryTree()
    {
        root=null;
        System.out.println("Binary Tree has been deleted successfully");
    }
}

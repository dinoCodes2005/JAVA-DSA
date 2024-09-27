package BinaryTreeUsingLL;

import java.util.*;

import Node;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


public class Left {

    // Function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    public void helper(Node curr , List<Integer> list , int depth)
    {
        if(curr==null)
        return;

        if(list.size()==depth)
        list.add(curr.data);

        helper(curr.left,list,depth+1);
        helper(curr.right,list,depth+1);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        Left solution = new Left();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Top View Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}

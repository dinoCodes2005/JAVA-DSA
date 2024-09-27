

import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class sumTree {

    // Function to return the sum of all root-to-leaf paths in the binary tree
    public int sumOfPaths(Node root) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        dfs(root, sb, list);
        int sum = 0;

        // Sum the values of the root-to-leaf paths
        for (StringBuilder s : list) {
            sum += Integer.parseInt(s.toString());
        }

        return sum;
    }

    public void dfs(Node root, StringBuilder sb, List<StringBuilder> result) {
        if (root == null)
            return;

        // Append the current node value to the path
        sb.append(root.val);

        // If it's a leaf node, add a copy of the current path to the result list
        if (root.left == null && root.right == null) {
            result.add(new StringBuilder(sb));
        }

        // Recursively visit the left and right children
        dfs(root.left, sb, result);
        dfs(root.right, sb, result);

        // Backtrack: remove the last character (node) from the current path
        sb.deleteCharAt(sb.length() - 1);
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

        sumTree solution = new sumTree();

        // Get the sum of all root-to-leaf paths
        System.out.println(solution.sumOfPaths(root));  // Outputs the sum of all root-to-leaf paths
    }
}

package BinaryTreeUsingLL;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Custom Pair class
class Pair<K, V> {a
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class RightView {

    // Function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> temp = queue.poll();
            Node node = temp.getKey();
            int line = temp.getValue();
            
            //change this line 
            map.put(line, node.data);

            if (node.left != null)
                queue.add(new Pair<>(node.left, line - 1));

            if (node.right != null)
                queue.add(new Pair<>(node.right, line + 1));
        }

        for (int value : map.values())
            list.add(value);

        return list;
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

        RightView solution = new RightView();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Top View Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}

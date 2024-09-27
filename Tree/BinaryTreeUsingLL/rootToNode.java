package BinaryTreeUsingLL;

import Node;

public class rootToNode {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPaths(root, new ArrayList<>(), result);
        return result;
    }

    // Helper method to find paths from root to leaf nodes
    private static void findPaths(Node node, List<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        
        // Add the current node to the path
        path.add(node.data);

        // If it's a leaf node, add the path to the result
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            // Otherwise, go deeper into the tree
            findPaths(node.left, path, result);
            findPaths(node.right, path, result);
        }

        // Backtrack: remove the current node from path
        path.remove(path.size() - 1);
    }
}

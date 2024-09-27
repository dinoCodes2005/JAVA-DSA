import java.util.Stack;

public class preOrderUsingStack {
    public void preOrderTraversal(TreeNode root) {
        // TODO
        if(root==null)
        return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
           TreeNode current = stack.pop();
           System.out.print(current.value+" ");
           if(current.right!=null)
              stack.push(current.right);
           if(current.left!=null)
                stack.push(current.left);
        }
    }
}

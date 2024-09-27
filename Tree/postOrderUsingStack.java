import java.util.Stack;

public class postOrderUsingStack {
    public void postOrderTraversal(TreeNode root) {
        //  TODO
        Stack<TreeNode> stack1 = new Stack<>();         //this stack stores the left and right children and transfers it to the stack2 where the correct arrangement is done
        Stack<TreeNode> stack2 = new Stack<>();         //stack storing the values in correct order
        
        if(root!=null)
        stack1.push(root);
        
        while(!stack1.isEmpty())
        {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null)
            stack1.push(node.left);
            if(node.right!=null)
            stack1.push(node.right);
        }
        
        while(!stack2.isEmpty())
        {
            TreeNode node = stack2.pop();
            System.out.print(node.value+" ");
        }
        
     }
}

import java.util.Stack;

public class inOrderUsingStack {
    public void inOrderTraversal(TreeNode root) {
        // TODO
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(current!=null || !stack.isEmpty()){
            while(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();                //iteratively stores the left nodes
            System.out.print(current.val+" ");  //root nodes
            current=current.right;              //right nodes
        }
        
    }
}

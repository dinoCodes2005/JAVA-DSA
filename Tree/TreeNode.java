import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data)
    {
        this.data =data;
        this.children= new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode node)
    {
        this.children.add(node);
    }

    public String print(int level)
    {
        String ret;
        ret=" ".repeat(level)+data+"\n";            //for side by side spacing 
        // ret=" ".repeat(level)+data+"\n";
        for(TreeNode node:this.children)            //run for the all the tree nodes until it has no children
            ret+=node.print(level+1);               //Drinks - Hot - Tea - Hot - Coffee - Hot - Drinks - Cold - Cappuccino - Cold - ColdCoffee - Cold - Drinks : Traversal Logic
            
        //"Drinks\n Hot\n  Tea\n  Coffee\n Cold\n  Cappuccino\n  Cold Coffee\n"
        return ret;
    }
}

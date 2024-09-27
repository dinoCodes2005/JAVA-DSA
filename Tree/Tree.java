public class Tree {
    public static void main(String[] args) throws Exception {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode capuccino =new TreeNode("Cappuccino");
        TreeNode coldCoffee = new TreeNode("Cold Coffee");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        cold.addChild(capuccino);
        hot.addChild(coffee);
        cold.addChild(coldCoffee);
        System.out.println(drinks.print(0));
    }
}

public class MainMethod {
    public static void main(String[] args) {
        StackUsingLL newStackUsingLL=new StackUsingLL();
        System.out.println(newStackUsingLL.isEmpty());
        newStackUsingLL.push(1);
        newStackUsingLL.push(2);
        newStackUsingLL.push(3);
        System.out.println(newStackUsingLL.pop());
        System.out.println(newStackUsingLL.peek());
        newStackUsingLL.push(4);
        newStackUsingLL.deleteStack();

        System.out.println(newStackUsingLL.isEmpty());
    }
}

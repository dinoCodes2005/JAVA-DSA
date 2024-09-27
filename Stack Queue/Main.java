public class Main {
    public static void main(String[] args) {
        Stack newStack=new Stack(4);               //creating an object of Stack called "newStack" to call the isEmpty function and others
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        System.out.println(newStack.peek());                    //it returns the element on top of the stack
        System.out.println(newStack.pop());                     // 5 is not returned since it is out of size and hence it is not stored
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());

        System.out.println(newStack.isEmpty());


        System.out.println(newStack.isFull());
        
    }
}

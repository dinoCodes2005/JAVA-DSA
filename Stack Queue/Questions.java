import java.util.Stack;
public class Questions {
    public boolean isBalanced(String expression)
    {
        Stack<Character> stack = new Stack<>();                 //using inbuilt stack of character type
        for(int i=0;i<expression.length();i++)                  //traversing through the string expression
        {
            char c=expression.charAt(i);
            if(c=='('||c=='{'||c=='[')                          //checking if the character consist of opening bracket ; if yes then push into a stack
            stack.push(c);
            else if(c==')'||c=='}'||c==']')                     //if no then checking whether the character is a closing bracket
            {
                if(stack.isEmpty())                             //if yes then checking whether the stack is empty; in that case it means there was no opening bracket before and hence unbalanced
                return false;
                char top=stack.pop();                           //now the c control has moved to the starting of closing bracket and top of the stack consists of the last opening bracket
                if((c==')' && top!='(')||(c=='}' && top!='{')||(c==']' && top!='['))                    //top = first open bracket in stack ; c = first closing bracket in the loop; if does not satisfy , it is unbalanced
                return false;
            }
        }
        return stack.isEmpty();                                 //above condition sets the case in such a way that the stack will be empty if the parenthesis are balanced 
    }

    public static void main(String[] args) {
        Questions obj =new Questions();
        System.out.println(obj.isBalanced("[({})]"));
        System.out.println(obj.isBalanced("[({)]"));

    }

}

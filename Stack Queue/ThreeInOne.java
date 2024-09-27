public class ThreeInOne {
        private int numberOfStacks = 3;               //[1,2,3 || 4,5,6 || 7,8,9]
        private int stackCapacity;                    //capacity of each stack = input from user            
        private int[] values;                         //stores the value of stack in array  = stackCapacity*numberOfStacks 
        private int[] sizes;                          //stores the capacity of each stack in array                   
      
        public ThreeInOne(int stackSize) {
          // TODO
          stackCapacity=stackSize;                    
          values=new int[stackCapacity*numberOfStacks];     
          sizes =new int[numberOfStacks];             //[3,3,3]
        }
      
        // isFull
        public boolean isFull(int stackNum) {
          // TODO
          if(sizes[stackNum]==stackCapacity)          //stackNum is the stack number given by user to locate the partition of the stack
          return true;
          else
          return false;
        }
      
        // isEmpty
        public boolean isEmpty(int stackNum) {
            // TODO
            if(sizes[stackNum]==0)
            return true;
            else
            return false;
        }
      
        // indexOfTop - this is helper method for push, pop and peek methods
      
        private int indexOfTop(int stackNum) {
          // TODO
          int offset = stackNum*stackCapacity;              //let stackNum be 0 ; then offset = 0*3 = 0
          int size = sizes[stackNum];                       //extracting the size of the second stack i.e 3 [which will give the idea of how many elements are already there]
          return offset+size-1;                             //let size be 3 which means that first stack is full then return = 0+3-1=2 which is the required index
          
        }
      
        // push
        public void push(int stackNum, int value) {
          // TODO
          if(isFull(stackNum))
          System.out.println("The Stack is Full");
          else
          {
              sizes[stackNum]++;                          //increasing the size of the inner stack 
              values[indexOfTop(stackNum)]=value;
          }
        }
      
        // pop
        public int pop(int stackNum) {
          // TODO
          if(isEmpty(stackNum))
          {
              System.out.println("Stack is Empty");
              return -1;
          }
          else
          {
              int topIndex=indexOfTop(stackNum);
              int value=values[topIndex];
              values[topIndex]=0;
              sizes[stackNum]--;
              return value;
          }
        }
      
        // peek
      
        public int peek(int stackNum) {
          // TODO
          if(isEmpty(stackNum))
          {
              System.out.println("Stack is Empty");
              return -1;
          }
          else
          return values[indexOfTop(stackNum)];
        }
      
        public static void main(String[] args) {
            ThreeInOne obj = new ThreeInOne(3);
            obj.push(0, 1);
            obj.push(0, 2);
            obj.push(0, 3);
            obj.push(1, 4);
            obj.push(1, 5);
            obj.push(1, 6);
            obj.push(2, 7);
            obj.push(2, 8);
            obj.push(2, 9);

            System.out.println(obj.peek(0));
            System.out.println(obj.pop(0));

            System.out.println(obj.peek(0));
            System.out.println(obj.pop(0));

            System.out.println(obj.peek(0));
            System.out.println(obj.pop(0));

            System.out.println(obj.peek(1));
            System.out.println(obj.pop(1));

            System.out.println(obj.peek(1));
            System.out.println(obj.pop(1));

            System.out.println(obj.peek(1));
            System.out.println(obj.pop(1));

            System.out.println(obj.peek(2));
            System.out.println(obj.pop(2));

            System.out.println(obj.peek(2));
            System.out.println(obj.pop(2));

            System.out.println(obj.peek(2));
            System.out.println(obj.pop(2));



        }
      
}

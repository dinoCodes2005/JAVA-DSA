public class CircularMain {
    public static void main(String[] args) {
        CircularQueue cQ=new CircularQueue(5);
        System.out.println(cQ.isEmpty());
        cQ.enQueue(3);
        cQ.enQueue(1);
        cQ.enQueue(2);
        cQ.enQueue(8);
        cQ.enQueue(7);
        System.out.println(cQ.isFull());
        System.out.println(cQ.deQueue());
        System.out.println(cQ.peek());
        cQ.deleteQueue();

    }
}

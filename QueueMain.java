public class QueueMain {
    public static void main(String[] args) {
        QueueArray newQueue = new QueueArray(5);
        System.out.println(newQueue.isEmpty());
        newQueue.enQueue(5);
        newQueue.enQueue(8);
        newQueue.enQueue(1);
        newQueue.enQueue(6);
        newQueue.enQueue(2);

        System.out.println(newQueue.isFull());
        System.out.println(newQueue.deQueue());
        System.out.println(newQueue.peek());
        newQueue.deleteQueue();
    }
}

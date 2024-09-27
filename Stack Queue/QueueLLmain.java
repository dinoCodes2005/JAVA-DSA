

public class QueueLLmain {
    public static void main(String[] args) {
        QueueLL qLL = new QueueLL();
        qLL.isEmpty();
        qLL.enQueue(5);
        qLL.enQueue(8);
        qLL.enQueue(1);
        qLL.enQueue(2);
        qLL.enQueue(6);
        qLL.deQueue();
        System.out.println(qLL.peek());
        qLL.deleteQueue();

    }
}

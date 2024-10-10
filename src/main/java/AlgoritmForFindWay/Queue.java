package AlgoritmForFindWay;

public class Queue {
    private int size = 101;
    private int [] array = new int[size];
    private int head;
    private int tail;
    private int count;

    public Queue() {
        head = 0;
        tail = -1;
        count = 0;
    }
    public void insert(int value) {
        if (tail == size - 1) {
            tail = -1;
        }
        array[++tail] = value;
        count++;
    }
    public int remove() {
        if(head == size){
            head = 0;
        }
        count--;
        return array[head++];
    }
    public boolean isEmpty() {
        return count == 0;
    }
}

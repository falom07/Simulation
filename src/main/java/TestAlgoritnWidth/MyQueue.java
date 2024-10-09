package TestAlgoritnWidth;

public class MyQueue {
    private int [] array;
    private int size = 11;
    private int head;
    private int tail;
    private int count;

    public MyQueue() {
        array = new int[size];
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

package com.example.talent.sep;

public class RingBuffer {
    private int front;
    private int end;
    private int size;
    private int capacity = 100;
    private char[] queue;

    public RingBuffer() {
        initialize();

    }

    public void enqueue(char value) {
        if (isFull()){
            dequeue();
        }
        if (isEmpty()) {
            front = 0;
        }
        if (end == capacity - 1) {
            end = -1;
        }
        queue[++end] = value;
        size++;
    }

    public void dequeue() {
        if (front == capacity) {
            front = -1;
        }
        queue[front] = '-';
        front++;
        size--;

    }

    public void empty(){
        initialize();
    }
    private void initialize(){
        queue = new char[capacity];
        front = -1;
        end = -1;
        size=0;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public String getAlltoStr(){
        if (isEmpty()) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = front; i <=end; i++) {
            sb.append(queue[i]);
        }
        return sb.toString();

    }
}

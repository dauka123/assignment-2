import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    MyLinkedList myLinkedListQueue = new <T>MyLinkedList();

    MyLinkedListQueue() {}
    public void enqueue(T element) {
        myLinkedListQueue.add(element);
    }
    public T dequeue() {
        return (T) myLinkedListQueue.remove(0);
    }
    public T peek(){
        isEmptyThrowException();
        return (T) myLinkedListQueue.get(0);
    }
    public int size() {
        return myLinkedListQueue.size();
    }
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
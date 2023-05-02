import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    MyLinkedList myLinkedListQueue = new <T>MyLinkedList();

    MyLinkedListQueue() {}
    /*
      enqueue  - method in queue, to add  an element at the end of the queue.
    */
    public void enqueue(T element) {
        myLinkedListQueue.add(element);
    }
    /*
      dequeue - removes and returns the front element of the queue.
    */
    public T dequeue() {
        return (T) myLinkedListQueue.remove(0);
    }
    /*
      peek - returns the first elements of the queue.
    */
    public T peek(){
        isEmptyThrowException();
        return (T) myLinkedListQueue.get(0);
    }
    /*
      size - to get the size of the queue
    */
    public int size() {
        return myLinkedListQueue.size();
    }
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
    /*
      isEmpty - to check is queue empty or not
    */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
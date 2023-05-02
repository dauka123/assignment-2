public class MyArrayListQueue<T> {
    MyArrayList myArrayListQueue = new <T>MyArrayList();

    MyArrayListQueue() {}
    /*
      enqueue  - method in queue to add  an element at the end of the queue.
    */
    public void enqueue(T element) {
        myArrayListQueue.add(element);
    }
    /*
      dequeue - removes and returns the front element of the queue.
    */
    public T dequeue() {
        return (T) myArrayListQueue.remove(0);
    }
    /*
      peek - returns the first elements of the queue.
    */
    public T peek() throws NoSuchFieldException {
        isEmptyThrowException();
        return (T) myArrayListQueue.get(0);
    }
    /*
      size - to get the size of the queue
    */
    public int size() {
        return myArrayListQueue.size();
    }
    private void isEmptyThrowException() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException();
        }
    }
    /*
      isEmpty - to check is queue empty or not
    */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
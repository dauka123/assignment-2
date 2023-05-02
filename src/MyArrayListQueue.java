public class MyArrayListQueue<T> {
    MyArrayList myArrayListQueue = new <T>MyArrayList();

    MyArrayListQueue() {}
    public void enqueue(T element) {
        myArrayListQueue.add(element);
    }
    public T dequeue() {
        return (T) myArrayListQueue.remove(0);
    }
    public T peek() throws NoSuchFieldException {
        isEmptyThrowException();
        return (T) myArrayListQueue.get(0);
    }
    public int size() {
        return myArrayListQueue.size();
    }
    private void isEmptyThrowException() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException();
        }
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
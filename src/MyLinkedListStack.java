import java.util.EmptyStackException;

public class MyLinkedListStack<T> {

    MyLinkedList myLinkedListStack = new <T>MyLinkedList();
    MyLinkedListStack() {}
    public void push(T element) {
        myLinkedListStack.add(element, 0);
    }
    public T pop() {
        isEmptyThrowException();
        return (T) myLinkedListStack.remove(0);
    }
    public T peek() {
        isEmptyThrowException();
        return (T) myLinkedListStack.get(0);
    }
    public int size() {
        return myLinkedListStack.size();
    }
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
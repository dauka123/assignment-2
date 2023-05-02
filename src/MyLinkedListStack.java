import java.util.EmptyStackException;

public class MyLinkedListStack<T> {

    MyLinkedList myLinkedListStack = new <T>MyLinkedList();

    MyLinkedListStack() {}
    /*
      push - method in stack, to add   an element at the top of the stack.
    */
    public void push(T element) {
        myLinkedListStack.add(element, 0);
    }
    /*
      pop - removes and returns the top element if the stack
    */
    public T pop() {
        isEmptyThrowException();
        return (T) myLinkedListStack.remove(0);
    }
    /*
      peek - returns the first elements of the stack
    */
    public T peek() {
        isEmptyThrowException();
        return (T) myLinkedListStack.get(0);
    }
    /*
      size - to get the size of the stack
    */
    public int size() {
        return myLinkedListStack.size();
    }
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
    /*
      isEmpty - to check is stack empty or not
    */
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
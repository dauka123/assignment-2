import java.util.EmptyStackException;

public class MyArrayListStack<T> {
    MyArrayList myArrayListStack = new <T>MyArrayList();

    MyArrayListStack() {}
    /*
      push - adds an element to the top of the stack.
    */
    public void push(T element) {
        myArrayListStack.add(element, 0);
    }
    /*
      pop - removes and returns the top element if the stack.
    */
    public T pop() {
        isEmptyThrowException();
        return (T) myArrayListStack.remove(0);
    }
    /*
      peek - returns the first elements of the stack.
    */
    public T peek() {
        isEmptyThrowException();
        return (T) myArrayListStack.get(0);
    }
    /*
      size - to get the size of the stack
    */
    public int size() {
        return myArrayListStack.size();
    }
    /*
      isEmptyThrowException - to check is stack empty or not
    */
    private void isEmptyThrowException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
}

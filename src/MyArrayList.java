public class MyArrayList<T> implements MyList{
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    private void checkIndex(int index){
        if (size <= index || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }
    private void increaseLength(){
        if (arr.length == size){
            T[] newArr = (T[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public void add(Object item) {
        increaseLength();
        arr[size++] = (T) item;
    }
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    @Override
    public Object remove(int index) {
        checkIndex(index);
        for(int i= index + 1; i<=size; i++){
            arr[i-1] = arr[i];
        }
        this.size--;
        return true;
    }
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++){
            if (o == arr[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item, int index) {
        increaseLength();
        checkIndex(index);
        for (int i = index + 1; i < size; i++){
            arr[i] = arr[i+1];
        }
        arr[index] = (T) item;
        size++;
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i > 0; i--){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void clear() {

    }

    @Override
    public void sort() {

    }
}
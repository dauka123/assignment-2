import java.util.Arrays;

public class MyArrayList<T> implements MyList{
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /*
      @ checkIndex - проверяет подходит ли индекс
      @ если индекс не подходит то выдает ошибку
    */
    private void checkIndex(int index){
        if (size <= index || index < 0){ // проверка индекса
            throw new IndexOutOfBoundsException();
        }
    }
    /*
      @ increaseLength - увеличивает длину массива в 2 раза при необходимости
      @ создает newArr затем переписывает все с arr в него
    */
    private void increaseLength(){
        if (arr.length == size){
            T[] newArr = (T[]) new Object[arr.length * 2]; // увеличение массива в 2 раза
            for (int i = 0; i < arr.length; i++){  // переписывает с одного в другой
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }
    @Override
    public int size() {
        return this.size;  // возвращает длину массива
    }
    /*
      @ add - добавляет item в массив
      @ увеличивает размер при необходимости, затем добавляет
    */
    @Override
    public void add(Object item) {
        increaseLength(); // увеличение
        arr[size++] = (T) item; // добавление
    }
    /*
      @ get - возвращает элемент с массива
      @ проверяет индекс
      @ return - возвращает элемент
    */
    @Override
    public Object get(int index) {
        checkIndex(index); // проверка
        return arr[index]; // возвращение
    }
    /*
      @ remove - удаляет элемент в определенном индексе
      @ переписывает остальные элементы в size-1
    */
    @Override
    public Object remove(int index) {
        checkIndex(index); // проверка индекса
        for(int i= index + 1; i<=size; i++){
            arr[i-1] = arr[i]; // переписывание
        }
        this.size--; // уменьшение размера
        return true;
    }
    /*
      @ contains - проверяет есть ли элемент в массиве
      @ return - возвращает true если элемент есть и false если элемента нет
    */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++){
            if (o == arr[i]){
                return true;
            }
        }
        return false;
    }
    /*
      @ add - добаавляет элемент в определенный индекс
      @ увеличивает размер при необходимости
      @ проверяет индекс
      @ добавляет элемент и изменяет все остальные элементы
    */
    @Override
    public void add(Object item, int index) {
        increaseLength(); // увеличение
        checkIndex(index); // проверка
        for (int i = index + 1; i < size; i++){
            arr[i] = arr[i+1]; // изменение индексов элементов
        }
        arr[index] = (T) item;
        size++;
    }
    /*
      @ remove - удаляет элемент если он есть в массиве
      @ return - возвращает true если элемент удален и false если элемента нет в массиве
    */
    @Override
    public boolean remove(Object item) {
        int index = indexOf(item); // находит индекс массива
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }
    /*
      @ indexOf - находит индекс определенного элемента
      @ return - возвращает индекс элемента
    */
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    /*
      @ lastIndexOf - находит индекс последнего определенного элемента
      @ return - возвращает индекс элемента
    */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i > 0; i--){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
    /*
      @ clear - создает новый массив
    */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /*
      @ sort - сортирует элементы массива
    */
    @Override
    public void sort() {
        Arrays.sort((T[]) arr, 0, size);
    }
    public void addAllElements(int[] array, int index){
        T[] arr2 = new T[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] =  arr[index+i];
        }
        for (int i = 0; i < array.length; i++) {
            add(array[i],index+i);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[size + i] = arr2[i];
        }
    }
}
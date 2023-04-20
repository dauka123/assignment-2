# Assignment2 Documentation
### MyArrayList
+ ### checkIndex
**description:** checks the index entered by the user, and if it does not match, it outputs an error, but if the index is correct, it continues to run the code.
```ruby
private void checkIndex(int index){
        if (size <= index || index < 0){ // проверка индекса
            throw new IndexOutOfBoundsException();
        }
    }
```
+ ### increaseLength
**description:** creates a new array that is twice the size of the old one, then overwrites all the elements of the old one into it.
```ruby
private void increaseLength(){
        if (arr.length == size){
            T[] newArr = (T[]) new Object[arr.length * 2]; // увеличение массива в 2 раза
            for (int i = 0; i < arr.length; i++){  // переписывает с одного в другой
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }
```
+ ### size
**description:** returns the number of elements in the array.
```ruby
public int size() {
        return this.size;  // возвращает длину массива
    }
```
+ ### add
**description:** increases the size if necessary, then adds the item to the array.
```ruby
public void add(Object item) {
        increaseLength(); // увеличение
        arr[size++] = (T) item; // добавление
    }
```
+ ### get
**description:** method gets the index, checks it, then returns the element in the index.
```ruby
public Object get(int index) {
        checkIndex(index); // проверка
        return arr[index]; // возвращение
    }
```
+ ### remove
**description:** removes an element at a specific index then rewrites the remaining elements in size-1.
```ruby
public Object remove(int index) {
        checkIndex(index); // проверка индекса
        for(int i= index + 1; i<=size; i++){
            arr[i-1] = arr[i]; // переписывание
        }
        this.size--; // уменьшение размера
        return true;
    }
```
+ ### contains
**description:** checks if there is an item in the array then returns true if there is an item and false if there is no item.
```ruby
public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++){
            if (o == arr[i]){
                return true;
            }
        }
        return false;
    }
```
+ ### add
**description:** increases the size if necessary then checks the index, adds an element to a certain index and changes all the other elements.
```ruby
public void add(Object item, int index) {
        increaseLength(); // увеличение
        checkIndex(index); // проверка
        for (int i = index + 1; i < size; i++){
            arr[i] = arr[i+1]; // изменение индексов элементов
        }
        arr[index] = (T) item;
        size++;
    }
```
+ ### remove
**description:** removes the item if it is in the array, returns true if the item is removed and false if the item is not in the array.
```ruby
public boolean remove(Object item) {
        int index = indexOf(item); // находит индекс массива
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }
```
+ ### indexOf
**description:** finds the index of a certain element then returns its index.
```ruby
public int indexOf(Object o) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
```
+ ### lastIndexOf
**description:** finds the index of the last defined element, returns the index of the element.
```ruby
public int lastIndexOf(Object o) {
        for (int i = size; i > 0; i--){
            if (arr[i] == o){
                return i;
            }
        }
        return -1;
    }
```
+ ### clear
**description:** this method clears the array by setting its size to 0 and creating a new array of length 5.
```ruby
public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
```
+ ### sort
**description:** sorts the elements of the array.
```ruby
public void sort() {
        Arrays.sort((T[]) arr, 0, size);
    }
```


# Assignment2 Documentation
### MyArrayList
+ ### checkIndex
**description:** wsfa;osdbfa
```ruby
private void checkIndex(int index){
        if (size <= index || index < 0){ // проверка индекса
            throw new IndexOutOfBoundsException();
        }
    }
```
+ ### increaseLength
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
```ruby
public int size() {
        return this.size;  // возвращает длину массива
    }
```
+ ### add
**description:** wsfa;osdbfa
```ruby
public void add(Object item) {
        increaseLength(); // увеличение
        arr[size++] = (T) item; // добавление
    }
```
+ ### get
**description:** wsfa;osdbfa
```ruby
public Object get(int index) {
        checkIndex(index); // проверка
        return arr[index]; // возвращение
    }
```
+ ### remove
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
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
**description:** wsfa;osdbfa
```ruby
public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
```
+ ### sort
**description:** wsfa;osdbfa
```ruby
public void sort() {
        Arrays.sort((T[]) arr, 0, size);
    }
```


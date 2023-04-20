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
### MyLinkedList
+ ### size
**description:** this method returns the number of elements in the list.
```ruby
public int size() {
        return this.size;
    }
```
+ ### contains
**description:** returns true if this list contains the specified element
```ruby
public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
```
+ ### add
**description:** adds a new element to the end of the linked list.
```ruby
public void add(Object item) {
        Node<E> newNode = (Node<E>) new Node<>(item, null, tail);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
```
+ ### add
**description:** adds an element to the specific index.
```ruby
public void add(Object item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        Node<E> node = getNode(index);
        Node<E> newNode = (Node<E>) new Node<>(item, node, node.previous);
        if (node.previous == null) {
            head = newNode;
        } else {
            node.previous.next = newNode;
        }
        node.previous = newNode;
        size++;
    }
```
+ ### remove
**description:** removes the given object from the linked list, if it exists.
```ruby
public boolean remove(Object item) {
        Node<E> node = head;
        while (node != null) {
            if (node.item.equals(item)) {
                removeNode(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }
```
+ ### remove
**description:** removes the element at the given index from the linked list.
```ruby
public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        removeNode(node);
        return node.item;
    }
```
+ ### clear
**description:** removes all of the elements from this list.
```ruby
public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
```
+ ### get
**description:** returns an element at the given index.
```ruby
public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }
```
+ ### indexOf
**description:** returns the index of the first occurrence of the given object in the linked list.
```ruby
public int indexOf(Object o) {
        int i = 0;
        Node<E> nextNode = this.head;
        while (nextNode != null) {
            if (this.head.item.equals(o)) return i;
            nextNode = nextNode.next;
            i++;
        }
        return -1;
    }
```
+ ### lastIndexOf
**description:** returns the last index of element.
```ruby
public int lastIndexOf(Object o) {
        int i = size()-1;
        Node<E> node = this.tail;
        while (i >= 0) {
            if (node.equals(o)) return i;
            node = this.tail.previous;
            i--;
        }
        return -1;
    }
```

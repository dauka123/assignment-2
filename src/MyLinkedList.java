import java.util.Arrays;

public class MyLinkedList<E> implements MyList{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.previous = prev;
        }
    }
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    /*
      @ size - возвращает длину LinkedList
    */
    @Override
    public int size() {
        return this.size;
    }
    /*
      @ contains - ищем элемент в листе
      @ return - возвращает true если элемент в листе
    */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    /*
      @ add - добавляет объект в LinkedList
    */
    @Override
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
    /*
      @ add - добавляет объект в LinkedList в определенный индекс
      @ проверяет индекс, если он не корректный то выдает ошибку
    */
    @Override
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
    private Node<E> getNode(int index) {
        if (index < size / 2) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
            return node;
        }
    }
    /*
      @ remove удаляет объект из LinkedList
      @ return true если обьект удален
    */
    @Override
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
    private void removeNode(Node<E> node) {
        if (node.previous == null) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }
        if (node.next == null) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }
        size--;
    }
    /*
      @ remove удаляет объект из LinkedList в определенном индексе
      @ return Object
    */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        removeNode(node);
        return node.item;
    }
    /*
      @ clear очищает LinkedList
    */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /*
      @ get возвращает объект из LinkedList в опреденном индексе
      @ return E
    */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }
    /*
      @ indexOf ищет идекс первого вхождения объекта
      @ return возвращает индекс
    */
    @Override
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
    /*
      @ lastIndexOf ищет индекс последнего вхождения объекта
      @ return возвращает индекс
    */
    @Override
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

    @Override
    public void sort() {
        Object[] array = toArray();
        Arrays.sort((E[]) array);
        clear();
        for (Object item : array) {
            add((E) item);
        }
    }

    private Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }
}

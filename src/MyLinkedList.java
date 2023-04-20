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
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

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

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        removeNode(node);
        return node.item;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}

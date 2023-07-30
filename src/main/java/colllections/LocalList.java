package colllections;

import java.util.Iterator;

public class LocalList<T> implements Iterable<T> {

    private T[] arr;

    private int size;

    public LocalList(int listSize) {
        this.arr = (T[]) new Object[listSize];
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {
        arr[size++] = element;
    }

    public T get(int index) {
        return arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private int currentSize;

        @Override
        public boolean hasNext() {
            return currentSize < size;
        }

        @Override
        public T next() {
            return arr[currentSize++];
        }
    }
}

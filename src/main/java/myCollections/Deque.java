package myCollections;

public interface Deque<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    E first();
    E last();
    void addLast(E e);
    E removeFirst();
    E removeLast();
}

package main.data_structures.lists;

public interface List<T> {
    void addFirst(T element);
    void addLast(T element);
    void add(int index, T element);

    T removeFirst();
    T removeLast();
    T remove(T element);
    T remove(int index);

    boolean isEmpty();
    int size();
    void clear();

    boolean contains(T element);
    T search(int index);

    void replace(T toBeReplacedElement, T newElement);
    void replace(int index, T element);

    String toString();
}

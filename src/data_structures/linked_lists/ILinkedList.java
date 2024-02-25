package data_structures.linked_lists;

public interface ILinkedList<T> {

    void addFirst(T element);
    void addLast(T element);
    void add(int index, T element);

    INode<T> removeFirst();
    INode<T> removeLast();
    INode<T> remove(T element);
    INode<T> remove(int index);

    boolean isEmpty();
    int size();
    void clear();

    boolean contains(T element);
    INode<T> search(int index);

    String toString();
}

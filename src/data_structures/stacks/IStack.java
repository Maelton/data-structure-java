package data_structures.stacks;

public interface IStack<T> {
    
    boolean isFull();
    boolean isEmpty();
    void push(T element);
    T pop();
    T peek();
}

package main.data_structures.stacks;

public interface Stack<T> {
    
    boolean isFull();
    boolean isEmpty();
    void push(T element);
    T pop();
    T peek();
}

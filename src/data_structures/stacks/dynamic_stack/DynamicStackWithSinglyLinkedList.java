package data_structures.stacks.dynamic_stack;


import data_structures.stacks.IStack;
import data_structures.linked_lists.singly_linked_list.SinglyLinkedList;

public class DynamicStackWithSinglyLinkedList<T> implements IStack<T>{
    
    SinglyLinkedList<T> storage = new SinglyLinkedList<T>();

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public void push(T element) {
        storage.addFirst(element);
    }

    @Override
    public T pop() {
        return storage.removeFirst().getData();
    }

    @Override
    public T peek() {
        if( this.isEmpty() ) {
            return null;
        } else {
            return storage.search(0).getData();
        }
    }  
}
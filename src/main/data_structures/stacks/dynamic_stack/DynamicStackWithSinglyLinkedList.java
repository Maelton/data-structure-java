package main.data_structures.stacks.dynamic_stack;

import main.data_structures.lists.linked_lists.singly_linked_list.SinglyLinkedList;
import main.data_structures.stacks.Stack;

public class DynamicStackWithSinglyLinkedList<T> implements Stack<T>{
    
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
        if( this.isEmpty() ) return null;

        return storage.search(0).getData();
    }  
}
package main.data_structures.stacks.dynamic_stack;

import main.data_structures.stacks.Stack;

public class DynamicStackWithArray<T> implements Stack<T> {

    private Object[] storage;
    private int storageCapacity;
    private int size;

    @Override
    public boolean isFull() {
        return this.size == this.storageCapacity;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void push(T element) {
        if(this.isFull()) {
            this.doubleStackCapacity();
            this.storage[this.size] = element;
            this.size++;
        } else {
            this.storage[this.size] = element;
            this.size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(this.isEmpty()) return null;

        if(this.size <= this.storageCapacity/4 && this.storageCapacity >= 20) {
            this.reduceStackCapacityBy2();
            T peekElement = (T) this.storage[size-1];
            this.storage[size-1] = null;
            this.size--;
            return peekElement;
        }

        T peekElement = (T) this.storage[size-1];
        this.storage[size-1] = null;
        this.size--;
        return peekElement;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return this.isEmpty() ? null : (T) this.storage[size-1];
    }

    public void doubleStackCapacity() {
        Object[] newStorage = new Object[this.storageCapacity*2];
            
        for(int index = 0; index < this.storageCapacity; index++) {
            newStorage[index] = this.storage[index];
        }

        this.storage = newStorage;
        this.storageCapacity *= 2;
    }
    
    public void reduceStackCapacityBy2() {
        Object[] newStorage = new Object[this.storageCapacity/2];
            
        for(int index = 0; index < this.storageCapacity/4; index++) {
            newStorage[index] = this.storage[index];
        }

        this.storage = newStorage;
        this.storageCapacity /= 2;
    }

    public DynamicStackWithArray() {
        this.storageCapacity = 10;
        this.storage = new Object[this.storageCapacity];
        this.size = 0;
    }
}
